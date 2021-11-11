package main.atividade.integradora.servicos.funcionalidades.impl;

import main.atividade.integradora.entity.Cliente;
import main.atividade.integradora.servicos.funcionalidades.ControleClientes;
import main.atividade.integradora.servicos.funcionalidades.PainelListarClientes;

public class PainelListarClientesImpl implements PainelListarClientes {
    @Override
    public void listar(final ControleClientes controleClientes) {
        System.out.println("Total de clientes: " + controleClientes.listarTodosClientes().size());
        for (Cliente cliente : controleClientes.listarTodosClientes()) {
            System.out.println("Id: " + cliente.getId() + " Nome: " + cliente.getNome());
        }
    }
}
