package br.com.portobello.digital.partnerspurchaseorderbatch.service.batch;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.order.OrderLeroyDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.order.OrderResponseLeroyDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.leroy.order.LeroyBatchNewItem;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.events.RabbitEvent;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.events.RabbitOperationErrorEvent;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.factory.OrderFactory;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.vos.leroy.FilterVo;
import br.com.portobello.digital.partnerspurchaseorderbatch.repository.leroy.order.LeroyBatchNewItemRepository;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.broker.PurchaseOrderOutboundBrokerPartnersPurchase;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.leroy.LeroyPurchaseOrderService;
import br.com.portobello.digital.partnerspurchaseorderbatch.utils.Constants;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import static br.com.portobello.digital.partnerspurchaseorderbatch.utils.Constants.LEROY_ACTIVE_PURCHASE_ORDER_LIST_CODE;
import static br.com.portobello.digital.partnerspurchaseorderbatch.utils.Constants.LEROY_PAYMENT_KEY_TERM;

@Service
public class LeroyPurchaseOrderBatchService {

    Logger logger = LoggerFactory.getLogger(LeroyPurchaseOrderBatchService.class);


    @Autowired
    private OrderFactory orderFactory;

    @Autowired
    private LeroyPurchaseOrderService leroyPurchaseOrderService;

    @Autowired
    private PurchaseOrderOutboundBrokerPartnersPurchase outbound;

    @Autowired
    private LeroyBatchNewItemRepository batchNewItemRepository;


    public void saveAndPublish(OrderLeroyDTO orderLeroyDTO) {
        try {
            logger.info("Saving and Publishing PBA purchase order into database and rabbitmq, ID : {}", orderLeroyDTO.getHeader().getOrderNumber());
            var orderDTO = orderFactory.createOrderDTO(orderLeroyDTO);
            batchNewItemRepository.save(new LeroyBatchNewItem(orderDTO));
            outbound.sendMessagePartnersPurchaseOrderRequested(new RabbitEvent<>(orderDTO));
        } catch (Exception e) {
            outbound.sendMessagePartnersPurchaseOrderOperationError(new RabbitOperationErrorEvent(e.getMessage(), e.getLocalizedMessage(), HttpStatus.BAD_GATEWAY));
        }
    }

    public OrderResponseLeroyDTO getOrderLeroy(FilterVo filterVo) {
        OrderResponseLeroyDTO purchaseOrders;
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss").withZone(ZoneId.systemDefault());
            //purchaseOrders = leroyPurchaseOrderService.getPurchaseOrders(dtf.format(LocalDateTime.of(2020,8,25,00,00,00)),dtf.format(LocalDateTime.of(2020,9,01,00,00,00)), filterVo.getOffset(), Constants.LEROY_LIMIT_ITENS_PER_PAGE);
            purchaseOrders = leroyPurchaseOrderService.getPurchaseOrders(dtf.format(filterVo.getBegin()), dtf.format(filterVo.getEnd()), filterVo.getOffset(), Constants.LEROY_LIMIT_ITENS_PER_PAGE);

        } catch (FeignException e) {
            outbound.sendMessagePartnersPurchaseOrderOperationError(new RabbitOperationErrorEvent(e.getMessage(), e.getLocalizedMessage(), HttpStatus.BAD_GATEWAY));
            throw new HttpServerErrorException(HttpStatus.BAD_GATEWAY, e.getLocalizedMessage());
        }
        return purchaseOrders;
    }

    public OrderResponseLeroyDTO filterActivePurchases(OrderResponseLeroyDTO purchaseOrders) {
        if (purchaseOrders.getItems() == null) {
            return purchaseOrders;
        }

        purchaseOrders.setItems(
                purchaseOrders.getItems().stream().filter(order ->
                        LEROY_ACTIVE_PURCHASE_ORDER_LIST_CODE.contains(order.getHeader().getOrderStatus())
                                && order.getHeader().getPaymentKeyTerms().equals(LEROY_PAYMENT_KEY_TERM)
                ).collect(Collectors.toList())
        );

        return purchaseOrders;
    }
}
