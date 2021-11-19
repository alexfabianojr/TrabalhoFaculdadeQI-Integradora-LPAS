package main.atividade.integradora.servicos.funcionalidades.impl;

import main.atividade.integradora.entity.Bonus;
import main.atividade.integradora.servicos.funcionalidades.ServicoControleClientes;
import main.atividade.integradora.servicos.funcionalidades.ServicoFazerPagamento;
import main.atividade.integradora.servicos.utils.BonusUtils;
import main.atividade.integradora.servicos.utils.PagamentoUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ServicoFazerPagamentoImpl implements ServicoFazerPagamento {

    @Override
    public void painelPagar(final Scanner sc, final ServicoControleClientes controleClientes) {
        controleClientes.listarTodosClientes();
        System.out.println("Insira o ID do cliente que deseja pagar o credito usado");
        sc.nextLine();
        String idCliente = sc.nextLine();
        System.out.println("Insira o valor de pagamento:");
        BigDecimal valorPagamento = BigDecimal.valueOf(Double.parseDouble(sc.next()));
        fazerPagamentoCredito(controleClientes, idCliente, valorPagamento);
    }

    private void fazerPagamentoCredito(final ServicoControleClientes controleClientes, final String idCliente, final BigDecimal valorPagamento) {
        controleClientes
                .listarTodosClientes()
                .forEach(cliente -> {
                    if (cliente.getId().equals(idCliente)) {
                        cliente.setLimiteCreditoUsado(PagamentoUtils.pagarCreditoUsado(cliente, valorPagamento));
                        cliente.setPagamentosAcumuladosParaBonus(cliente.getPagamentosAcumuladosParaBonus().add(valorPagamento));
                        final List<Bonus> bonuses = BonusUtils.resgatarBonusComprasFuturas(cliente);
                        cliente.addAllBonus(bonuses);
                        System.out.println("Pagamento realizado com sucesso");
                    }
                });
    }
}
