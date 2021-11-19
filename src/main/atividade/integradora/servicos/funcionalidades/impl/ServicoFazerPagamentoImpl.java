package main.atividade.integradora.servicos.funcionalidades.impl;

import main.atividade.integradora.servicos.funcionalidades.ServicoControleClientes;
import main.atividade.integradora.servicos.funcionalidades.ServicoFazerPagamento;
import main.atividade.integradora.servicos.utils.PagamentoUtils;

import java.math.BigDecimal;
import java.util.Scanner;

public class ServicoFazerPagamentoImpl implements ServicoFazerPagamento {

    @Override
    public void painelPagar(final Scanner sc, final ServicoControleClientes controleClientes) {
        controleClientes.listarTodosClientes();
        System.out.println("Insira o ID do cliente que deseja pagar o credito usado");
        String idCliente = sc.nextLine();
        System.out.println("Insira o valor de pagamento:");
        BigDecimal valorPagamento = sc.nextBigDecimal();
        fazerPagamentoCredito(controleClientes, idCliente, valorPagamento);
    }

    private void fazerPagamentoCredito(final ServicoControleClientes controleClientes, final String idCliente, final BigDecimal valorPagamento) {
        controleClientes
                .listarTodosClientes()
                .forEach(cliente -> {
                    if (cliente.getId().equals(idCliente)) {
                        cliente.setLimiteCreditoUsado(PagamentoUtils.pagarCreditoUsado(cliente, valorPagamento));
                        System.out.println("Pagamento realizado com sucesso");
                    }
                });
    }
}
