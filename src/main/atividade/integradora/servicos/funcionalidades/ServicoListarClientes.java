package main.atividade.integradora.servicos.funcionalidades;

public interface ServicoListarClientes {
    void listar(final ServicoControleClientes controleClientes);

    void listarDadosClientesJson(ServicoControleClientes controleClientes);
}
