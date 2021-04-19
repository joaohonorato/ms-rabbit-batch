package br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.pba.order;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.portobello.OrderDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.commons.BatchNewItem;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.enums.EventStatusType;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pba-purchase-order-batch-new-item")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PbaBatchNewItemOrder extends BatchNewItem<OrderDTO> {
    @Id
    private String id;
    private EventStatusType statusType;
    private Integer customerId;
    private Long salesorderId;

    public PbaBatchNewItemOrder() {
        super();
    }

    public PbaBatchNewItemOrder(OrderDTO purchaseOrder) {
        super(purchaseOrder);
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Long getSalesorderId() {
        return salesorderId;
    }

    public void setSalesorderId(Long salesorderId) {
        this.salesorderId = salesorderId;
    }

    public EventStatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(EventStatusType statusType) {
        this.statusType = statusType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
