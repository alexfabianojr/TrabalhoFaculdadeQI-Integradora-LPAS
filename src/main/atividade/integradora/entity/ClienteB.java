package main.atividade.integradora.entity;

import java.math.BigDecimal;

public class ClienteB extends Cliente {

    private BigDecimal pagamentosAcumuladosParaBonus;

    public BigDecimal getPagamentosAcumuladosParaBonus() {
        return pagamentosAcumuladosParaBonus;
    }

    public void setPagamentosAcumuladosParaBonus(BigDecimal pagamentosAcumuladosParaBonus) {
        this.pagamentosAcumuladosParaBonus = pagamentosAcumuladosParaBonus;
    }
}
