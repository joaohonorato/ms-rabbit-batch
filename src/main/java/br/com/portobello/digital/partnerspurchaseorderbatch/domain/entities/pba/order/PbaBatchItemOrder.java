package br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.pba.order;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.pba.PurchaseOrderPbaDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.commons.BatchItem;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.enums.SourceType;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "pba-purchase-order-batch-item")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PbaBatchItemOrder extends BatchItem<PurchaseOrderPbaDTO> {
    public PbaBatchItemOrder() {
    }

    public PbaBatchItemOrder(SourceType source, List<PurchaseOrderPbaDTO> purchaseOrders) {
        super(source, purchaseOrders);
    }
}
