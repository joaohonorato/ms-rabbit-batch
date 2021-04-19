package br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.order;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OrderLeroyDTO {

    private HeaderDTO header;
    @JsonProperty("@version")
    private String version;
    private List<ItemLeroyDTO> item;
    private String orderType;
    @JsonProperty("@timestamp")
    private String timestamp;
    private List<String> tags;

    public HeaderDTO getHeader() {
        return header;
    }

    public void setHeader(HeaderDTO header) {
        this.header = header;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<ItemLeroyDTO> getItem() {
        return item;
    }

    public void setItem(List<ItemLeroyDTO> item) {
        this.item = item;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
