package com.example.fastmeal.categoria.categoria.MapperCategoria;

import com.example.fastmeal.categoria.categoria.CategoriaResponse.CategoriaResponse;
import com.example.fastmeal.categoria.categoria.GuiaCategoria.categoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaMapper {

    public static List<categoria> deResponseParaDominio(List<CategoriaResponse> listarCategoriaResponse){
        List<categoria> listaCategoria = new ArrayList<>();

        for (CategoriaResponse categoriaResponse : listarCategoriaResponse) {

            final categoria categoria = new categoria(
                    categoriaResponse.getNome(),
                    categoriaResponse.getFoto(),
                    categoriaResponse.getId());

            listaCategoria.add(categoria);
        }
        return listaCategoria;

    }
}
