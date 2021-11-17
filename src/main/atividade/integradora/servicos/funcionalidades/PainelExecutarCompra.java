package main.atividade.integradora.servicos.funcionalidades;

public interface PainelExecutarCompra {
    boolean isOperacaoSucesso(final String idCliente, final String idProduto, final int quantidadeCompra,
                              final String idVendedor, final PainelControleClientes controleClientes);
}
