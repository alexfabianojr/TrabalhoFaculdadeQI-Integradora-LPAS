package main.atividade.integradora.teste.mock.bootstrap;

import main.atividade.integradora.entity.Cliente;
import main.atividade.integradora.entity.Produto;
import main.atividade.integradora.factory.ClienteFactory;
import main.atividade.integradora.servicos.funcionalidades.ServicoControleClientes;

import java.math.BigDecimal;

public class BootstrapTeste {

    private BootstrapTeste() {}

    public static void mockarDadosTeste(final ServicoControleClientes controleClientes) {

        System.out.println("Mockando dados");

        ClienteFactory factory = new ClienteFactory();

        Cliente clienteA = factory.tipoA("Joao");

        Produto produtoA1 = new Produto("Notebook", BigDecimal.valueOf(3500.0), clienteA);
        Produto produtoA2 = new Produto("IPhone", BigDecimal.valueOf(5000.0), clienteA);
        Produto produtoA3 = new Produto("Xiomi", BigDecimal.valueOf(1677.40), clienteA);

        clienteA.addProduto(produtoA1);
        clienteA.addProduto(produtoA2);
        clienteA.addProduto(produtoA3);

        Cliente clienteB = factory.tipoB("Pedro");

        Produto produtoB1 = new Produto("Cal�a Jeans", BigDecimal.valueOf(609.99), clienteA);
        Produto produtoB2 = new Produto("Camiseta Luxo", BigDecimal.valueOf(949.50), clienteA);
        Produto produtoB3 = new Produto("Tenis", BigDecimal.valueOf(678.10), clienteA);

        clienteB.addProduto(produtoB1);
        clienteB.addProduto(produtoB2);
        clienteB.addProduto(produtoB3);

        Cliente clienteC = factory.tipoC("Maria");

        Produto produtoC1 = new Produto("Saga Harry Potter", BigDecimal.valueOf(2200.0), clienteA);
        Produto produtoC2 = new Produto("Livros Calculo", BigDecimal.valueOf(345.79), clienteA);
        Produto produtoC3 = new Produto("SSHQ", BigDecimal.valueOf(1200.33), clienteA);

        clienteC.addProduto(produtoC1);
        clienteC.addProduto(produtoC2);
        clienteC.addProduto(produtoC3);

        controleClientes.registrarCliente(clienteA);
        controleClientes.registrarCliente(clienteB);
        controleClientes.registrarCliente(clienteC);

        System.out.println("Dados mockados com sucesso");
    }
}
