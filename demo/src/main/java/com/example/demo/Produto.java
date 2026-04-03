package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable=false, unique=true )
    private String nome;

    @Column(nullable=false)
    private double preco;

    @Column(nullable=false)
    private int estoque;

    //gets
    public int getId(){return this.id;}
    public String getNome(){return this.nome;}
    public double getPreco(){return this.preco;}
    public int getEstoque(){return this.estoque;}
    //sets
    public void setId(int id){this.id = id;}
    public void setNome(String nome){this.nome = nome;}
    public void setPreco(double preco){this.preco = preco;}
    public void setEstoque(int estoque){this.estoque = estoque;}

}