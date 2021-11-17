package main.atividade.integradora.servicos.funcionalidades.impl;

import main.atividade.integradora.servicos.funcionalidades.PainelControleClientes;
import main.atividade.integradora.servicos.funcionalidades.PainelExecutarCompra;
import main.atividade.integradora.servicos.funcionalidades.PainelProduto;
import main.atividade.integradora.servicos.funcionalidades.PainelRealizarCompra;

import java.util.Scanner;

public class PainelRealizarCompraImpl implements PainelRealizarCompra {

    private static final String idClienteMensagem = "\n-> Insira o ID do cliente:";
    private static final String idProdutoMensagem = "-> Insira o ID do produto que deseja comprar:";
    private static final String quantidadeCompraMensagem = "-> Insira a quantidade da compra:";
    private static final String idVendedorMensagem = "-> Insira o ID do vendedor do produto:";

    @Override
    public void comprar(final Scanner sc, final PainelControleClientes controleClientes) {
        PainelProduto painelProduto = new PainelProdutoImpl();
        PainelExecutarCompra painelExecutarCompra = new PainelExecutarCompraImpl();
        painelProduto.listarProdutosPorClientes(controleClientes);
        System.out.println(idClienteMensagem);
        String idCliente = sc.next();
        System.out.println(idProdutoMensagem);
        String idProduto = sc.next();
        System.out.println(quantidadeCompraMensagem);
        int quantidadeCompra = sc.nextInt();
        System.out.println(idVendedorMensagem);
        String idVendedor = sc.next();

        final boolean isOperacaoSucesso = painelExecutarCompra.isOperacaoSucesso(idCliente, idProduto, quantidadeCompra, idVendedor, controleClientes);

        if (isOperacaoSucesso) {
            System.out.println("Compra realizada com sucesso");
        } else {
            System.out.println("Erro ao executar a compra");
        }
    }
}
