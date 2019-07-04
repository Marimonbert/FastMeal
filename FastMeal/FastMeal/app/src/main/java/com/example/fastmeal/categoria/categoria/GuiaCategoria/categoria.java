package com.example.fastmeal.categoria.categoria.GuiaCategoria;

import java.io.Serializable;

public class categoria implements Serializable {

    private String nome;
    private String id;


    private String foto;

    public categoria(String nome,
                     String foto,
                     String id) {
        this.nome = nome;
        this.id=id;
        this.foto = foto;
    }

    public void setNome(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    public String getId() {
        return id;
    }



    public String getNome() {
        return nome;
    }
    public String getFoto() {
        return foto;
    }


}

