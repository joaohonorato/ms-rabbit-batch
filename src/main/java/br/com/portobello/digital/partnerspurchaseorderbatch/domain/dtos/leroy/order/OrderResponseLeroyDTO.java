package br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.order;


import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.ContentDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.vos.leroy.HeaderVO;
import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.List;


public class OrderResponseLeroyDTO extends ContentDTO<OrderLeroyDTO> {
    private HeaderVO header;

    @Override
    @JsonGetter("orders")
    public List<OrderLeroyDTO> getItems() {
        return items;
    }

    public HeaderVO getHeader() {
        return header;
    }

    public void setHeader(HeaderVO header) {
        this.header = header;
    }
}
