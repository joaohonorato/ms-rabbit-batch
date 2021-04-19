package br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos;

import java.util.List;

public abstract class ContentDTO<T> {
    protected List<T> items;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
