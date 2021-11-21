package main.atividade.integradora.entity;

import java.math.BigDecimal;

public class ClienteA extends Cliente {

    private BigDecimal valorComprasPendenteAcrescerCredito;

    public BigDecimal getValorComprasPendenteAcrescerCredito() {
        return valorComprasPendenteAcrescerCredito;
    }

    public void setValorComprasPendenteAcrescerCredito(BigDecimal valorComprasPendenteAcrescerCredito) {
        this.valorComprasPendenteAcrescerCredito = valorComprasPendenteAcrescerCredito;
    }
}
