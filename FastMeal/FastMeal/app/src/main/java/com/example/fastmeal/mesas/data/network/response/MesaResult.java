package com.example.fastmeal.mesas.data.network.response;

import com.squareup.moshi.Json;

import java.util.List;

public class MesaResult {

    @Json(name = "Mesas")
    private final List<MesaResponse> resultadoFilmes;

    public MesaResult(List<MesaResponse> resultadoMesas) {
        this.resultadoFilmes = resultadoMesas;
    }

    public List<MesaResponse> getResultadoMesas() {
        return resultadoFilmes;
    }
}
