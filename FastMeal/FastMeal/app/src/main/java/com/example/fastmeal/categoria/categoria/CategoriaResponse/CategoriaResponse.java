package com.example.fastmeal.categoria.categoria.CategoriaResponse;

import com.squareup.moshi.Json;

public class CategoriaResponse {



    @Json(name = "nome")
    private String nome;

    @Json(name = "foto")
    private String foto;

    @Json(name = "id")
    private String id;


    public CategoriaResponse( String nome,
                              String foto,
                              String id) {

        this.nome = nome;
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public String getFoto() {
        return foto;
    }


}