package com.example.fastmeal.mesas.ui.listamesas;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fastmeal.R;
import com.example.fastmeal.firebase.ConexaoFirebase;
import com.example.fastmeal.mesas.data.model.mesa;
import com.example.fastmeal.modelo.ChamaGarcon;
import com.google.firebase.database.DatabaseReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ListaMesasAdapter extends RecyclerView.Adapter<ListaMesasAdapter.ListaFilmesViewHolder> {

    private List<mesa> mesas;
    private static ItemMesaClickListener itemMesasClickListener;

    public ListaMesasAdapter(ItemMesaClickListener itemMesasClickListener) {
        this.itemMesasClickListener = itemMesasClickListener;

        mesas = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListaFilmesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mesa, parent, false);

        return new ListaFilmesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaFilmesViewHolder holder, int position) {
        holder.bind(mesas.get(position));
    }

    @Override
    public int getItemCount() {
        return (mesas != null && mesas.size() > 0) ? mesas.size() : 0;
    }

    static class ListaFilmesViewHolder extends RecyclerView.ViewHolder {

        private TextView text_mesa;
        private TextView text_garcom;
        private ImageView image_garcom;
        private mesa mesa;
        private Button btnChamar;


        public ListaFilmesViewHolder(View itemView) {
            super(itemView);


            text_mesa = itemView.findViewById(R.id.text_mesa);

            text_garcom = itemView.findViewById(R.id.text_garcom);

            image_garcom = itemView.findViewById(R.id.image_garcom);

            btnChamar = itemView.findViewById(R.id.btnChamar);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemMesasClickListener != null) {
                       itemMesasClickListener.onItemMesaClicada(mesa);
                    }
                }
            });
        }

        public void bind(mesa mesa) {
            this.mesa = mesa;

            text_garcom.setText(mesa.getNomeGarcom());

            text_mesa.setText(mesa.getNome());

            Picasso.get().load("http://3.19.60.179/fastmeal/assets/imagens/" + mesa.getFoto())
                    .into(image_garcom);

            chamandoGarcon(mesa);

        }

        private void chamandoGarcon(com.example.fastmeal.mesas.data.model.mesa mesa) {
            btnChamar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatabaseReference databaseReference = ConexaoFirebase.getDatabaseReference(null);
                    String idMesa = ConexaoFirebase.getIdMesa();
                    String idGarcon = ConexaoFirebase.getIdGarcom();

                    ChamaGarcon cg = new ChamaGarcon();
                    cg.setUidChamada(UUID.randomUUID().toString());
                    cg.setIdMesa(idMesa);
                    cg.setIdGarcom(idGarcon);
                    cg.setNomeMesa(ConexaoFirebase.getNomeMesa());

                    databaseReference.child("chamarGarcom").child(cg.getUidChamada()).setValue(cg);

                }
            });
        }

    }

    public void setMesas(List<mesa> mesas) {
        this.mesas = mesas;
        notifyDataSetChanged();
    }

    public interface ItemMesaClickListener {

        void onItemMesaClicada(mesa mesa);
    }
}
