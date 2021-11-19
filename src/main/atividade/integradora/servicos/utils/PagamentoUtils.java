package main.atividade.integradora.servicos.utils;

import main.atividade.integradora.entity.Cliente;

import java.math.BigDecimal;

public class PagamentoUtils {

    public static BigDecimal pagarCreditoUsado(Cliente Cliente, BigDecimal valorPagamento) {
        return Cliente.getLimiteCreditoUsado().subtract(valorPagamento);
    }
}
