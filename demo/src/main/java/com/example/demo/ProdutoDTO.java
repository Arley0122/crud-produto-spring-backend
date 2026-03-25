package com.example.demo;

public class ProdutoDTO {
    
    private int id;
    private String nome;
    private double preco;
    private int estoque;

    public int getId(){return this.id;}
    public String getNome(){return this.nome;}
    public double getPreco(){return this.preco;}
    public int getEstoque(){return this.estoque;}

    public void setId(int id){this.id = id;}
    public void setNome(String nome){this.nome = nome;}
    public void setPreco(double preco){this.preco = preco;}
    public void setEstoque(int estoque){this.estoque = estoque;}

}