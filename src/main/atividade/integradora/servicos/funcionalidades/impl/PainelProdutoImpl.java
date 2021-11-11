package main.atividade.integradora.servicos.funcionalidades.impl;

import main.atividade.integradora.servicos.funcionalidades.ControleClientes;
import main.atividade.integradora.servicos.funcionalidades.PainelProduto;

public class PainelProdutoImpl implements PainelProduto {

    @Override
    public void listarProdutosPorClientes(final ControleClientes controleClientes) {
        String linhaDoPainel = "Produto Nome: %s - Produto Preco: 0.2%f - Produto ID: %s - Vendedor ID: %s - Vendedor Nome: %s \n";
        controleClientes
                .listarTodosClientes()
                .forEach(cliente -> cliente
                        .getProdutos()
                        .forEach(produto -> System.out.printf(linhaDoPainel, produto.getNome(), produto.getValor(), produto.getId(), cliente.getId(), cliente.getNome()))
                );
    }
}
