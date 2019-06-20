package com.example.fastmeal.categoria.categoria.ConexaoCategoria;

import com.example.fastmeal.categoria.categoria.CategoriaResponse.CategoriaResult;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceCategoria {


    @GET("/fastmeal/categoria/json/")
    Call<CategoriaResult> obterCategorias();
}
