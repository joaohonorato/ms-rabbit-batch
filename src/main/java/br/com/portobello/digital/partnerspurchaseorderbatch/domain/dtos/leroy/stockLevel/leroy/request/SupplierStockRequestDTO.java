package br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.leroy.request;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.events.commons.EventPayload;

public class SupplierStockRequestDTO extends EventPayload {

    private SupplierStockDTO supplierStock;

    public SupplierStockRequestDTO() {
    }

    public SupplierStockRequestDTO(SupplierStockDTO supplierStock) {
        this.supplierStock = supplierStock;
    }

    public SupplierStockDTO getSupplierStock() {
        return supplierStock;
    }

    public void setSupplierStock(SupplierStockDTO supplierStock) {
        this.supplierStock = supplierStock;
    }
}
