package com.example.fastmeal.mesas.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class MesaService {

    private static APIMesa MESAS;

    public static APIMesa getInstance() {
        if (MESAS == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://3.19.60.179")
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();

            MESAS = retrofit.create(APIMesa.class);
        }

        return MESAS;
    }
}
