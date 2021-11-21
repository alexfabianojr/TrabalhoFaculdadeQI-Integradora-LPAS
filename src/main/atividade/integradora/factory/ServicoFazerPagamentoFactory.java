package main.atividade.integradora.factory;

import main.atividade.integradora.servicos.funcionalidades.ServicoFazerPagamento;
import main.atividade.integradora.servicos.funcionalidades.impl.ServicoFazerPagamentoImpl;

public class ServicoFazerPagamentoFactory {

    public static ServicoFazerPagamento instance() {
        return new ServicoFazerPagamentoImpl();
    }
}
