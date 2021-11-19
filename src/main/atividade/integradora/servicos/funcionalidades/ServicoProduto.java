package main.atividade.integradora.servicos.funcionalidades;

import java.util.Scanner;

public interface ServicoProduto {
    void listarProdutosPorClientes(final ServicoControleClientes controleClientes);
    void adicionar(final Scanner sc, final ServicoControleClientes controleClientes);

    void remover(final Scanner sc, final ServicoControleClientes controleClientes);
}
