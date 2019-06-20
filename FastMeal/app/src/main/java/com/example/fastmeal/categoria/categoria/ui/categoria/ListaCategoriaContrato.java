package com.example.fastmeal.categoria.categoria.ui.categoria;

import com.example.fastmeal.categoria.categoria.GuiaCategoria.categoria;

import java.util.List;

public interface ListaCategoriaContrato {




    interface ListaCategoriasView {
        void MostraCategorias(List<categoria> categorias);

        void MostraErro();

    }

    interface ListaCategoriasPresenter {

         void ObtemCategoria();

         void DestruirView();

    }
}
