package com.example.fastmeal.conta;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fastmeal.LigacoesClasse.LigacoesClasses;
import com.example.fastmeal.R;
import com.example.fastmeal.cardapio.GuiaCardapio.cardapio;
import com.example.fastmeal.cardapio.ui.listacardapio.ListaCardapioActivity;
import com.example.fastmeal.firebase.ConexaoFirebase;
import com.example.fastmeal.mesas.ui.listamesas.ListaMesasActivity;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class conta extends AppCompatActivity {

    private TextView txtVPedido, txtVTotal;
    private Button btnFinalizar;

    private String uIdcliente;
   // private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private float ContaTotal=0;
    private String pedidoTotal= "Pedidos\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta);

        databaseReference = ConexaoFirebase.getDatabaseReference(this);

        Intent i = getIntent();
        uIdcliente = i.getStringExtra("uidCliente");

        inicilizarComponentes();
        eventoDatabase();


    }


    private void eventoDatabase() {

                    Query query = databaseReference.child("cliente").child(uIdcliente).child("pedido");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot snapshot:dataSnapshot.getChildren()) {
                                cardapio c = (cardapio) snapshot.getValue(cardapio.class);
                                pedidoTotal= pedidoTotal + c.getQuantidade()+" x "+c.getNome()+"\n";
                                float valor = c.getQuantidade() * ((Float.parseFloat(c.getValor())));
                                ContaTotal = ContaTotal + valor;
                                populaTela(pedidoTotal,ContaTotal);

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

    }

    private void populaTela(String pedidoTotal, float contaTotal) {
        txtVPedido.setText(pedidoTotal);
        txtVTotal.setText("Total conta: R$ "+contaTotal);

    }

    private void inicilizarComponentes() {
        txtVPedido = (TextView) findViewById(R.id.textView4);
        txtVTotal = (TextView) findViewById(R.id.textView5);
        btnFinalizar = (Button) findViewById(R.id.button2);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void alert(String s ){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }
}
