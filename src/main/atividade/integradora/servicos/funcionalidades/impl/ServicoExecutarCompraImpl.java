package main.atividade.integradora.servicos.funcionalidades.impl;

import main.atividade.integradora.entity.Bonus;
import main.atividade.integradora.entity.Cliente;
import main.atividade.integradora.entity.Produto;
import main.atividade.integradora.entity.Venda;
import main.atividade.integradora.servicos.funcionalidades.ServicoControleClientes;
import main.atividade.integradora.servicos.funcionalidades.ServicoExecutarCompra;
import main.atividade.integradora.servicos.utils.BonusUtils;
import main.atividade.integradora.servicos.utils.ClienteUtils;
import main.atividade.integradora.servicos.utils.LimiteCreditoUtils;
import main.atividade.integradora.servicos.utils.ProdutoUtils;

import java.math.BigDecimal;
import java.util.Objects;

public class ServicoExecutarCompraImpl implements ServicoExecutarCompra {

    @Override
    public boolean isOperacaoSucesso(final String idCliente, final String idProduto, final int quantidadeCompra,
                                     final String idVendedor, final ServicoControleClientes controleClientes) {
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
                venda.setBonusAplicado(BonusUtils.proximoBonusAtivo(clienteComprador));
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

    private void adicionarVendaParaCliente(final String idVendedor, final ServicoControleClientes controleClientes, final Venda venda) {
        controleClientes
                .listarTodosClientes()
                .forEach(cliente -> {
                    if (cliente.getId().equals(idVendedor)) {
                        cliente.addVenda(venda);
                    }
                });
    }

    private void adicionarCompraParaCliente(final String idCliente, final ServicoControleClientes controleClientes,
                                            final BigDecimal valorTotalCompra, final Venda venda) {
        controleClientes
                .listarTodosClientes()
                .forEach(cliente -> {
                    if (cliente.getId().equals(idCliente)) {
                        final Bonus bonusAplicado = venda.getBonusAplicado();
                        if (Objects.nonNull(bonusAplicado)) {
                            BigDecimal valorDesconto = valorTotalCompra.multiply(BigDecimal.valueOf(bonusAplicado.getPerc()));
                            System.out.println("Aplicando desconde a compra de: " + valorDesconto.doubleValue());
                            bonusAplicado.setUsado(true);
                            cliente.setLimiteCreditoUsado(cliente.getLimiteCreditoUsado().add(valorTotalCompra.subtract(valorDesconto)));
                        } else {
                            System.out.println("Nenhum desconto a ser aplicado");
                            cliente.setLimiteCreditoUsado(cliente.getLimiteCreditoUsado().add(valorTotalCompra));
                        }
                        cliente.addCompra(venda);
                    }
                });
    }
}
