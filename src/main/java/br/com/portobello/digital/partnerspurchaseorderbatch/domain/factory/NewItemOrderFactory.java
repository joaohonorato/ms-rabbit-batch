package br.com.portobello.digital.partnerspurchaseorderbatch.domain.factory;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.pba.PurchaseOrderPbaDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.portobello.OrderDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.pba.order.PbaBatchNewItemOrder;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.enums.EventStatusType;
import org.springframework.stereotype.Component;

@Component
public class NewItemOrderFactory {
    public PbaBatchNewItemOrder createPbaNewItem(PurchaseOrderPbaDTO poDTO, OrderDTO orderDTO) {
        PbaBatchNewItemOrder newItem = new PbaBatchNewItemOrder();
        newItem.setId(poDTO.getId().toString());
        newItem.setCustomerId(poDTO.getCustomerID());
        newItem.setSalesorderId(poDTO.getSaleorderID());
        newItem.setStatusType(EventStatusType.RECEIVED);
        newItem.setPurchaseOrder(orderDTO);
        return newItem;
    }
}
