package main.atividade.integradora.factory;

import main.atividade.integradora.servicos.funcionalidades.ServicoExecutarCompra;
import main.atividade.integradora.servicos.funcionalidades.impl.ServicoExecutarCompraImpl;

public class ServicoExecutarCompraFactory {

    public static ServicoExecutarCompra instance() {
        return new ServicoExecutarCompraImpl();
    }
}
