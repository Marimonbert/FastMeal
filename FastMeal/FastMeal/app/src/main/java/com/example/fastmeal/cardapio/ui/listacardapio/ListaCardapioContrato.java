package com.example.fastmeal.cardapio.ui.listacardapio;

import com.example.fastmeal.cardapio.GuiaCardapio.cardapio;

import java.util.List;

public interface ListaCardapioContrato {




    interface ListaCardapioView {
        void MostraCardapio(List<cardapio> cardapios);

        void MostraErro();

    }

    interface  ListaFilmesPresenter {

         void ObtemCardapio();

         void DestruirView();

    }
}
