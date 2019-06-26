package com.example.fastmeal.mesas.data.model;

import java.io.Serializable;

public class mesa implements Serializable {


    private String nome;
    private String nomeGarcom;
    private String foto;

    public mesa(String nome, String foto, String nomeGarcom) {
        this.nome = nome;
        this.foto = foto;
        this.nomeGarcom = nomeGarcom;
    }


    public String getNomeGarcom() {
        return nomeGarcom;
    }
    public mesa(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public String getFoto() {
        return foto;
    }



}
