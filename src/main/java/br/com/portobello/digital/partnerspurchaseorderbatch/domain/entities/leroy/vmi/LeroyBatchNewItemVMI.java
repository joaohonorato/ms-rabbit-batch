package br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.leroy.vmi;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.leroy.request.SupplierStockRequestDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.commons.BatchesInfo;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.enums.EventStatusType;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "leroy-stock-batch-new-item")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LeroyBatchNewItemVMI extends BatchesInfo {
    private SupplierStockRequestDTO stockInfo;
    private EventStatusType statusType;

    public LeroyBatchNewItemVMI() {
        super();
    }

    public LeroyBatchNewItemVMI(SupplierStockRequestDTO stockInfo) {
        super();
        this.stockInfo = stockInfo;
    }


    public SupplierStockRequestDTO getStockInfo() {
        return stockInfo;
    }

    public void setStockInfo(SupplierStockRequestDTO stockInfo) {
        this.stockInfo = stockInfo;
    }

    public EventStatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(EventStatusType statusType) {
        this.statusType = statusType;
    }
}
