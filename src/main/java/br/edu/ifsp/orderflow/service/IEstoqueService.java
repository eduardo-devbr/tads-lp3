package br.edu.ifsp.orderflow.service;

import br.edu.ifsp.orderflow.domain.Pedido;
import br.edu.ifsp.orderflow.domain.Produto;

public interface IEstoqueService {

    /**
<<<<<<< HEAD
     * Repõe unidades de um produto no estoque
     *
     * @param produto
     * @param quantidade
     * @return void
     */
    public void adicionarEstoque(Produto produto, int quantidade);

    /**
     * Quantidade disponível para um produto
     *
     * @param produto
     * @return int
     */
    public int quantidadeDisponivel(Produto produto);

    /**
     * Tenta reservar o estoque de todos os itens do pedido.
     *
     * @param pedido
     * @return true se conseguiu reservar, false do contrário
     */
=======
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

>>>>>>> 7e8f8feaa9a5f3fda4786210d88d7668041d0e2c
    public boolean reservar(Pedido pedido);

    /**
     * Devolve ao estoque os itens de um pedido (ex.: pagamento recusado)
     * @param pedido
     */
<<<<<<< HEAD
    public void liberar(Pedido pedido);
=======

    void liberar(Pedido pedido);



>>>>>>> 7e8f8feaa9a5f3fda4786210d88d7668041d0e2c
}
