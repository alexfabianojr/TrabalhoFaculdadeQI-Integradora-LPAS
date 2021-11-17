package main.atividade.integradora.servicos.utils;

import main.atividade.integradora.entity.Cliente;

import java.math.BigDecimal;

public class LimiteCreditoUtils {

    public static BigDecimal calcularCreditoLivre(Cliente Cliente) {
        return Cliente.getLimiteCredito().subtract(Cliente.getLimiteCreditoUsado());
    }
}
