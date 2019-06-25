package com.example.fastmeal.mesas.ui.listamesas;

import com.example.fastmeal.mesas.data.model.mesa;

import java.util.List;


public interface ListaMesasContrato {

    interface ListaMesasView {

        void mostraFilmes(List<mesa> mesas);

        void mostraErro();
    }

    interface ListaMesasPresenter {

        void obtemMesas();

        void destruirView();
    }
}
