package com.example.fastmeal.mesas.data.model;

import java.io.Serializable;

public class mesa implements Serializable {


    private final String nome;

    public mesa(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }


}
