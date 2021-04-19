package br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.leroy.vmi;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.commons.BatchesInfo;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "leroy-stock-order-batches")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LeroyBatchesVMIInfo extends BatchesInfo {
    public LeroyBatchesVMIInfo() {
        super();
    }

    public LeroyBatchesVMIInfo(LocalDateTime now) {
        super(now);
    }
}
