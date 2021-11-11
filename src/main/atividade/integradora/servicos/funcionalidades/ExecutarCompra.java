package main.atividade.integradora.servicos.funcionalidades;

public interface ExecutarCompra {
    boolean isOperacaoSucesso(final String idCliente, final String idProduto, final int quantidadeCompra,
                              final String idVendedor, final ControleClientes controleClientes);
}
