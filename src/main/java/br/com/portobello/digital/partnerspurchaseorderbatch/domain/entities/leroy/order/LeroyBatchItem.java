package br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.leroy.order;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.order.OrderLeroyDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.productVMI.ProductVMIResponseLeroyDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.ebs.reponse.EstoqueEBSResponseDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.commons.BatchItem;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "leroy-purchase-order-batch-item")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LeroyBatchItem extends BatchItem<OrderLeroyDTO> {
    private List<ProductVMIResponseLeroyDTO> stockLeroyInfo;
    private List<EstoqueEBSResponseDTO> stockEbsInfo;

    public LeroyBatchItem() {
    }

    public LeroyBatchItem(List<ProductVMIResponseLeroyDTO> stockLeroyInfo, List<EstoqueEBSResponseDTO> stockEbsInfo) {
        this.stockLeroyInfo = stockLeroyInfo;
        this.stockEbsInfo = stockEbsInfo;
    }


    public List<ProductVMIResponseLeroyDTO> getStockLeroyInfo() {
        return stockLeroyInfo;
    }

    public void setStockLeroyInfo(List<ProductVMIResponseLeroyDTO> stockLeroyInfo) {
        this.stockLeroyInfo = stockLeroyInfo;
    }

    public List<EstoqueEBSResponseDTO> getStockEbsInfo() {
        return stockEbsInfo;
    }

    public void setStockEbsInfo(List<EstoqueEBSResponseDTO> stockEbsInfo) {
        this.stockEbsInfo = stockEbsInfo;
    }
}
