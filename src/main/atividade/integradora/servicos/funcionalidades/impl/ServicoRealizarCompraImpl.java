package main.atividade.integradora.servicos.funcionalidades.impl;

import main.atividade.integradora.servicos.funcionalidades.ServicoControleClientes;
import main.atividade.integradora.servicos.funcionalidades.ServicoExecutarCompra;
import main.atividade.integradora.servicos.funcionalidades.ServicoProduto;
import main.atividade.integradora.servicos.funcionalidades.ServicoRealizarCompra;

import java.util.Scanner;

public class ServicoRealizarCompraImpl implements ServicoRealizarCompra {

    private static final String idClienteMensagem = "\n-> Insira o ID do cliente que ira comprar:";
    private static final String idProdutoMensagem = "-> Insira o ID do produto desejado:";
    private static final String quantidadeCompraMensagem = "-> Insira a quantidade da compra:";
    private static final String idVendedorMensagem = "-> Insira o ID do vendedor do produto:";

    @Override
    public void comprar(final Scanner sc, final ServicoControleClientes controleClientes) {
        ServicoProduto servicoProduto = new ServicoProdutoImpl();
        ServicoExecutarCompra servicoExecutarCompra = new ServicoExecutarCompraImpl();
        servicoProduto.listarProdutosPorClientes(controleClientes);
        System.out.println(idClienteMensagem);
        String idCliente = sc.next();
        System.out.println(idProdutoMensagem);
        String idProduto = sc.next();
        System.out.println(quantidadeCompraMensagem);
        int quantidadeCompra = sc.nextInt();
        System.out.println(idVendedorMensagem);
        String idVendedor = sc.next();
        final boolean isOperacaoSucesso = servicoExecutarCompra.isOperacaoSucesso(idCliente, idProduto, quantidadeCompra, idVendedor, controleClientes);
        if (isOperacaoSucesso) {
            System.out.println("Compra realizada com sucesso");
        } else {
            System.out.println("Erro ao executar a compra");
        }
    }
}
