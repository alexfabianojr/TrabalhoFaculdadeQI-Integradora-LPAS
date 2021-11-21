package main.atividade.integradora.servicos.utils;

import main.atividade.integradora.dtos.LimiteCreditoProcessadoDto;
import main.atividade.integradora.entity.Cliente;
import main.atividade.integradora.entity.ClienteA;
import main.atividade.integradora.entity.Venda;

import java.math.BigDecimal;

public class LimiteCreditoUtils {

    private static final BigDecimal valorCompraQueAcrescentaCreditoClienteA = BigDecimal.valueOf(5000.0);
    private static final BigDecimal valorAcrescerLimiteCredito = BigDecimal.valueOf(500.0);

    public static BigDecimal calcularCreditoLivre(final Cliente Cliente) {
        return Cliente.getLimiteCredito().subtract(Cliente.getLimiteCreditoUsado());
    }

    public static LimiteCreditoProcessadoDto aumentarCreditoPorCompra(final ClienteA clienteA) {
        BigDecimal valorCalculadoParaProcessamento = clienteA.getValorComprasPendenteAcrescerCredito();
        BigDecimal limiteCreditoAtualizado = clienteA.getLimiteCredito();
        LimiteCreditoProcessadoDto limiteCreditoProcessadoDto = new LimiteCreditoProcessadoDto();
        while (formulaCalcularValorSuficienteParaProcessamento(valorCalculadoParaProcessamento)) {
            valorCalculadoParaProcessamento = valorCalculadoParaProcessamento.subtract(valorCalculadoParaProcessamento);
            limiteCreditoAtualizado = limiteCreditoAtualizado.add(valorAcrescerLimiteCredito);
        }
        limiteCreditoProcessadoDto.setLimiteCreditoAtualizado(limiteCreditoAtualizado);
        limiteCreditoProcessadoDto.setLimiteCreditoPendenteProcessamento(valorCalculadoParaProcessamento);
        return limiteCreditoProcessadoDto;
    }

    private static boolean formulaCalcularValorSuficienteParaProcessamento(final BigDecimal valorCalculadoParaProcessamento) {
        return valorCalculadoParaProcessamento.compareTo(BigDecimal.ZERO) >= 0
                && valorCalculadoParaProcessamento.compareTo(valorCompraQueAcrescentaCreditoClienteA) >= 0;
    }
}
