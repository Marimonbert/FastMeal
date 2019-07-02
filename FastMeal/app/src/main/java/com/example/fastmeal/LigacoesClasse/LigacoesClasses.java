package com.example.fastmeal.LigacoesClasse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fastmeal.R;
import com.example.fastmeal.categoria.categoria.ui.categoria.ListaCategoriaActivity;
import com.example.fastmeal.mesas.ui.listamesas.ListaMesasActivity;

public class LigacoesClasses extends Activity {
    Button BtnEntrar;

    Button ChamarGarcom;

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
                Intent i = new Intent(LigacoesClasses.this, ListaMesasActivity.class);
                startActivity(i);
            }
        });


    }
}

