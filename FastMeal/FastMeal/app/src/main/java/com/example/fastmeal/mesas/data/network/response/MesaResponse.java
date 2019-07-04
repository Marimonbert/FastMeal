package com.example.fastmeal.mesas.data.network.response;

import com.squareup.moshi.Json;

public class MesaResponse {

    @Json(name = "id")
    private String id;

    @Json(name = "nome")
    private String nome;

    @Json(name = "foto")
    private String foto;

    @Json(name = "nomeGarcom")
    private String nomeGarcom;

    @Json(name = "idGarcom")
    private String idGarcom;


    public MesaResponse(String id, String idGarcom,String nome, String nomeGarcom, String foto) {
        this.nome = nome;
        this.nomeGarcom = nomeGarcom;
        this.foto = foto;
        this.id = id;
        this.idGarcom = idGarcom;
    }

    public String getNomeGarcom() {
        return nomeGarcom;
    }

    public String getId() {
        return id;
    }

    public String getIdGarcom() {
        return idGarcom;
    }

    public String getNome() {
        return nome;
    }
    public String getFoto() {
        return foto;
    }
}
