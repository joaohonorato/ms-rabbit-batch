package br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.productVMI;


import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.ContentDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.vos.leroy.HeaderVO;
import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.List;


public class ProductVMIResponseLeroyDTO extends ContentDTO<ProductLeroyDTO> {
    private HeaderVO header;

    @Override
    @JsonGetter("productsvmi")
    public List<ProductLeroyDTO> getItems() {
        return items;
    }

    public HeaderVO getHeader() {
        return header;
    }

    public void setHeader(HeaderVO header) {
        this.header = header;
    }
}
