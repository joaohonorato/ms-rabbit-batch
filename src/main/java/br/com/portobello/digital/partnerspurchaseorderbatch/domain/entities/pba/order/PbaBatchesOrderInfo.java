package br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.pba.order;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.commons.BatchesInfo;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "pba-purchase-order-batches")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PbaBatchesOrderInfo extends BatchesInfo {
    public PbaBatchesOrderInfo() {
        super();
    }

    public PbaBatchesOrderInfo(LocalDateTime now) {
        super(now);
    }
}
