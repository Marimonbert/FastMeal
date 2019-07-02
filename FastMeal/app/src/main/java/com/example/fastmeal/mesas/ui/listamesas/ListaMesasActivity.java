package com.example.fastmeal.mesas.ui.listamesas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.fastmeal.R;
import com.example.fastmeal.firebase.ConexaoFirebase;
import com.example.fastmeal.mesas.data.model.mesa;
import com.example.fastmeal.mesas.ui.detalhesmesas.DetalhesMesaActivity;

import java.util.ArrayList;
import java.util.List;

public class ListaMesasActivity extends AppCompatActivity
        implements ListaMesasContrato.ListaMesasView,
        ListaMesasAdapter.ItemMesaClickListener {

    private ListaMesasAdapter MesasAdapter;
    private ListaMesasContrato.ListaMesasPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_mesa);

        configuraAdapter();

        presenter = new ListamMesasPresenter(this);
        presenter.obtemMesas();
    }

    private void configuraAdapter() {
        final RecyclerView recyclerMesas = findViewById(R.id.recycler_mesas);

        MesasAdapter = new ListaMesasAdapter(this);

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerMesas.setLayoutManager(linearLayoutManager);
        recyclerMesas.setAdapter(MesasAdapter);
    }

    @Override
    public void mostraFilmes(List<mesa> mesas) {

        List<mesa> newListMesa = new ArrayList<mesa>();

        for (int i = 0;i<mesas.size();i++){
            if (mesas.get(i).getId().equals(ConexaoFirebase.getIdMesa())){
                newListMesa.add(mesas.get(i));
            }
        }

        MesasAdapter.setMesas(newListMesa);
    }

    @Override
    public void mostraErro() {
        Toast.makeText(this, "Erro ao obter lista de filmes.", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destruirView();
    }

    @Override
    public void onItemMesaClicada(mesa mesa) {
        Intent intent = new Intent(this, DetalhesMesaActivity.class);
        intent.putExtra(DetalhesMesaActivity.EXTRA_FILME, mesa);
        startActivity(intent);
    }
}
