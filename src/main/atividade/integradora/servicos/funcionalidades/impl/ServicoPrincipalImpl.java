package main.atividade.integradora.servicos.funcionalidades.impl;

import main.atividade.integradora.enums.InputEnum;
import main.atividade.integradora.factory.*;
import main.atividade.integradora.servicos.funcionalidades.*;
import main.atividade.integradora.teste.mock.bootstrap.BootstrapTeste;

import java.util.Scanner;

public class ServicoPrincipalImpl implements ServicoPrincipal {

    private static final String textoPainel = """
            Escolha a operacao a ser executada
            0 - Encerrar Programa
            1 - Cadastrar Usuario
            2 - Adicionar Produto
            3 - Realizar Compra
            4 - Realizar Pagamento
            5 - Remover produto
            6 - Listar Clientes
            7 - Listar Clientes (DETALHES FINANCEIROS)
            8 - Mockar dados para teste""";

    @Override
    public boolean rodarPrograma(final Scanner sc, final ServicoControleClientes controleClientes) throws Exception {
        boolean rodarPrograma = true;
        System.out.println(textoPainel);
        InputEnum input = InputEnum.get(sc.nextInt());
        switch (input) {
            case ENCERRAR_PROGRAMA -> rodarPrograma = false;
            case CADASTRAR_USUARIO -> ServicoControleClientesFactory.instance().registrarNovoCliente(sc, controleClientes);
            case REALIZAR_COMPRA -> ServicoExecutarCompraFactory.instance().comprar(sc, controleClientes);
            case LISTAR_CLIENTES -> ServicoListarClientesFactory.instance().listar(controleClientes);
            case ADICIONAR_PRODUTO -> ServicoProdutoFactory.instance().adicionar(sc, controleClientes);
            case REMOVER_PRODUTO -> ServicoProdutoFactory.instance().remover(sc, controleClientes);
            case MOCKAR_DADOS_TESTE -> BootstrapTeste.mockarDadosTeste(controleClientes);
            case REALIZAR_PAGAMENTO -> ServicoFazerPagamentoFactory.instance().painelPagar(sc, controleClientes);
            case LISTAR_CLIENTES_DETALHES -> ServicoListarClientesFactory.instance().listarDadosClientesJson(controleClientes);
            default -> System.out.println("XXX");
        }
        return rodarPrograma;
    }
}
