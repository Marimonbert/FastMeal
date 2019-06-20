package com.example.fastmeal.cardapio.ConexaoCardapio;

import com.example.fastmeal.cardapio.ResponseCardapio.CardapioResult;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceCardapio {


    @GET("/fastmeal/cardapio/json/")
    Call<CardapioResult> obterCardapios();
}
