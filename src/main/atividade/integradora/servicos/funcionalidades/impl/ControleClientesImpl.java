package main.atividade.integradora.servicos.funcionalidades.impl;

import main.atividade.integradora.entity.Cliente;
import main.atividade.integradora.servicos.funcionalidades.ControleClientes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ControleClientesImpl implements ControleClientes {

    private final List<Cliente> clientes = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void registrarCliente(Cliente cliente) {
        synchronized (this) {
            cliente.setId(UUID.randomUUID().toString());
        }
        clientes.add(cliente);
    }

    @Override
    public Cliente buscarCliente(String id) {
        return clientes
                .parallelStream()
                .filter(t -> t.getId().equals(id))
                .findAny()
                .orElseThrow();
    }

    @Override
    public List<Cliente> listarTodosClientes() {
        return clientes;
    }
}
