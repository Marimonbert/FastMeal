package com.example.fastmeal.avaliação;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.fastmeal.R;
import com.example.fastmeal.firebase.ConexaoFirebase;
import com.example.fastmeal.modelo.AvaliacaoGarcom;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.UUID;

public class AvaliarGarcom extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private String idGarcom;
    private float nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliar_garcom);

        databaseReference = ConexaoFirebase.getDatabaseReference(this);
        idGarcom = ConexaoFirebase.getIdGarcom();

        final RatingBar ratingRatingBar = (RatingBar) findViewById(R.id.rating_rating_bar);
        Button submitButton = (Button) findViewById(R.id.submit_button);
        final TextView ratingDisplayTextView = (TextView) findViewById(R.id.rating_display_text_View);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingDisplayTextView.setText("Your rating is: " + ratingRatingBar.getRating());
                nota = ratingRatingBar.getRating();
                salvarAvalizacao();
                finish();
            }
        });
    }

    private void salvarAvalizacao() {
        AvaliacaoGarcom ag = new AvaliacaoGarcom();
        ag.setUidAvaliacao(UUID.randomUUID().toString());
        ag.setIdGarcom(idGarcom);
        ag.setNota(nota);

        databaseReference.child("avaliacao").child(ag.getUidAvaliacao()).setValue(ag);

    }

}
