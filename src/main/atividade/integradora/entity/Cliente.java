package main.atividade.integradora.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public abstract class Cliente {

    private String id;
    private String nome;
    private List<Venda> vendas;
    private List<Venda> compras;
    private List<Produto> produtos;
    private LocalDate dataCadastro = LocalDate.now();
    private BigDecimal limiteCredito;
    private BigDecimal limiteCreditoUsado;
    private LinkedList<Bonus> bonusCompras;

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public List<Venda> getCompras() {
        return compras;
    }

    public void addVenda(Venda venda) {
        this.vendas.add(venda);
    }

    public void addCompra(Venda venda) {
        this.compras.add(venda);
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    public List<Bonus> getBonusCompras() {
        return bonusCompras;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public void setCompras(List<Venda> compras) {
        this.compras = compras;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public void setBonusCompras(LinkedList<Bonus> bonusCompras) {
        this.bonusCompras = bonusCompras;
    }

    public BigDecimal getLimiteCreditoUsado() {
        return limiteCreditoUsado;
    }

    public void setLimiteCreditoUsado(BigDecimal limiteCreditoUsado) {
        this.limiteCreditoUsado = limiteCreditoUsado;
    }
}
