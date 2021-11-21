package main.atividade.integradora.servicos.funcionalidades.impl;

import main.atividade.integradora.dtos.LimiteCreditoProcessadoDto;
import main.atividade.integradora.entity.*;
import main.atividade.integradora.enums.TipoClienteEnum;
import main.atividade.integradora.servicos.funcionalidades.ServicoControleClientes;
import main.atividade.integradora.servicos.funcionalidades.ServicoExecutarCompra;
import main.atividade.integradora.servicos.funcionalidades.ServicoProduto;
import main.atividade.integradora.servicos.utils.BonusUtils;
import main.atividade.integradora.servicos.utils.ClienteUtils;
import main.atividade.integradora.servicos.utils.LimiteCreditoUtils;
import main.atividade.integradora.servicos.utils.ProdutoUtils;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Scanner;

public class ServicoExecutarCompraImpl implements ServicoExecutarCompra {

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
        executarProcessamentoCompra(idCliente, idProduto, quantidadeCompra, idVendedor, controleClientes);

    }

    public void executarProcessamentoCompra(final String idCliente, final String idProduto, final int quantidadeCompra,
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
        if (isSucesso) {
            System.out.println("Compra realizada com sucesso");
        } else {
            System.out.println("Erro ao executar a compra");
        }
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
                            aplicarLimiteCreditoUsadoComBonus(valorTotalCompra, cliente, bonusAplicado);
                        } else {
                            aplicarLimiteCreditoUsadoSemBonus(valorTotalCompra, cliente);
                        }
                        calcularAumentoLimiteCreditoClienteA(valorTotalCompra, cliente);
                        cliente.addCompra(venda);
                    }
                });
    }

    private void aplicarLimiteCreditoUsadoSemBonus(final BigDecimal valorTotalCompra, final Cliente cliente) {
        System.out.println("Nenhum desconto a ser aplicado");
        cliente.setLimiteCreditoUsado(cliente.getLimiteCreditoUsado().add(valorTotalCompra));
    }

    private static void aplicarLimiteCreditoUsadoComBonus(final BigDecimal valorTotalCompra, final Cliente cliente, final Bonus bonusAplicado) {
        BigDecimal valorDesconto = valorTotalCompra.multiply(BigDecimal.valueOf(bonusAplicado.getPerc()));
        System.out.println("Aplicando desconde a compra de: " + valorDesconto.doubleValue());
        bonusAplicado.setUsado(true);
        cliente.setLimiteCreditoUsado(cliente.getLimiteCreditoUsado().add(valorTotalCompra.subtract(valorDesconto)));
    }

    private static void calcularAumentoLimiteCreditoClienteA(final BigDecimal valorTotalCompra, final Cliente cliente) {
        if (cliente.getTipoClienteEnum().equals(TipoClienteEnum.A)) {
            BigDecimal valorComprasPendenteAcrescerCredito = ((ClienteA) cliente).getValorComprasPendenteAcrescerCredito().add(valorTotalCompra);
            ((ClienteA) cliente).setValorComprasPendenteAcrescerCredito(valorComprasPendenteAcrescerCredito);
            LimiteCreditoProcessadoDto limiteCreditoProcessadoDto = LimiteCreditoUtils.aumentarCreditoPorCompra(((ClienteA) cliente));
            ((ClienteA) cliente).setValorComprasPendenteAcrescerCredito(limiteCreditoProcessadoDto.getLimiteCreditoPendenteProcessamento());
            cliente.setLimiteCredito(limiteCreditoProcessadoDto.getLimiteCreditoAtualizado());
        }
    }
}
