package com.example.fastmeal.firebase;

import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class ConexaoFirebase {

    private static FirebaseDatabase firebaseDatabase;
    private static DatabaseReference databaseReference;
    private static String uIdCliente;
    private static String idMesa;
    private static String idGarcom;
    private static String nomeGarcom;
    private static String nomeMesa;


    public static DatabaseReference getDatabaseReference(Context context){
        if (firebaseDatabase == null){
            FirebaseApp.initializeApp(context);
            firebaseDatabase = FirebaseDatabase.getInstance();
            firebaseDatabase.setPersistenceEnabled(true);
        }
        if (databaseReference == null){
            databaseReference = firebaseDatabase.getReference();
        }
        return databaseReference;
    }


    public static String getuIdCliente(){
        if (uIdCliente==null){
            uIdCliente = UUID.randomUUID().toString();
        }
        return uIdCliente;
    }

    public static String getIdMesa() {
        return idMesa;
    }

    public static void setIdMesa(String idMesa) {
        ConexaoFirebase.idMesa = idMesa;
    }

    public static String getIdGarcom() {
        return idGarcom;
    }

    public static void setuIdCliente(String uIdCliente) {
        ConexaoFirebase.uIdCliente = uIdCliente;
    }

    public static String getNomeGarcom() {
        return nomeGarcom;
    }

    public static void setNomeGarcom(String nomeGarcom) {
        ConexaoFirebase.nomeGarcom = nomeGarcom;
    }

    public static String getNomeMesa() {
        return nomeMesa;
    }

    public static void setNomeMesa(String nomeMesa) {
        ConexaoFirebase.nomeMesa = nomeMesa;
    }

    public static void setIdGarcom(String idGarcom) {
        ConexaoFirebase.idGarcom = idGarcom;
    }
}
