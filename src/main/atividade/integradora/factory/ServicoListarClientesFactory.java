package main.atividade.integradora.factory;

import main.atividade.integradora.servicos.funcionalidades.ServicoListarClientes;
import main.atividade.integradora.servicos.funcionalidades.impl.ServicoListarClientesImpl;

public class ServicoListarClientesFactory {

    public static ServicoListarClientes instance() {
        return new ServicoListarClientesImpl();
    }
}
