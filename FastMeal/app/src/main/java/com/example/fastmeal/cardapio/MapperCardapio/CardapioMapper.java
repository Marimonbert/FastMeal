package com.example.fastmeal.cardapio.MapperCardapio;

import com.example.fastmeal.cardapio.ResponseCardapio.CardapioResponse;
import com.example.fastmeal.cardapio.GuiaCardapio.cardapio;
import com.example.fastmeal.cardapio.ui.listacardapio.ListaCardapioActivity;

import java.util.ArrayList;
import java.util.List;

public class CardapioMapper extends ListaCardapioActivity {

    public static List<cardapio> deResponseParaDominio(List<CardapioResponse> listarCardapioResponse){
        List<cardapio> listaCardapio = new ArrayList<>();

        for (CardapioResponse cardapioResponse : listarCardapioResponse) {

            final cardapio cardapio = new cardapio(
                    cardapioResponse.getId(),
                    cardapioResponse.getNome(),
                    cardapioResponse.getDescricao(),
                    cardapioResponse.getValor(),
                    cardapioResponse.getFoto(),
                    cardapioResponse.getIdCategoria());// recebe da api o id da categoria

            listaCardapio.add(cardapio);
        }
        return listaCardapio;

    }
}
