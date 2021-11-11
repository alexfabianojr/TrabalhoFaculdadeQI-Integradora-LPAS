package main.atividade.integradora.servicos.funcionalidades.impl;

import main.atividade.integradora.entity.Cliente;
import main.atividade.integradora.enums.TipoClienteEnum;
import main.atividade.integradora.factory.ClienteFactory;
import main.atividade.integradora.factory.impl.ClienteFactoryImpl;
import main.atividade.integradora.servicos.funcionalidades.CadastrarCliente;
import main.atividade.integradora.servicos.funcionalidades.ControleClientes;

import java.util.Objects;
import java.util.Scanner;

public class CadastrarClienteImpl implements CadastrarCliente {

    @Override
    public void registrarPainel(final Scanner sc, final ControleClientes controleClientes) throws Exception {
        ClienteFactory clienteFactory = new ClienteFactoryImpl();
        Cliente cliente;
        System.out.println("Inserir o tipo do cliente");
        TipoClienteEnum tipoClienteEnum = TipoClienteEnum.get(sc.nextInt());
        System.out.println("Nome do cliente: ");
        String nome = sc.next();
        switch (tipoClienteEnum) {
            case A -> cliente = clienteFactory.tipoA(nome);
            case B -> cliente = clienteFactory.tipoB(nome);
            case C -> cliente = clienteFactory.tipoC(nome);
            default -> cliente = null;
        }
        if (Objects.nonNull(cliente)) {
            controleClientes.registrarCliente(cliente);
        }
    }
}
