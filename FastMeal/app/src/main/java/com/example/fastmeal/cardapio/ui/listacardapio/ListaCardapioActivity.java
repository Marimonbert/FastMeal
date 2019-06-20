package com.example.fastmeal.cardapio.ui.listacardapio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.fastmeal.R;
import com.example.fastmeal.cardapio.GuiaCardapio.cardapio;
import com.example.fastmeal.categoria.categoria.GuiaCategoria.categoria;

import java.util.ArrayList;
import java.util.List;

public class ListaCardapioActivity extends AppCompatActivity implements ListaCardapioContrato.ListaCardapioView {


    public static final String EXTRA_CATEGORIA = "EXTRA_CATEGORIA";

    private RecyclerView RecyclerItens;
    private categoria cEsc = null;

    private ListaCardapioAdapter cardapioAdapter;
    private ListaCardapioContrato.ListaFilmesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cardapio);



        //recebendo a categoria escolhida
        Intent i = getIntent();
        cEsc = (categoria) i.getSerializableExtra("categoria_escolhida");

        ConfiguraAdapter();



        presenter = new ListaCardapioPresenter(this);
        presenter.ObtemCardapio();


    }
    public void ConfiguraAdapter() {
        RecyclerItens = findViewById(R.id.recycler_cardapio);

        cardapioAdapter = new ListaCardapioAdapter();

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);

        RecyclerItens.setLayoutManager(linearLayoutManager);

        RecyclerItens.setAdapter(cardapioAdapter);
    }



    @Override
    public void MostraCardapio(List<cardapio> cardapios) {
    // ao mostrar os itens

        ArrayList<cardapio> lc = new ArrayList<cardapio>(); // cria-se uma nova lista zerada

        for (int i = 0;i < cardapios.size();i++){//percorre a list
            if(cardapios.get(i).getIdCategoria().equals(cEsc.getId())){// e compara o id da categoria com o idcategoria dentro do item
                lc.add(cardapios.get(i));// se forem o mesmo id, add esse item na nova lista
            }

        }


        cardapioAdapter.setCardapios(lc);// por fim exibi os itens desta nova lista


    }
    @Override

    public void MostraErro(){
            Toast.makeText(this, "Erro ao obter itens", Toast.LENGTH_SHORT).show();

        }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.DestruirView();

    }
}