package main.atividade.integradora.servicos.funcionalidades.impl;

import main.atividade.integradora.enums.InputEnum;
import main.atividade.integradora.servicos.funcionalidades.CadastrarCliente;
import main.atividade.integradora.servicos.funcionalidades.ControleClientes;
import main.atividade.integradora.servicos.funcionalidades.PainelListarClientes;
import main.atividade.integradora.servicos.funcionalidades.PainelPrincipal;

import java.util.Scanner;

public class PainelPrincipalImpl implements PainelPrincipal {

    @Override
    public boolean rodarPrograma(final Scanner sc, final ControleClientes controleClientes) throws Exception {
        CadastrarCliente cadastrarCliente = new CadastrarClienteImpl();
        PainelListarClientes painelListarClientes = new PainelListarClientesImpl();
        boolean rodarPrograma = true;
        System.out.println("Escolha a operacao");
        System.out.println("1 - Cadastrar Usuario");

        InputEnum input = InputEnum.get(sc.nextInt());

        switch (input) {
            case ENCERRAR_PROGRAMA -> rodarPrograma = false;
            case CADASTRAR_USUARIO -> cadastrarCliente.registrarPainel(sc, controleClientes);
            case REALIZAR_COMPRA -> System.out.println("REALIZAR_COMPRA");
            case LISTAR_CLIENTES -> painelListarClientes.listar(controleClientes);
            default -> System.out.println("XXX");
        }
        return rodarPrograma;
    }
}
