package main.atividade.integradora.servicos.utils.impl;

import main.atividade.integradora.entity.ClienteA;
import main.atividade.integradora.entity.ClienteB;
import main.atividade.integradora.servicos.utils.LimiteCreditoUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class LimiteCreditoUtilsImpl implements LimiteCreditoUtils {

    @Override
    public BigDecimal calcular(ClienteA clienteA) {
        final BigDecimal valorTotalEmCompras = clienteA
                .getCompras()
                .stream()
                .map(venda -> BigDecimal.valueOf(venda.getQuantidade()).multiply(venda.getProduto().getValor()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal qtdAcrescimoLimiteCredito = BigDecimal.valueOf(Math.floor(valorTotalEmCompras.divide(BigDecimal.valueOf(5000.0)).doubleValue()));
        BigDecimal acrescimo = BigDecimal.valueOf(500.0);
        return clienteA.getLimiteCreditoBase().add(acrescimo.multiply(qtdAcrescimoLimiteCredito));
    }

    @Override
    public BigDecimal calcular(ClienteB clienteB) {
        final int anosPassadosDesdeCadastro = Period.between(clienteB.getDataCadastro(), LocalDate.now()).getYears();
        BigDecimal limiteCreditoFinal = clienteB.getLimiteCreditoBase();
        BigDecimal porcentagemAcrescimo = BigDecimal.valueOf(10).divide(BigDecimal.valueOf(100));
        for (int i = 0; i < anosPassadosDesdeCadastro; i++) {
            limiteCreditoFinal = limiteCreditoFinal.multiply(porcentagemAcrescimo);
        }
        return limiteCreditoFinal;
    }
}
