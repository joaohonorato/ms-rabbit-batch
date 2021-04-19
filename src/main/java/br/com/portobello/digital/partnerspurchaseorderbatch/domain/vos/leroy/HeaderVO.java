package br.com.portobello.digital.partnerspurchaseorderbatch.domain.vos.leroy;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class HeaderVO implements Serializable {
    @JsonProperty("_offset")
    private Integer offset;
    @JsonProperty("_limit")
    private Integer limit;
    private Integer pages;
    private Integer total;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
