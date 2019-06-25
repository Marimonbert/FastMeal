package com.example.fastmeal.mesas.ui.listamesas;

import com.example.fastmeal.mesas.data.mapper.MesaMapper;
import com.example.fastmeal.mesas.data.model.mesa;
import com.example.fastmeal.mesas.data.network.MesaService;
import com.example.fastmeal.mesas.data.network.response.MesaResult;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListamMesasPresenter implements ListaMesasContrato.ListaMesasPresenter {

    private ListaMesasContrato.ListaMesasView view;

    public ListamMesasPresenter(ListaMesasContrato.ListaMesasView view) {
        this.view = view;
    }

    @Override
    public void obtemMesas() {
        MesaService.getInstance()
                .obterMesas()
                .enqueue(new Callback<MesaResult>() {
                    @Override
                    public void onResponse(Call<MesaResult> call, Response<MesaResult> response) {
                        if (response.isSuccessful()) {
                            final List<mesa> listaMesas = MesaMapper
                                    .deResponseParaDominio(response.body().getResultadoMesas());

                            view.mostraFilmes(listaMesas);
                        } else {
                            view.mostraErro();
                        }
                    }

                    @Override
                    public void onFailure(Call<MesaResult> call, Throwable t) {
                        view.mostraErro();
                    }
                });
    }

    @Override
    public void destruirView() {
        this.view = null;
    }
}
