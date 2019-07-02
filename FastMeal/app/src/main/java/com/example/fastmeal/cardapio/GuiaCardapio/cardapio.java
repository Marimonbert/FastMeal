package com.example.fastmeal.cardapio.GuiaCardapio;

import java.io.Serializable;

public class cardapio implements Serializable {

    private String nome = "maria2";
    private String id;
    private String descricao = "linda2";
    private String valor;
    private String foto;
    private String idCategoria;
    private boolean escolhido;
    private int quantidade;
    private String uId;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public cardapio() {

    }


    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

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

    public boolean isEscolhido() {
        return escolhido;
    }

    public void setEscolhido(boolean escolhido) {
        this.escolhido = escolhido;
    }
}

