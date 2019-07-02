package com.example.fastmeal.Qrcode;



import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fastmeal.LigacoesClasse.LigacoesClasses;
import com.example.fastmeal.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import garcom.InicialGarcom;

public class QrcodeActivity extends AppCompatActivity {
    Button btnScan;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leitorqr_activity);


        btnScan = (Button) findViewById(R.id.btnScanner);


        final Activity activity = this;

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(activity);

                integrator.setDesiredBarcodeFormats (IntentIntegrator.QR_CODE_TYPES);
                integrator.setCameraId(0);

                integrator.initiateScan();


            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents()!= null){
                   if(result.getContents().toString().equals("1")) {
                       Intent intent = new Intent(this, LigacoesClasses.class);
                       startActivity(intent);


            } else {
                alert("Leitura Cancelada");

            }
            }else{
                alert("falha na leitura");


            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);

        }
    }

    protected void onActivity(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents()!= null){
                if(result.getContents().toString().equals("1")) {
                    Intent intent = new Intent(this, LigacoesClasses.class);
                    startActivity(intent);
                        

                } else {
                    alert("Leitura Cancelada");

                }
            }else{
                alert("falha na leitura");


            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);

        }
    }


    private void alert(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();


    }




}






