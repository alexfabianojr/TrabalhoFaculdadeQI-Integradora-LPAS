package main.atividade.integradora.servicos.funcionalidades.impl;

import main.atividade.integradora.entity.Cliente;
import main.atividade.integradora.servicos.funcionalidades.ServicoControleClientes;
import main.atividade.integradora.servicos.funcionalidades.ServicoListarClientes;

public class ServicoListarClientesImpl implements ServicoListarClientes {
    @Override
    public void listar(final ServicoControleClientes controleClientes) {
        System.out.println("Total de clientes: " + controleClientes.listarTodosClientes().size());
        for (Cliente cliente : controleClientes.listarTodosClientes()) {
            System.out.println("\n--\n");
            System.out.println("Id: " + cliente.getId() + " Nome: " + cliente.getNome());
        }
    }

    @Override
    public void listarDadosClientesJson(final ServicoControleClientes controleClientes) {
        System.out.println("Total de clientes: " + controleClientes.listarTodosClientes().size());
        for (Cliente cliente : controleClientes.listarTodosClientes()) {
            System.out.println("\n--\n");
            System.out.println(cliente.toString());
        }
    }
}
