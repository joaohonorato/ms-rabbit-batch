package br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.ebs.request;

import com.fasterxml.jackson.annotation.JsonGetter;


public class ItemEBSDTO {

    private String codigoProduto;
    private String unidade;

    public ItemEBSDTO() {
    }

    public ItemEBSDTO(String codigoProduto, String unidade) {
        this.codigoProduto = codigoProduto;
        this.unidade = unidade;
    }

    @JsonGetter("cod_produto")
    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
}
