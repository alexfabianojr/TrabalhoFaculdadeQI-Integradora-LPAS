package main.atividade.integradora.servicos.funcionalidades;

import main.atividade.integradora.entity.Cliente;

import java.util.List;
import java.util.Scanner;

public interface PainelControleClientes {

    void registrarCliente(Cliente cliente);
    Cliente buscarCliente(String id);
    List<Cliente> listarTodosClientes();
    void registrarNovoCliente(final Scanner sc, final PainelControleClientes controleClientes) throws Exception;

}
