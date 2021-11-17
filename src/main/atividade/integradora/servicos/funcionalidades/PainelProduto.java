package main.atividade.integradora.servicos.funcionalidades;

import java.util.Scanner;

public interface PainelProduto {
    void listarProdutosPorClientes(final PainelControleClientes controleClientes);
    void adicionar(final Scanner sc, final PainelControleClientes controleClientes);

    void remover(final Scanner sc, final PainelControleClientes controleClientes);
}
