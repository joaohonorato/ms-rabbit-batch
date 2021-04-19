package br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.commons;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.enums.SourceType;

import java.util.List;

public abstract class BatchItem<T> {
    private SourceType source;
    private List<T> purchaseOrders;

    public BatchItem() {
    }

    public BatchItem(SourceType source, List<T> purchaseOrders) {
        this.source = source;
        this.purchaseOrders = purchaseOrders;
    }

    public SourceType getSource() {
        return source;
    }

    public void setSource(SourceType source) {
        this.source = source;
    }

    public List<T> getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setPurchaseOrders(List<T> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }

}
