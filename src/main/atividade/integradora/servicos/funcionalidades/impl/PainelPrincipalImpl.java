package main.atividade.integradora.servicos.funcionalidades.impl;

import main.atividade.integradora.enums.InputEnum;
import main.atividade.integradora.servicos.funcionalidades.*;

import java.util.Scanner;

public class PainelPrincipalImpl implements PainelPrincipal {

    @Override
    public boolean rodarPrograma(final Scanner sc, final PainelControleClientes controleClientes) throws Exception {
        PainelControleClientes painelControleClientes = new PainelControleClientesImpl();
        PainelListarClientes painelListarClientes = new PainelListarClientesImpl();
        PainelRealizarCompra painelRealizarCompra = new PainelRealizarCompraImpl();
        PainelProduto painelProduto = new PainelProdutoImpl();
        boolean rodarPrograma = true;
        System.out.println("Escolha a operacao");
        System.out.println("1 - Cadastrar Usuario");
        System.out.println("2 - Realizar Compra");
        System.out.println("3 - Listar Clientes");
        System.out.println("4 - Adicionar produto");
        System.out.println("5 - Remover produto");
        System.out.println("0 - Encerrar Programa");

        InputEnum input = InputEnum.get(sc.nextInt());

        switch (input) {
            case ENCERRAR_PROGRAMA -> rodarPrograma = false;
            case CADASTRAR_USUARIO -> painelControleClientes.registrarNovoCliente(sc, controleClientes);
            case REALIZAR_COMPRA -> painelRealizarCompra.comprar(sc, controleClientes);
            case LISTAR_CLIENTES -> painelListarClientes.listar(controleClientes);
            case ADICIONAR_PRODUTO -> painelProduto.adicionar(sc, controleClientes);
            case REMOVER_PRODUTO -> painelProduto.remover(sc, controleClientes);
            default -> System.out.println("XXX");
        }
        return rodarPrograma;
    }
}
