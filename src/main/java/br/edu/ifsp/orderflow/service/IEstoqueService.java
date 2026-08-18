package br.edu.ifsp.orderflow.service;

import br.edu.ifsp.orderflow.domain.Pedido;
import br.edu.ifsp.orderflow.domain.Produto;

public interface IEstoqueService {

    /**
     *
      * @param produto
     * @param quantidade
     * return void
     */

    public void adicionarEstoque(Produto produto, int quantidade);

    /**
     * quantidade disponivel para um produto
     * @param produto
     * @return int
     */

    public int quantidadeDisponivel(Produto produto);

    /**
     * tenta reservar o estoque de todos os itens do pedido
     * @param pedido
     * @return
     */

    public boolean reservar(Pedido pedido);

    /**
     * Devolve ao estoque os itens de um pedido (ex.: pagamento recusado)
     * @param pedido
     */

    void liberar(Pedido pedido);



}
