package com.example.fastmeal.categoria.categoria.ConexaoCategoria;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ConexaoCategoria {

    private static InterfaceCategoria CATEGORIA;

    public static InterfaceCategoria getINSTANCE() {
        if (CATEGORIA == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://3.19.60.179/")
                    .addConverterFactory(MoshiConverterFactory.create())

                    .build();


            CATEGORIA = retrofit.create(InterfaceCategoria.class);

        }

        return CATEGORIA;
    }

}
