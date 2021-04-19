package br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.commons;

public abstract class BatchNewItem<T> {
    private T purchaseOrder;

    public BatchNewItem() {
    }

    public BatchNewItem(T purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public T getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(T purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }
}
