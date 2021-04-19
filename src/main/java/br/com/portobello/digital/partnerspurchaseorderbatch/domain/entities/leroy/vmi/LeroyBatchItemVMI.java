package br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.leroy.vmi;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.ebs.reponse.EstoqueEBSResponseDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.leroy.response.SupplierStockResponseDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "leroy-stock-batch-item")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LeroyBatchItemVMI {
    private EstoqueEBSResponseDTO ebsResponse;
    private SupplierStockResponseDTO leroyResponse;

    public LeroyBatchItemVMI() {
        super();
    }

    public LeroyBatchItemVMI(EstoqueEBSResponseDTO ebsResponse, SupplierStockResponseDTO leroyResponse) {
        super();
        this.ebsResponse = ebsResponse;
        this.leroyResponse = leroyResponse;
    }

    public EstoqueEBSResponseDTO getEbsResponse() {
        return ebsResponse;
    }

    public void setEbsResponse(EstoqueEBSResponseDTO ebsResponse) {
        this.ebsResponse = ebsResponse;
    }

    public SupplierStockResponseDTO getLeroyResponse() {
        return leroyResponse;
    }

    public void setLeroyResponse(SupplierStockResponseDTO leroyResponse) {
        this.leroyResponse = leroyResponse;
    }
}
