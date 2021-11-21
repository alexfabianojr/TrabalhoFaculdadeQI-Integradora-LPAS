package main.atividade.integradora.dtos;

import java.math.BigDecimal;

public class LimiteCreditoProcessadoDto {

    private BigDecimal limiteCreditoAtualizado;
    private BigDecimal limiteCreditoPendenteProcessamento;

    public BigDecimal getLimiteCreditoAtualizado() {
        return limiteCreditoAtualizado;
    }

    public void setLimiteCreditoAtualizado(BigDecimal limiteCreditoAtualizado) {
        this.limiteCreditoAtualizado = limiteCreditoAtualizado;
    }

    public BigDecimal getLimiteCreditoPendenteProcessamento() {
        return limiteCreditoPendenteProcessamento;
    }

    public void setLimiteCreditoPendenteProcessamento(BigDecimal limiteCreditoPendenteProcessamento) {
        this.limiteCreditoPendenteProcessamento = limiteCreditoPendenteProcessamento;
    }
}
