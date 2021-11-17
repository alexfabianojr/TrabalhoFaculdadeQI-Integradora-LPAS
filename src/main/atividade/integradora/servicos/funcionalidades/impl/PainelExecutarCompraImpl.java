package main.atividade.integradora.servicos.funcionalidades.impl;

import main.atividade.integradora.entity.Cliente;
import main.atividade.integradora.entity.Produto;
import main.atividade.integradora.entity.Venda;
import main.atividade.integradora.servicos.funcionalidades.PainelControleClientes;
import main.atividade.integradora.servicos.funcionalidades.PainelExecutarCompra;
import main.atividade.integradora.servicos.utils.ClienteUtils;
import main.atividade.integradora.servicos.utils.LimiteCreditoUtils;
import main.atividade.integradora.servicos.utils.ProdutoUtils;

import java.math.BigDecimal;

public class PainelExecutarCompraImpl implements PainelExecutarCompra {

    @Override
    public boolean isOperacaoSucesso(final String idCliente, final String idProduto, final int quantidadeCompra,
                                     final String idVendedor, final PainelControleClientes controleClientes) {
        boolean isSucesso = false;
        try {
            final Cliente clienteComprador = ClienteUtils.getClienteById(idCliente, controleClientes);
            final Cliente clienteVendedor = ClienteUtils.getClienteById(idVendedor, controleClientes);
            final Produto produto = ProdutoUtils.getProdutoById(idProduto, clienteVendedor);
            BigDecimal valorTotalCompra = produto.getValor().multiply(BigDecimal.valueOf(quantidadeCompra));
            BigDecimal valorCreditoLivre = LimiteCreditoUtils.calcularCreditoLivre(clienteComprador);
            final boolean clientePossuiCreditoSuficiente = valorTotalCompra.compareTo(valorCreditoLivre) <= 0;
            if (clientePossuiCreditoSuficiente) {
                Venda venda = new Venda(produto, clienteComprador, clienteVendedor, (long) quantidadeCompra);
                adicionarCompraParaCliente(idCliente, controleClientes, valorTotalCompra, venda);
                adicionarVendaParaCliente(idVendedor, controleClientes, venda);
                isSucesso = true;
            } else {
                System.out.println("O cliente nao possui credito suficiente");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSucesso;
    }

    private void adicionarVendaParaCliente(final String idVendedor, final PainelControleClientes controleClientes, final Venda venda) {
        controleClientes
                .listarTodosClientes()
                .forEach(cliente -> {
                    if (cliente.getId().equals(idVendedor)) {
                        cliente.addVenda(venda);
                    }
                });
    }

    private void adicionarCompraParaCliente(final String idCliente, final PainelControleClientes controleClientes,
                                            final BigDecimal valorTotalCompra, final Venda venda) {
        controleClientes
                .listarTodosClientes()
                .forEach(cliente -> {
                    if (cliente.getId().equals(idCliente)) {
                        cliente.setLimiteCreditoUsado(cliente.getLimiteCreditoUsado().add(valorTotalCompra));
                        cliente.addCompra(venda);
                    }
                });
    }
}