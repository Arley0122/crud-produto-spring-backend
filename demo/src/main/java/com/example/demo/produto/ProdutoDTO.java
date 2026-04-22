package com.example.demo.produto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class ProdutoDTO {
    
    private int id;

    @Size(min=3, max=100)
    private String nome;

    @Positive(message = "o preço tem que obrigatoriamente ser maior que 0")
    private double preco;

    @PositiveOrZero
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