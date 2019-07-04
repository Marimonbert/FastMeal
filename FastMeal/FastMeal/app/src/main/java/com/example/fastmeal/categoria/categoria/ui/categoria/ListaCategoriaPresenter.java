package com.example.fastmeal.categoria.categoria.ui.categoria;


import com.example.fastmeal.categoria.categoria.CategoriaResponse.CategoriaResult;
import com.example.fastmeal.categoria.categoria.ConexaoCategoria.ConexaoCategoria;
import com.example.fastmeal.categoria.categoria.GuiaCategoria.categoria;
import com.example.fastmeal.categoria.categoria.MapperCategoria.CategoriaMapper;
import com.example.fastmeal.categoria.categoria.ui.categoria.ListaCategoriaContrato;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaCategoriaPresenter implements ListaCategoriaContrato.ListaCategoriasPresenter {

    private ListaCategoriaContrato.ListaCategoriasView view;

    public ListaCategoriaPresenter(ListaCategoriaContrato.ListaCategoriasView view){

        this.view = view;
    }
    @Override
    public void ObtemCategoria() {

            ConexaoCategoria.getINSTANCE()
                    .obterCategorias()
                    .enqueue(new Callback<CategoriaResult>() {
                        @Override
                        public void onResponse(Call<CategoriaResult> call, Response<CategoriaResult> response) {
                            if (response.isSuccessful()) {
                                final List<categoria> listarCategorias = CategoriaMapper
                                        .deResponseParaDominio(response.
                                                body().getResultadoCardapio());

                                view.MostraCategorias(listarCategorias);



                            }else {
                                view.MostraErro();
                            }

                        }

                        @Override
                        public void onFailure(Call<CategoriaResult> call, Throwable t) {
                            view.MostraErro();

                        }
                    });
    }

    @Override
    public void DestruirView() {
        this.view = null;

    }

}
