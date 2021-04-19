package br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.leroy.order;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.portobello.OrderDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.commons.BatchNewItem;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "leroy-purchase-order-batch-new-item")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LeroyBatchNewItem extends BatchNewItem<OrderDTO> {
    public LeroyBatchNewItem() {
    }

    public LeroyBatchNewItem(OrderDTO purchaseOrder) {
        super(purchaseOrder);
    }
}
