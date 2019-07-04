package com.example.fastmeal.modelo;

public class OrdemPedido {

    private String uidCliente;
    private String uidPedido;
    private long posicao;
    private String uidOrdemP;
    private String uidMesa;
    private String idGarcom;
    private String nomeMesa;
    private String nomePedido;
    private String quatidade;

    public String getUidCliente() {
        return uidCliente;
    }

    public void setUidCliente(String uidCliente) {
        this.uidCliente = uidCliente;
    }

    public String getUidPedido() {
        return uidPedido;
    }

    public void setUidPedido(String uidPedido) {
        this.uidPedido = uidPedido;
    }

    public long getPosicao() {
        return posicao;
    }

    public void setPosicao(long posicao) {
        this.posicao = posicao;
    }

    public String getUidOrdemP() {
        return uidOrdemP;
    }

    public void setUidOrdemP(String uidOrdemP) {
        this.uidOrdemP = uidOrdemP;
    }

    public String getUidMesa() {
        return uidMesa;
    }

    public void setUidMesa(String uidMesa) {
        this.uidMesa = uidMesa;
    }

    public OrdemPedido() {
    }

    public String getIdGarcom() {
        return idGarcom;
    }

    public void setIdGarcom(String idGarcom) {
        this.idGarcom = idGarcom;
    }

    @Override
    public String toString() {
        return "OrdemPedido: posicão: " + posicao +" - Mesa: "+ uidMesa;
    }

    public String getNomeMesa() {
        return nomeMesa;
    }

    public void setNomeMesa(String nomeMesa) {
        this.nomeMesa = nomeMesa;
    }

    public String getNomePedido() {
        return nomePedido;
    }

    public void setNomePedido(String nomePedido) {
        this.nomePedido = nomePedido;
    }

    public String getQuatidade() {
        return quatidade;
    }

    public void setQuatidade(String quatidade) {
        this.quatidade = quatidade;
    }
}
