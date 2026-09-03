package br.edu.ifsp.orderflow.infra;

<<<<<<< HEAD
import br.edu.ifsp.orderflow.domain.ItemPedido;
=======
>>>>>>> 7e8f8feaa9a5f3fda4786210d88d7668041d0e2c
import br.edu.ifsp.orderflow.domain.Pedido;
import br.edu.ifsp.orderflow.domain.Produto;
import br.edu.ifsp.orderflow.service.IEstoqueService;

import java.util.HashMap;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 7e8f8feaa9a5f3fda4786210d88d7668041d0e2c
import java.util.Map;

public class InMemoryEstoqueService implements IEstoqueService {

    private final Map<String, Integer> estoque = new HashMap<>();

    @Override
    public void adicionarEstoque(Produto produto, int quantidade) {
<<<<<<< HEAD
        int qtdAtual = this.estoque.getOrDefault(produto.getId(), 0);
=======
        int qtdAtual = this.estoque.getOrDefault(produto.getId(),0);
>>>>>>> 7e8f8feaa9a5f3fda4786210d88d7668041d0e2c
        this.estoque.put(produto.getId(), quantidade + qtdAtual);
    }

    @Override
    public int quantidadeDisponivel(Produto produto) {
<<<<<<< HEAD
        return this.estoque.getOrDefault(produto.getId(), 0);
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
=======
        return this.estoque.getOrDefault(produto.getId(),0);
>>>>>>> 7e8f8feaa9a5f3fda4786210d88d7668041d0e2c
    }

    @Override
    public boolean reservar(Pedido pedido) {
<<<<<<< HEAD

        List<ItemPedido> listaDeItens = pedido.getItens();

        // Conferir se todos os produtos têm estoque
        for (ItemPedido item : listaDeItens) {

            int disponivel = this.quantidadeDisponivel(item.getProduto());

            if (item.getQuantidade() > disponivel) {
                return false;
            }
        }

        this.sleep(50);

        for (ItemPedido item : listaDeItens) {

            Produto produto = item.getProduto();
            String produtoId = produto.getId(); // item.getProduto().getId()
            int quantidadeAtual = this.estoque.getOrDefault(produtoId, 0);
            this.estoque.put(produtoId, quantidadeAtual - item.getQuantidade());
        }

        return true;
=======
        return false;
>>>>>>> 7e8f8feaa9a5f3fda4786210d88d7668041d0e2c
    }

    @Override
    public void liberar(Pedido pedido) {

<<<<<<< HEAD
//        List<ItemPedido> itens = pedido.getItens();
//
//        for (ItemPedido item : itens) {
//
//            Produto produto = item.getProduto();
//            int disponivel = this.quantidadeDisponivel(item.getProduto());
//            this.estoque.put(produto.getId(), disponivel + item.getQuantidade());
//        }

        for (ItemPedido item : pedido.getItens()) {
            this.adicionarEstoque(item.getProduto(), item.getQuantidade());
        }
=======
>>>>>>> 7e8f8feaa9a5f3fda4786210d88d7668041d0e2c
    }
}
