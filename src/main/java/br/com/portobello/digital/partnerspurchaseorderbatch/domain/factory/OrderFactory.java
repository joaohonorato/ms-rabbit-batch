package br.com.portobello.digital.partnerspurchaseorderbatch.domain.factory;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.order.OrderLeroyDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.pba.PurchaseOrderPbaDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.portobello.EntregaDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.portobello.ItemDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.portobello.OrderDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.enums.CurrencyCodeType;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.enums.DomesticForeignIndType;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.enums.SourceType;
import br.com.portobello.digital.partnerspurchaseorderbatch.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
public class OrderFactory {

    Logger logger = LoggerFactory.getLogger(OrderFactory.class);

    @Autowired
    ClienteFactory clienteFactory;

    @Autowired
    EntregaFactory entregaFactory;

    @Autowired
    ItemFactory itemFactory;

    public OrderDTO createOrderDTO(PurchaseOrderPbaDTO purchaseOrderPbaDTO) {
        logger.info("Creating OrderDTO from PBA Purchase Order");
        var orderDTO = new OrderDTO();
        orderDTO.setPayloadId(purchaseOrderPbaDTO.getTransactionNumber());
        orderDTO.setCustomPurchaseOrderNumber(purchaseOrderPbaDTO.getTransactionNumber());
        orderDTO.setCustomSalesOrderNumber(purchaseOrderPbaDTO.getSaleOrderReference());
        orderDTO.setOrderType(purchaseOrderPbaDTO.getDeliveryType());
        orderDTO.setCurrenceCode(CurrencyCodeType.USD.name());
        orderDTO.setSourceHdrId(purchaseOrderPbaDTO.getId().toString());
        orderDTO.setPricingDate(DateUtils.parseStringToDateFormatterPba(purchaseOrderPbaDTO.getTransactionDate()));
        orderDTO.setRequestDate(DateUtils.parseStringToDateFormatterPba(purchaseOrderPbaDTO.getRequestedShipDate()));
        orderDTO.setDomesticForeignInd(DomesticForeignIndType.F.name());
        orderDTO.setPaymentTermCode(purchaseOrderPbaDTO.getPaymentTerms());
        orderDTO.setOrderSource(SourceType.PBA.name());
        orderDTO.setCliente(clienteFactory.createClienteDTO(purchaseOrderPbaDTO));
        orderDTO.setEntrega(entregaFactory.createEntregaDTO(purchaseOrderPbaDTO));
        orderDTO.setItems(purchaseOrderPbaDTO.getPoProducts().stream().map(itemFactory::createItemDTO).collect(Collectors.toList()));
        return orderDTO;

    }

    public OrderDTO createOrderDTO(OrderLeroyDTO orderLeroyDTO) {
        logger.info("Creating OrderDTO from Leroy Purchase Order");
        var orderDTO = new OrderDTO();
        orderDTO.setPayloadId(orderLeroyDTO.getHeader().getOrderNumber());
        orderDTO.setOrderSource(SourceType.LEROY_MERLIN.name());
        orderDTO.setOrderType(orderLeroyDTO.getHeader().getDocumentType());
        orderDTO.setCustomPurchaseOrderNumber(orderLeroyDTO.getHeader().getOrderNumber());
        orderDTO.setDomesticForeignInd(DomesticForeignIndType.D.name());
        orderDTO.setPaymentTermCode(orderLeroyDTO.getHeader().getPaymentKeyTerms());
        orderDTO.setSoldFromFiscalId(orderLeroyDTO.getHeader().getFiscalID());
        LocalDateTime dateRequest = DateUtils.parseStringToDateFormatterLeroy(orderLeroyDTO.getHeader().getOrderCreationDate());
        orderDTO.setPricingDate(dateRequest);
        orderDTO.setRequestDate(dateRequest);
        orderDTO.setCliente(clienteFactory.createClienteDTO(orderLeroyDTO));
        orderDTO.setEntrega(new EntregaDTO());
        orderDTO.setItems(orderLeroyDTO.getItem().stream().map(itemLeroyDTO -> {
            ItemDTO itemDTO = itemFactory.createItemDTO(itemLeroyDTO);
            LocalDateTime dateDeliver = DateUtils.parseStringToDateFormatterLeroy(orderLeroyDTO.getHeader().getDeliveryDate());
            itemDTO.setRequestDate(dateDeliver);
            itemDTO.setScheduleShipDate(dateDeliver);
            return itemDTO;
        }).collect(Collectors.toList()));
        return orderDTO;

    }
}