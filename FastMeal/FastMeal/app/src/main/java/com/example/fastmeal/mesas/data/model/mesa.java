package com.example.fastmeal.mesas.data.model;

import java.io.Serializable;

public class mesa implements Serializable {


    private String nome;
    private String nomeGarcom;
    private String foto;
    private String id;
    private String idGarcom;

    public mesa(String id,String nome, String foto, String nomeGarcom, String idGarcom) {
        this.id = id;
        this.nome = nome;
        this.foto = foto;
        this.nomeGarcom = nomeGarcom;
        this.idGarcom = idGarcom;
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

    public String getId() {
        return id;
    }

    public String getIdGarcom() {
        return idGarcom;
    }
}
