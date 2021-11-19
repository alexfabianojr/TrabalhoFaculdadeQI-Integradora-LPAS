package main.atividade.integradora.servicos.funcionalidades;

import main.atividade.integradora.entity.Cliente;

import java.util.List;
import java.util.Scanner;

public interface ServicoControleClientes {

    void registrarCliente(Cliente cliente);
    Cliente buscarCliente(String id);
    List<Cliente> listarTodosClientes();
    void registrarNovoCliente(final Scanner sc, final ServicoControleClientes controleClientes) throws Exception;

}
