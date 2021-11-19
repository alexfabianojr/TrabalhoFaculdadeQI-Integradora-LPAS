package main.atividade.integradora.entity;

import java.math.BigDecimal;
import java.util.UUID;

public class Produto {

    private final String id = UUID.randomUUID().toString();
    private String nome;
    private BigDecimal valor;
    private Cliente vendedor;

    private Produto() {}

    public Produto(String nome, BigDecimal valor, Cliente vendedor) {
        this.nome = nome;
        this.valor = valor;
        this.vendedor = vendedor;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Cliente getVendedor() {
        return vendedor;
    }

    public void setVendedor(Cliente vendedor) {
        this.vendedor = vendedor;
    }


}
