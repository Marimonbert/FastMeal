package com.example.fastmeal.LigacoesClasse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fastmeal.R;
import com.example.fastmeal.categoria.categoria.ui.categoria.ListaCategoriaActivity;
import com.example.fastmeal.mesas.ui.listamesas.ListaMesasActivity;
import com.google.firebase.database.DatabaseReference;

import java.util.UUID;

import conexaoFirebase.ConexaoFirebase;
import garcon.ChamarGarcon;

public class LigacoesClasses extends Activity {
    Button BtnEntrar;

    Button ChamarGarcom;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagina_inicial);

        BtnEntrar = (Button) findViewById(R.id.BtnEntrar);

        BtnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LigacoesClasses.this,ListaCategoriaActivity.class);
                startActivity(i);
            }
        });

        ChamarGarcom = (Button) findViewById(R.id.ChamarGarcom);

        ChamarGarcom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChamarGarcon cg = new ChamarGarcon();

                cg.setMesa("mesa 1");
                cg.setNomeCliente("João");
                cg.setUid(UUID.randomUUID().toString());
                cg.setPosicao(System.currentTimeMillis());

                databaseReference.child("chamarGarcon/"+cg.getUid()).setValue(cg);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference = ConexaoFirebase.getDatabaseReference(this);
    }
}

