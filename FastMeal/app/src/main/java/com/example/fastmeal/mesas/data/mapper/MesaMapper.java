package com.example.fastmeal.mesas.data.mapper;

import com.example.fastmeal.mesas.data.model.mesa;
import com.example.fastmeal.mesas.data.network.response.MesaResponse;

import java.util.ArrayList;
import java.util.List;


public class MesaMapper {

    public static List<mesa> deResponseParaDominio(List<MesaResponse> listaMesaResponse) {
        List<mesa> listaMesas = new ArrayList<>();

        for (MesaResponse mesaResponse : listaMesaResponse) {
            final mesa mesa = new mesa(mesaResponse.getId(),mesaResponse.getNome(), mesaResponse.getFoto(), mesaResponse.getNomeGarcom(),mesaResponse.getIdGarcom());
            listaMesas.add(mesa);
        }

        return listaMesas;
    }
}
