package com.example.fastmeal.cardapio.ResponseCardapio;

import com.squareup.moshi.Json;

import java.util.List;

public class CardapioResult {
    @Json(name = "cardapios")


    private final List<CardapioResponse> resultadoCardapio;

    public CardapioResult(String cardapios, List<CardapioResponse> resultadoCardapio) {

        this.resultadoCardapio = resultadoCardapio;
    }

    public List<CardapioResponse> getResultadoCardapio() {
        return resultadoCardapio;
    }

}
