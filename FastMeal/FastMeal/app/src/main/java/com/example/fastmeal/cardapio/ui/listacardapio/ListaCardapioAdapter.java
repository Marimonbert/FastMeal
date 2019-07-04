package com.example.fastmeal.cardapio.ui.listacardapio;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
        private CheckBox checkEscolha;

        private Spinner spinnerQuantidade;

        public ListaCardapioViewHolder(@NonNull View itemView) {
            super(itemView);

            Txt_nome = itemView.findViewById(R.id.text_nome);
            txt_descricao = itemView.findViewById(R.id.txt_descricao);
            txt_id = itemView.findViewById(R.id.txt_id);
            txt_valor = itemView.findViewById(R.id.txt_valor);

            foto = itemView.findViewById(R.id.image_cardapio);
            checkEscolha = itemView.findViewById(R.id.check_selecionar);
            spinnerQuantidade = itemView.findViewById(R.id.spinner);


        }

        private void eventoCheck(final cardapio cardapioO) {
            checkEscolha.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cardapioO.setEscolhido(checkEscolha.isChecked());
                }
            });

            spinnerQuantidade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    cardapioO.setQuantidade(Integer.parseInt(spinnerQuantidade.getItemAtPosition(position).toString()));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

        public void bind(cardapio cardapioO) {

            Txt_nome.setText(cardapioO.getNome());
            txt_descricao.setText(cardapioO.getDescricao());
                txt_id.setText(cardapioO.getId());
            txt_valor.setText(cardapioO.getValor());

            Picasso.get().load("http://3.19.60.179/fastmeal/assets/imagens/" + cardapioO.getFoto()).into(foto);
            eventoCheck(cardapioO);
        }
    }
    public void setCardapios(List<cardapio> cardapios){
        this.cardapios = cardapios;
        notifyDataSetChanged();
    }

    public List<cardapio> getCardapios(){
        return  cardapios;
    }

}
