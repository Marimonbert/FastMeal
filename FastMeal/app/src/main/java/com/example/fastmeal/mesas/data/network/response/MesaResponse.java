package com.example.fastmeal.mesas.data.network.response;

import com.squareup.moshi.Json;

public class MesaResponse {

    @Json(name = "nome")
    private String nome;


    public MesaResponse(String nome) {

        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
