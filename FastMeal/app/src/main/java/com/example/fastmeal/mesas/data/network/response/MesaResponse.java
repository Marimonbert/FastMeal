package com.example.fastmeal.mesas.data.network.response;

import com.squareup.moshi.Json;

public class MesaResponse {

    @Json(name = "nome")
    private String nome;

    @Json(name = "foto")
    private String foto;

    @Json(name = "nomeGarcom")
    private String nomeGarcom;


    public MesaResponse(String nome, String nomeGarcom, String foto) {
        this.nome = nome;
        this.nomeGarcom = nomeGarcom;
        this.foto = foto;
    }

    public String getNomeGarcom() {
        return nomeGarcom;
    }

    public String getNome() {
        return nome;
    }
    public String getFoto() {
        return foto;
    }
}
