package br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.leroy.order;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.commons.BatchesInfo;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "leroy-purchase-order-batches")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LeroyBatchesInfo extends BatchesInfo {
    public LeroyBatchesInfo() {
    }

    public LeroyBatchesInfo(LocalDateTime now) {
        super(now);
    }
}
