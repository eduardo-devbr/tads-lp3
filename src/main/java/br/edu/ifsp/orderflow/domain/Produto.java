package br.edu.ifsp.orderflow.domain;

import java.math.BigDecimal;

public class Produto {

    private final String id;
    private final String nome;
    private final BigDecimal preco;

<<<<<<< HEAD
    public Produto(String id, String nome, BigDecimal preco) {
=======
    public Produto(String id, String nome, BigDecimal preco){
>>>>>>> 7e8f8feaa9a5f3fda4786210d88d7668041d0e2c
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public String getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public BigDecimal getPreco() {
        return this.preco;
    }

    @Override
    public String toString() {
        return this.nome + " (R$ " + this.preco + ")";
    }
}
