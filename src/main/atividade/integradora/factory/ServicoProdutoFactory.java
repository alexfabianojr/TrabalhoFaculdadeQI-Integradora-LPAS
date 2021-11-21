package main.atividade.integradora.factory;

import main.atividade.integradora.servicos.funcionalidades.ServicoProduto;
import main.atividade.integradora.servicos.funcionalidades.impl.ServicoProdutoImpl;

public class ServicoProdutoFactory {

    public static ServicoProduto instance() {
        return new ServicoProdutoImpl();
    }
}
