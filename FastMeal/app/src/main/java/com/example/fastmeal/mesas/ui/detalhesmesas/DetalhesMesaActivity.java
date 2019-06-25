package com.example.fastmeal.mesas.ui.detalhesmesas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.fastmeal.R;
import com.example.fastmeal.mesas.data.model.mesa;


public class DetalhesMesaActivity extends AppCompatActivity {

    public static final String EXTRA_FILME = "EXTRA_FILME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_mesa);

        TextView textTituloMesa = findViewById(R.id.text_mesa);

        final mesa mesa = (mesa) getIntent().getSerializableExtra(EXTRA_FILME);

        textTituloMesa.setText(mesa.getNome());
    }
}
