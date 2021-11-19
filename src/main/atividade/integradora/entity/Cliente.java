package main.atividade.integradora.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public abstract class Cliente {

    private String id;
    private String nome;
    private List<Venda> vendas = new ArrayList<>();
    private List<Venda> compras = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();
    private LocalDate dataCadastro = LocalDate.now();
    private BigDecimal limiteCredito;
    private BigDecimal limiteCreditoUsado;
    private LinkedList<Bonus> bonusCompras = new LinkedList<>();

    public void addVenda(Venda venda) {
        this.vendas.add(venda);
    }

    public void addCompra(Venda venda) {
        this.compras.add(venda);
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void addBonus(Bonus bonus) {
        this.bonusCompras.add(bonus);
    }

    public void removerBonus(int index) {
        this.bonusCompras.remove(index);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", Cliente.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("nome='" + nome + "'")
                .add("limiteCredito=" + limiteCredito)
                .add("limiteCreditoUsado=" + limiteCreditoUsado)
                .toString();
    }
}
