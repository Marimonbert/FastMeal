package com.example.fastmeal.mesas.ui.listamesas;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fastmeal.R;
import com.example.fastmeal.mesas.data.model.mesa;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;



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

        public ListaFilmesViewHolder(View itemView) {
            super(itemView);


            text_mesa = itemView.findViewById(R.id.text_mesa);

            text_garcom = itemView.findViewById(R.id.text_garcom);

            image_garcom = itemView.findViewById(R.id.image_garcom);



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
