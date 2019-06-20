package com.example.fastmeal.cardapio.ConexaoCardapio;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiCardapio {

    private static InterfaceCardapio INSTANCE;

    public static InterfaceCardapio getINSTANCE() {
        if (INSTANCE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://3.19.60.179/")
                    .addConverterFactory(MoshiConverterFactory.create())

                    .build();


            INSTANCE = retrofit.create(InterfaceCardapio.class);

        }

        return INSTANCE;
    }

}
