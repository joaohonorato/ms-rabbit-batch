package br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.leroy.response;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.leroy.request.SupplierProductsStockDTO;

import java.util.List;

public class SupplierStockResponseDTO {
    private List<SupplierProductsStockDTO> supplierProductsStockDTO;

    public List<SupplierProductsStockDTO> getSupplierProductsStockDTO() {
        return supplierProductsStockDTO;
    }

    public void setSupplierProductsStockDTO(List<SupplierProductsStockDTO> supplierProductsStockDTO) {
        this.supplierProductsStockDTO = supplierProductsStockDTO;
    }
}
