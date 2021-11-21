package main.atividade.integradora.factory;

import main.atividade.integradora.servicos.funcionalidades.ServicoControleClientes;
import main.atividade.integradora.servicos.funcionalidades.impl.ServicoControleClientesImpl;

public class ServicoControleClientesFactory {

    public static ServicoControleClientes instance() {
        return new ServicoControleClientesImpl();
    }
}
