package br.com.portobello.digital.partnerspurchaseorderbatch.service.batch;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.pba.CustomerPbaDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.pba.PurchaseOrderPbaDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.pba.SalesOrderPbaDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.portobello.OrderDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.pba.order.PbaBatchNewItemOrder;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.enums.EventStatusType;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.events.RabbitEvent;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.events.RabbitOperationErrorEvent;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.factory.OrderFactory;
import br.com.portobello.digital.partnerspurchaseorderbatch.repository.pba.order.PbaBatchNewItemOrderRepository;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.broker.PurchaseOrderOutboundBrokerPartnersPurchase;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.pba.PbaCustomerService;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.pba.PbaPurchaseOrderService;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.pba.PbaSalesOrderService;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.HttpServerErrorException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class PbaPurchaseOrderBatchService {

    Logger logger = LoggerFactory.getLogger(PbaPurchaseOrderService.class);


    @Value("${app.pba.defaultCustomerNumber}")
    private String defaultCustomerNumber;

    @Value("${app.pba.supplierId}")
    private List<String> supplierId;

    @Value("${app.pba.allowedTransactionStatus}")
    private List<String> allowedTransactionStatus;

    @Autowired
    private PbaPurchaseOrderService purchaseOrderService;

    @Autowired
    private PbaCustomerService customerService;

    @Autowired
    private PbaSalesOrderService salesOrderService;

    @Autowired
    private OrderFactory orderFactory;

    @Autowired
    private PbaBatchNewItemOrderRepository batchNewItemRepository;

    @Autowired
    private PurchaseOrderOutboundBrokerPartnersPurchase outbound;

    @TransactionalEventListener
    public void completeAndPublish(PbaBatchNewItemOrder newItem) {
        try {
            OrderDTO orderDTO = newItem.getPurchaseOrder();
            logger.info("Saving and Publishing PBA purchase order into database and rabbitmq : id {} , customerId {}, salesforceId {}", newItem.getId(), newItem.getCustomerId(), newItem.getSalesorderId());
            orderDTO.getCliente().setSoldToFiscalId(this.getSoldToFiscalId(newItem));
            orderDTO.setCustomPurchaseOrderNumber2(this.getCustomPONumber2(newItem.getSalesorderId()));
            outbound.sendMessagePartnersPurchaseOrderRequested(new RabbitEvent<>(orderDTO));
            newItem.setStatusType(EventStatusType.PUBLISHED);
            batchNewItemRepository.save(newItem);
        } catch (Exception e) {
            outbound.sendMessagePartnersPurchaseOrderOperationError(new RabbitOperationErrorEvent(e.getMessage(), e.getLocalizedMessage(), HttpStatus.BAD_GATEWAY));
        }
    }

    private String getCustomPONumber2(Long salesorderId) {
        List<SalesOrderPbaDTO> salesOrders = salesOrderService.getSalesOrders(salesorderId);
        if (salesOrders.size() != 0) {
            return salesOrders.get(0).getCustomerPO();
        }
        return null;
    }

    private String getSoldToFiscalId(PbaBatchNewItemOrder newItem) {
        if (newItem.getPurchaseOrder().getOrderType().equalsIgnoreCase("Dropship")) {
            List<CustomerPbaDTO> customers = customerService.getCustomers(newItem.getCustomerId());
            if (customers.size() == 0) {
                return defaultCustomerNumber;
            }
            return customers.get(0).getEinNumber() == null ? defaultCustomerNumber : customers.get(0).getEinNumber();
        }
        return defaultCustomerNumber;
    }

    public List<PurchaseOrderPbaDTO> getOrderPba(LocalDateTime initialTime) {
        List<PurchaseOrderPbaDTO> purchaseOrders = new ArrayList<>();
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a").withZone(ZoneId.systemDefault());
            for (int i = 0; i < supplierId.size(); i++) {
                logger.info("Getting purchase order from supllier id : {}", supplierId.get(i));
                purchaseOrders.addAll(purchaseOrderService.getPurchaseOrders(dtf.format(initialTime).substring(0, 10), supplierId.get(i)));
                //purchaseOrders.addAll(purchaseOrderService.getPurchaseOrders(dtf.format(LocalDateTime.of(2021, 02, 17, 00, 00, 00)), supplierId.get(i)));                logger.info("Added {} purchase order to integration list", purchaseOrders.size());
            }
        } catch (FeignException e) {
            outbound.sendMessagePartnersPurchaseOrderOperationError(new RabbitOperationErrorEvent(e.getMessage(), e.getLocalizedMessage(), HttpStatus.BAD_GATEWAY));
            throw new HttpServerErrorException(HttpStatus.BAD_GATEWAY, e.getLocalizedMessage());
        }
        return this.getValidPurchaseOrders(purchaseOrders);
    }

    private List<PurchaseOrderPbaDTO> getValidPurchaseOrders(List<PurchaseOrderPbaDTO> purchaseOrders) {
        List<PurchaseOrderPbaDTO> validPurchaseOrders = new ArrayList<>();
        if (ObjectUtils.isEmpty(purchaseOrders)) {
            return purchaseOrders;
        }

        purchaseOrders.forEach(po -> {
            validationRule(validPurchaseOrders, po);
        });
        return validPurchaseOrders;
    }

    private void validationRule(List<PurchaseOrderPbaDTO> validPurchaseOrders, PurchaseOrderPbaDTO po) {
        if (po.getTransactionStatus() == null && allowedTransactionStatus.contains("null")) {
            validPurchaseOrders.add(po);
        }
        allowedTransactionStatus.forEach(allowedStatus -> {
            if( ObjectUtils.isEmpty(po.getTransactionStatus()) && po.getTransactionStatus().equalsIgnoreCase(allowedStatus)) {
                validPurchaseOrders.add(po);
            }
        });
    }

    public void integrate() {
        List<PbaBatchNewItemOrder> pbaNewItems = batchNewItemRepository.findByStatusType(EventStatusType.RECEIVED);
        pbaNewItems.forEach(this::completeAndPublish);
    }
}
