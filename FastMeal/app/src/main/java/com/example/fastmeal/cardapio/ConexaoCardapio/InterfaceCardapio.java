package com.example.fastmeal.cardapio.ConexaoCardapio;

import com.example.fastmeal.cardapio.ResponseCardapio.CardapioResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
public interface InterfaceCardapio {

   // @GET("/api/store-pedido/")

   @GET("/fastmeal/cardapio/json/")
    Call<CardapioResult> obterCardapios();
}




