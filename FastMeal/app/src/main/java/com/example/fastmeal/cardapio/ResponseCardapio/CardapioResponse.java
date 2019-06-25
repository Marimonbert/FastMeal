package com.example.fastmeal.cardapio.ResponseCardapio;

import com.squareup.moshi.Json;

public class CardapioResponse {


    @Json(name = "id_categoria")
    private String idCategoria;

    @Json(name = "nome")
    private String nome;


    @Json(name = "descricao")
    private String descricao;

    @Json(name = "valor")
    private String valor;


    @Json(name = "foto")
    private String foto;

    @Json(name = "id")
    private String id;


    public CardapioResponse( String id,
                             String nome,
                             String descricao,
                             String valor,
                             String foto,
                             String idCategoria) {

        this.idCategoria = idCategoria;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.foto = foto;
        this.id = id;
    }


    public String getIdCategoria() {
        return idCategoria;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getValor() {
        return valor;
    }
        public String getFoto() {
        return foto;
    }
}