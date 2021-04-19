package br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.ebs.reponse;

import com.fasterxml.jackson.annotation.JsonGetter;

public class EstoqueEBSResponseDTO {

    private String cliente;
    private String canal;
    private String codigoProduto;
    private String codigoDeposito;
    private String codigoTonalidadeCalibre;
    private String unidadeItem;
    private String saldoDisponivel;
    private String qtdminLongtail;
    private String unidadeCliente;
    private String unidadeConverte;
    private String qtdminLongtailConv;
    private String saldoDisponivelLongtail;
    private String saldoDisponivelLongtailConv;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    @JsonGetter("cod_produto")
    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    @JsonGetter("cod_deposito")
    public String getCodigoDeposito() {
        return codigoDeposito;
    }

    public void setCodigoDeposito(String codigoDeposito) {
        this.codigoDeposito = codigoDeposito;
    }

    @JsonGetter("cod_tonalidade_calibre")
    public String getCodigoTonalidadeCalibre() {
        return codigoTonalidadeCalibre;
    }

    public void setCodigoTonalidadeCalibre(String codigoTonalidadeCalibre) {
        this.codigoTonalidadeCalibre = codigoTonalidadeCalibre;
    }

    @JsonGetter("unidade_item")
    public String getUnidadeItem() {
        return unidadeItem;
    }

    public void setUnidadeItem(String unidadeItem) {
        this.unidadeItem = unidadeItem;
    }

    @JsonGetter("saldo_disponivel")
    public String getSaldoDisponivel() {
        return saldoDisponivel;
    }

    public void setSaldoDisponivel(String saldoDisponivel) {
        this.saldoDisponivel = saldoDisponivel;
    }

    @JsonGetter("qtdmin_longtail")
    public String getQtdminLongtail() {
        return qtdminLongtail;
    }

    public void setQtdminLongtail(String qtdminLongtail) {
        this.qtdminLongtail = qtdminLongtail;
    }

    @JsonGetter("unidade_cliente")
    public String getUnidadeCliente() {
        return unidadeCliente;
    }

    public void setUnidadeCliente(String unidadeCliente) {
        this.unidadeCliente = unidadeCliente;
    }

    @JsonGetter("unidade_converte")
    public String getUnidadeConverte() {
        return unidadeConverte;
    }

    public void setUnidadeConverte(String unidadeConverte) {
        this.unidadeConverte = unidadeConverte;
    }

    @JsonGetter("qtdmin_longtail_conv")
    public String getQtdminLongtailConv() {
        return qtdminLongtailConv;
    }

    public void setQtdminLongtailConv(String qtdminLongtailConv) {
        this.qtdminLongtailConv = qtdminLongtailConv;
    }

    @JsonGetter("saldo_disponivel_longtail")
    public String getSaldoDisponivelLongtail() {
        return saldoDisponivelLongtail;
    }

    public void setSaldoDisponivelLongtail(String saldoDisponivelLongtail) {
        this.saldoDisponivelLongtail = saldoDisponivelLongtail;
    }

    @JsonGetter("saldo_disponivel_longtail_conv")
    public String getSaldoDisponivelLongtailConv() {
        return saldoDisponivelLongtailConv;
    }

    public void setSaldoDisponivelLongtailConv(String saldoDisponivelLongtailConv) {
        this.saldoDisponivelLongtailConv = saldoDisponivelLongtailConv;
    }
}
