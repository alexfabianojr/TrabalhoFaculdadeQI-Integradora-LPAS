package main.atividade.integradora.servicos.funcionalidades.impl;

import main.atividade.integradora.entity.Cliente;
import main.atividade.integradora.entity.Produto;
import main.atividade.integradora.servicos.funcionalidades.ServicoControleClientes;
import main.atividade.integradora.servicos.funcionalidades.ServicoProduto;

import java.math.BigDecimal;
import java.util.Scanner;

public class ServicoProdutoImpl implements ServicoProduto {

    @Override
    public void listarProdutosPorClientes(final ServicoControleClientes controleClientes) {
        String linhaDoPainel = "Produto Nome: %s - Produto Preco: 0.2%f - Produto ID: %s - Vendedor ID: %s - Vendedor Nome: %s \n";
        controleClientes
                .listarTodosClientes()
                .forEach(cliente -> {
                    System.out.println("\n--\n");
                    cliente
                            .getProdutos()
                            .forEach(produto -> System.out.printf(linhaDoPainel, produto.getNome(), produto.getValor(), produto.getId(), cliente.getId(), cliente.getNome()));
                });
    }

    @Override
    public void adicionar(final Scanner sc, final ServicoControleClientes controleClientes) {
        controleClientes.listarTodosClientes();
        System.out.println("--------------------------------------------------");
        System.out.println("Cadastrar novo produto");
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("Valor: ");
        BigDecimal valor = sc.nextBigDecimal();
        System.out.println("ID do Vendedor: ");
        String idVendedor = sc.nextLine();
        final Cliente vendedor = controleClientes.buscarCliente(idVendedor);
        Produto produto = new Produto(nome, valor, vendedor);
        adicionarProdutoNoCliente(controleClientes, idVendedor, produto);
        System.out.println("--------------------------------------------------");
    }

    private void adicionarProdutoNoCliente(final ServicoControleClientes controleClientes, final String idVendedor, final Produto produto) {
        controleClientes
                .listarTodosClientes()
                .forEach(cliente -> {
                    if (cliente.getId().equals(idVendedor)) {
                        cliente.addProduto(produto);
                        System.out.println("Produto adicionado com sucesso");
                    }
                });
    }

    @Override
    public void remover(final Scanner sc, final ServicoControleClientes controleClientes) {
        controleClientes.listarTodosClientes();
        System.out.println("--------------------------------------------------");
        System.out.println("Remover produto");
        System.out.println("ID do produto: ");
        String idProduto = sc.nextLine();
        System.out.println("ID do Vendedor: ");
        String idVendedor = sc.nextLine();
        removerProdutoNoCliente(controleClientes, idProduto, idVendedor);
    }

    private void removerProdutoNoCliente(final ServicoControleClientes controleClientes, final String idProduto, final String idVendedor) {
        controleClientes
                .listarTodosClientes()
                .forEach(cliente -> {
                    if (cliente.getId().equals(idVendedor)) {
                        cliente
                                .getProdutos()
                                .forEach(produto -> {
                                    if (produto.getId().equals(idProduto)) {
                                        cliente
                                                .getProdutos()
                                                .remove(produto);
                                    }
                                });
                    }
                });
    }
}
