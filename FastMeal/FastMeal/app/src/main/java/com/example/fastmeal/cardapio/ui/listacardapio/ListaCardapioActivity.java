package com.example.fastmeal.cardapio.ui.listacardapio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.fastmeal.LigacoesClasse.LigacoesClasses;
import com.example.fastmeal.R;
import com.example.fastmeal.cardapio.GuiaCardapio.cardapio;
import com.example.fastmeal.cardapio.MapperCardapio.CardapioMapper;
import com.example.fastmeal.categoria.categoria.GuiaCategoria.categoria;
import com.example.fastmeal.conta.conta;
import com.example.fastmeal.firebase.ConexaoFirebase;
import com.example.fastmeal.mesas.ui.listamesas.ListaMesasActivity;
import com.example.fastmeal.modelo.OrdemPedido;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ListaCardapioActivity extends AppCompatActivity implements ListaCardapioContrato.ListaCardapioView {

    private Button visualizar;
    private Button btnEnviarPedido;

    public static final String EXTRA_CATEGORIA = "EXTRA_CATEGORIA";

    private RecyclerView RecyclerItens;
    private categoria cEsc = null;
    CheckBox Selecionar;
    private String uiCliente;
  //  private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;



    private ListaCardapioAdapter cardapioAdapter;
    private ListaCardapioContrato.ListaFilmesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cardapio);

        uiCliente = ConexaoFirebase.getuIdCliente();
        databaseReference = ConexaoFirebase.getDatabaseReference(this);

        inicializarComponentes();
        eventosButtons();

        //recebendo a categoria escolhida
        Intent i = getIntent();
        cEsc = (categoria) i.getSerializableExtra("categoria_escolhida");

        ConfiguraAdapter();



        presenter = new ListaCardapioPresenter(this);
        presenter.ObtemCardapio();


    }

    private void eventosButtons() {
        visualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListaCardapioActivity.this, conta.class);
                i.putExtra("uidCliente",uiCliente);
               startActivity(i);
               finish();
          //  MostraErro();
            }
        });

        btnEnviarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<cardapio> cardapios = cardapioAdapter.getCardapios();
                List<cardapio> escolhidos = new ArrayList<cardapio>();
                for (int i = 0; i < cardapios.size();i++){
                    if (cardapios.get(i).isEscolhido()){

                        cardapio c = new cardapio();
                      //  c.setQuantidade(cardapios.get(i).getQuantidade());
                        c.setQuantidade(cardapios.get(i).getQuantidade());
                        c.setuId(UUID.randomUUID().toString());
                        c.setValor(cardapios.get(i).getValor());
                        c.setNome(cardapios.get(i).getNome());
                        c.setEscolhido(true);
                        databaseReference.child("cliente").child(uiCliente).child("pedido").child(c.getuId()).setValue(c);

                        OrdemPedido op = new OrdemPedido();
                        op.setPosicao(System.currentTimeMillis());
                        op.setUidCliente(uiCliente);
                        op.setUidOrdemP(UUID.randomUUID().toString());
                        op.setUidMesa(ConexaoFirebase.getIdMesa());
                        op.setUidPedido(c.getuId());
                        op.setIdGarcom(ConexaoFirebase.getIdGarcom());

                        databaseReference.child("ordemPedido").child(op.getUidOrdemP()).setValue(op);
                    }
                }
//                databaseReference.child("teste").setValue("testando");
                finish();
            }
        });
    }

    private void inicializarComponentes() {
        btnEnviarPedido = (Button) findViewById(R.id.btnEnviarPedido);
        visualizar = (Button) findViewById(R.id.Visualizar);
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

    @Override
    protected void onStart() {
        super.onStart();

       // firebaseDatabase = ConexaoFirebase.getFirebaseDatabase(this);
    }


}