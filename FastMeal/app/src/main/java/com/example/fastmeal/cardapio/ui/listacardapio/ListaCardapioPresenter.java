package com.example.fastmeal.cardapio.ui.listacardapio;

import com.example.fastmeal.cardapio.ResponseCardapio.CardapioResult;
import com.example.fastmeal.cardapio.GuiaCardapio.cardapio;
import com.example.fastmeal.cardapio.ConexaoCardapio.ApiCardapio;
import com.example.fastmeal.cardapio.MapperCardapio.CardapioMapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaCardapioPresenter implements ListaCardapioContrato.ListaFilmesPresenter {

    private ListaCardapioContrato.ListaCardapioView view;

    public ListaCardapioPresenter(ListaCardapioContrato.ListaCardapioView view){

        this.view = view;
    }
    @Override
    public void ObtemCardapio() {

            ApiCardapio.getINSTANCE()
                    .obterCardapios()
                    .enqueue(new Callback<CardapioResult>() {
                        @Override
                        public void onResponse(Call<CardapioResult> call, Response<CardapioResult> response) {
                            if (response.isSuccessful()){
                                final List<cardapio> listarCardapios = CardapioMapper
                                        .deResponseParaDominio(response.
                                                body().getResultadoCardapio());

                            view.MostraCardapio(listarCardapios);


                            }else {
                               view.MostraErro();
                            }

                        }

                        @Override
                        public void onFailure(Call<CardapioResult> call, Throwable t) {
                            view.MostraErro();

                        }
                    });
        }

    @Override
    public void DestruirView() {
        this.view = null;

    }

}
