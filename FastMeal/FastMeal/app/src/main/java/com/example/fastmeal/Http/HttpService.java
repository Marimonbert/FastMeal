package com.example.fastmeal.Http;

import android.os.AsyncTask;

import com.example.fastmeal.mesas.data.model.mesa;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HttpService extends AsyncTask<Void, Void, mesa> {

    private String uidMesa;


    @Override
    protected mesa doInBackground(Void... voids) {


        StringBuilder resposta = new StringBuilder();

        //  if (this.cep != null && this.cep.length() == 8) {
        try {
            URL url = new URL("http://3.19.60.179/fastmeal/mesa/jsonid/"+uidMesa);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                resposta.append(scanner.next());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //   }
        String[] novaS = resposta.toString().split("\\[");
        String[] novaS2 = novaS[1].split("\\]");


        return new Gson().fromJson(novaS2[0].toString(), mesa.class);

    }



    public HttpService(String idMesa) {
        this.uidMesa = idMesa;
    }
}
