package com.example.fastmeal.categoria.categoria.ui.categoria;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.fastmeal.R;
import com.example.fastmeal.cardapio.GuiaCardapio.cardapio;
import com.example.fastmeal.categoria.categoria.GuiaCategoria.categoria;

import java.util.ArrayList;
import java.util.List;

public class ListaCategoriaAdapter extends RecyclerView.Adapter<ListaCategoriaAdapter.ListaFilmesViewHolder> {

    private List<categoria> categorias;

    private static ItemCategoriaClickListener itemCategoriaClickListener;

    public ListaCategoriaAdapter(ItemCategoriaClickListener itemCategoriaClickListener) {
        this.itemCategoriaClickListener = itemCategoriaClickListener;

        categorias = new ArrayList<>();

    }


    @NonNull
    @Override
    public ListaFilmesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categoria, parent, false);
        return new ListaFilmesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaFilmesViewHolder holder, int position) {
        holder.bind(categorias.get(position));

    }


    @Override
    public int getItemCount() {
        return (categorias != null && categorias.size() > 0)? categorias.size() : 0;
    }

    static class ListaFilmesViewHolder extends RecyclerView.ViewHolder {

        private categoria categorias;


        private TextView Txt_nome;

        private ImageView foto;

        public ListaFilmesViewHolder(@NonNull View itemView) {
            super(itemView);
            Txt_nome = itemView.findViewById(R.id.txt_nome);
            foto = itemView.findViewById(R.id.image_categoria);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemCategoriaClickListener != null) {
                        itemCategoriaClickListener.onItemCategoriaClicado(categorias);
                    }
                }
            });


        }

        public void bind(categoria categorias) {

            this.categorias = categorias;

            Txt_nome.setText(categorias.getNome());

        }
    }
    public void setCategorias(List<categoria> categorias){
        this.categorias = categorias;
        notifyDataSetChanged();
    }

    public interface ItemCategoriaClickListener {

        void onItemCategoriaClicado(categoria categoria);
    }
}
