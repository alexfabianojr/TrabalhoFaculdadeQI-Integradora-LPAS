package main.atividade.integradora.servicos.utils;

import main.atividade.integradora.entity.ClienteA;
import main.atividade.integradora.entity.ClienteB;

import java.math.BigDecimal;

public interface LimiteCreditoUtils {

    BigDecimal calcular(ClienteA clienteA);

    BigDecimal calcular(ClienteB clienteB);
}
