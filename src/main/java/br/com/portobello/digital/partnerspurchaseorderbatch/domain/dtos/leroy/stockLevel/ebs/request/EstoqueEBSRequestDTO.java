package br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.ebs.request;

import java.util.List;

public class EstoqueEBSRequestDTO {

    private String cliente;
    private String canal;
    private String deposito;
    private List<ItemEBSDTO> itens;

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

    public String getDeposito() {
        return deposito;
    }

    public void setDeposito(String deposito) {
        this.deposito = deposito;
    }

    public List<ItemEBSDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemEBSDTO> itens) {
        this.itens = itens;
    }
}
