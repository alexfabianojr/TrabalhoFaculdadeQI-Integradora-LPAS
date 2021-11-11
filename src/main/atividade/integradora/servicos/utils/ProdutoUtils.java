package main.atividade.integradora.servicos.utils;

import main.atividade.integradora.entity.Cliente;
import main.atividade.integradora.entity.Produto;

public class ProdutoUtils {

    public static Produto getProdutoById(String idProduto, Cliente clienteVendedor) {
        return clienteVendedor
                .getProdutos()
                .parallelStream()
                .filter(produto1 -> produto1.getId().equals(idProduto))
                .findFirst()
                .orElseThrow();
    }
}
