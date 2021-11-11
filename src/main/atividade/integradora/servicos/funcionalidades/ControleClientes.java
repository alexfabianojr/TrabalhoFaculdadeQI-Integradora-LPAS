package main.atividade.integradora.servicos.funcionalidades;

import main.atividade.integradora.entity.Cliente;

import java.util.List;

public interface ControleClientes {

    void registrarCliente(Cliente cliente);

    Cliente buscarCliente(String id);

    List<Cliente> listarTodosClientes();
}
