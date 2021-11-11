package main.atividade.integradora.servicos.funcionalidades.impl;

import main.atividade.integradora.entity.Cliente;
import main.atividade.integradora.entity.Produto;
import main.atividade.integradora.entity.Venda;
import main.atividade.integradora.servicos.funcionalidades.ControleClientes;
import main.atividade.integradora.servicos.funcionalidades.ExecutarCompra;
import main.atividade.integradora.servicos.utils.ClienteUtils;
import main.atividade.integradora.servicos.utils.ProdutoUtils;

import java.math.BigDecimal;

public class ExecutarCompraImpl implements ExecutarCompra {

    @Override
    public boolean isOperacaoSucesso(final String idCliente, final String idProduto, final int quantidadeCompra,
                                     final String idVendedor, final ControleClientes controleClientes) {
        boolean isSucesso = false;
        try {
            final Cliente clienteComprador = ClienteUtils.getClienteById(idCliente, controleClientes);

            final Cliente clienteVendedor = ClienteUtils.getClienteById(idVendedor, controleClientes);

            final Produto produto = ProdutoUtils.getProdutoById(idProduto, clienteVendedor);

            BigDecimal valorTotalCompra = produto.getValor().multiply(BigDecimal.valueOf(quantidadeCompra));

            final boolean clientePossuiCreditoSuficiente = valorTotalCompra.compareTo(clienteComprador.getLimiteCreditoBase()) <= 0;

            if (clientePossuiCreditoSuficiente) {

                Venda venda = new Venda(produto, clienteComprador, clienteVendedor, (long) quantidadeCompra);

                controleClientes
                        .listarTodosClientes()
                        .forEach(cliente -> {
                            if (cliente.getId().equals(idCliente)) {
                                cliente.setLimiteCreditoBase(cliente.getLimiteCreditoBase().subtract(valorTotalCompra));
                                cliente.addCompra(venda);
                            }
                        });

                controleClientes
                        .listarTodosClientes()
                        .forEach(cliente -> {
                            if (cliente.getId().equals(idVendedor)) {
                                cliente.addVenda(venda);
                            }
                        });

                isSucesso = true;
            } else {
                //... TODO
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSucesso;
    }
}
