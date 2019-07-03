package com.example.fastmeal.modelo;

public class ChamaGarcon {

    private String uidChamada;
    private String idMesa;
    private String idGarcom;
    private long posicao;

    public String getUidChamada() {
        return uidChamada;
    }

    public void setUidChamada(String uidChamada) {
        this.uidChamada = uidChamada;
    }

    public String getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(String idMesa) {
        this.idMesa = idMesa;
    }

    public String getIdGarcom() {
        return idGarcom;
    }

    public void setIdGarcom(String idGarcom) {
        this.idGarcom = idGarcom;
    }
    
    public long getPosicao() {
        return posicao;
    }

    public void setPosicao(long posicao) {
        this.posicao = posicao;
    }
}
