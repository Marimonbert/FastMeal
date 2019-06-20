package com.example.fastmeal.categoria.categoria.CategoriaResponse;

import com.example.fastmeal.categoria.categoria.CategoriaResponse.CategoriaResponse;
import com.squareup.moshi.Json;

import java.util.List;

public class CategoriaResult {
    @Json(name = "categorias")
    private final List<CategoriaResponse> resultadoCardapio;

    public CategoriaResult(List<CategoriaResponse> resultadoCardapio) {
        this.resultadoCardapio = resultadoCardapio;
    }

    public List<CategoriaResponse> getResultadoCardapio() {
        return resultadoCardapio;
    }




}
