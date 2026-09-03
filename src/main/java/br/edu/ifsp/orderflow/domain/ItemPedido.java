package br.edu.ifsp.orderflow.domain;

import java.math.BigDecimal;

public class ItemPedido {
<<<<<<< HEAD

    private final Produto produto;
    private final int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
=======
    private final Produto produto;
    private final int quantidade;

    public ItemPedido(Produto produto, int quantidade){
>>>>>>> 7e8f8feaa9a5f3fda4786210d88d7668041d0e2c
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

<<<<<<< HEAD
    public BigDecimal calcularSubtotal() {
=======
    public BigDecimal calcularSubtotal(){
>>>>>>> 7e8f8feaa9a5f3fda4786210d88d7668041d0e2c
        return this.produto.getPreco().multiply(BigDecimal.valueOf(this.quantidade));
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return this.quantidade + "x " + this.produto.getNome();
=======
        return this.quantidade + " x " + this.produto.getNome();
>>>>>>> 7e8f8feaa9a5f3fda4786210d88d7668041d0e2c
    }
}
