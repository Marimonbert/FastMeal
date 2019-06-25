package com.example.fastmeal.cardapio.ui.listacardapio;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fastmeal.R;
import com.example.fastmeal.cardapio.ResponseCardapio.CardapioResponse;
import com.example.fastmeal.cardapio.GuiaCardapio.cardapio;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListaCardapioAdapter extends RecyclerView.Adapter<ListaCardapioAdapter.ListaCardapioViewHolder> {

    private List<cardapio> cardapios;

    private List<CardapioResponse> responses;


    public ListaCardapioAdapter(){
        cardapios = new ArrayList<>();

    }


    @NonNull
    @Override
    public ListaCardapioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardapio, parent, false);
        return new ListaCardapioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaCardapioViewHolder holder, int position) {
        holder.bind(cardapios.get(position));

    }


    @Override
    public int getItemCount() {
        return (cardapios != null && cardapios.size() > 0)? cardapios.size() : 0;
    }

    static class ListaCardapioViewHolder extends RecyclerView.ViewHolder {

        private TextView Txt_nome, txt_id, txt_descricao, txt_valor;

        private ImageView foto;

        public ListaCardapioViewHolder(@NonNull View itemView) {
            super(itemView);



            Txt_nome = itemView.findViewById(R.id.text_nome);
            txt_descricao = itemView.findViewById(R.id.txt_descricao);
            txt_id = itemView.findViewById(R.id.txt_id);
            txt_valor = itemView.findViewById(R.id.txt_valor);

            foto = itemView.findViewById(R.id.image_cardapio);

        }

        public void bind(cardapio cardapio) {

            Txt_nome.setText(cardapio.getNome());
            txt_descricao.setText(cardapio.getDescricao());
                txt_id.setText(cardapio.getId());
            txt_valor.setText(cardapio.getValor());

            Picasso.get().load("http://3.19.60.179/fastmeal/assets/imagens/" + cardapio.getFoto())
                    .into(foto);



        }
    }
    public void setCardapios(List<cardapio> cardapios){
        this.cardapios = cardapios;
        notifyDataSetChanged();
    }
}
