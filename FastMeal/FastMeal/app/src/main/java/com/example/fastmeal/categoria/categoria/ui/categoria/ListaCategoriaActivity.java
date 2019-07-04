package com.example.fastmeal.categoria.categoria.ui.categoria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fastmeal.R;
import com.example.fastmeal.cardapio.ui.listacardapio.ListaCardapioActivity;
import com.example.fastmeal.categoria.categoria.GuiaCategoria.categoria;
import com.example.fastmeal.conta.conta;

import java.util.List;
public class ListaCategoriaActivity extends AppCompatActivity implements
        ListaCategoriaContrato.ListaCategoriasView, ListaCategoriaAdapter.ItemCategoriaClickListener {

    private RecyclerView RecyclerItens;

    private ListaCategoriaAdapter cardapioAdapter;
    private ListaCategoriaContrato.ListaCategoriasPresenter presenter;

    private Button btnVisualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_categoria);
        btnVisualizar = (Button) findViewById(R.id.Visualizar);


        ConfiguraAdapter();


        presenter = new ListaCategoriaPresenter(this);
        presenter.ObtemCategoria();

        eventoButton();
    }

    private void eventoButton() {
        btnVisualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListaCategoriaActivity.this, conta.class);
               // i.putExtra("uidCliente",uiCliente);
                startActivity(i);
            }
        });
    }

    public void ConfiguraAdapter() {
        RecyclerItens = findViewById(R.id.recycler_categoria);

        cardapioAdapter = new ListaCategoriaAdapter(this);

        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        RecyclerItens.setLayoutManager(gridLayoutManager);

        RecyclerItens.setAdapter(cardapioAdapter);
    }


    @Override
    public void MostraCategorias(List<categoria> categorias) {
        cardapioAdapter.setCategorias(categorias);

    }

    @Override

    public void MostraErro() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.DestruirView();

    }

    @Override
    public void onItemCategoriaClicado(categoria categorias) {
        Intent intent = new Intent(this, ListaCardapioActivity.class);
        intent.putExtra("categoria_escolhida", categorias);// envia a categoria selecionada por parametro

        startActivity(intent);
    }
}