package com.example.fastmeal.mesas.data.network;

import com.example.fastmeal.mesas.data.network.response.MesaResult;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIMesa {

    @GET("/fastmeal/mesa/json/")
    Call<MesaResult> obterMesas();
}
