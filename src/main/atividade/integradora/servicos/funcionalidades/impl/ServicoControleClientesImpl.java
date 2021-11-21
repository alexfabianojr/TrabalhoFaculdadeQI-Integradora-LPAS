package main.atividade.integradora.servicos.funcionalidades.impl;

import main.atividade.integradora.entity.Cliente;
import main.atividade.integradora.enums.TipoClienteEnum;
import main.atividade.integradora.factory.ClienteFactory;
import main.atividade.integradora.servicos.funcionalidades.ServicoControleClientes;

import java.util.*;

public class ServicoControleClientesImpl implements ServicoControleClientes {

    private final List<Cliente> clientes = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void registrarCliente(final Cliente cliente) {
        synchronized (this) {
            cliente.setId(UUID.randomUUID().toString());
        }
        clientes.add(cliente);
    }

    @Override
    public Cliente buscarCliente(final String id) {
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

    @Override
    public void registrarNovoCliente(final Scanner sc, final ServicoControleClientes controleClientes) throws Exception {
        Cliente cliente;
        System.out.println("Inserir o tipo do cliente (A - 1; B - 2; C - 3)");
        TipoClienteEnum tipoClienteEnum = TipoClienteEnum.get(sc.nextInt());
        sc.next();
        System.out.println("Nome do cliente: ");
        String nome = sc.nextLine();
        switch (tipoClienteEnum) {
            case A -> cliente = ClienteFactory.tipoA(nome);
            case B -> cliente = ClienteFactory.tipoB(nome);
            case C -> cliente = ClienteFactory.tipoC(nome);
            default -> cliente = null;
        }
        if (Objects.nonNull(cliente)) {
            controleClientes.registrarCliente(cliente);
        }
    }
}
