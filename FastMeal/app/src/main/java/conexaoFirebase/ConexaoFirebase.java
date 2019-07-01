package conexaoFirebase;

import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConexaoFirebase {

    private static FirebaseDatabase firebaseDatabase;
    private static DatabaseReference databaseReference;

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

}
