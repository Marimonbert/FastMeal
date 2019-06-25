package com.example.fastmeal.cardapio.GuiaCardapio;

import java.io.Serializable;

public class cardapio implements Serializable {
    private String nome;

    private String id;

    private String descricao;

    private String valor;

    private String foto;



    private String idCategoria;


    public cardapio(String id,
                    String nome,
                    String descricao,
                    String valor,
                    String foto,
                    String idCategoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.foto = foto;
        this.idCategoria = idCategoria;
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

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }
}

