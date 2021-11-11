package main.atividade.integradora.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public abstract class Cliente {

    private String id;
    private String nome;
    private List<Venda> vendas;
    private List<Venda> compras;
    private LocalDate dataCadastro = LocalDate.now();
    private BigDecimal limiteCreditoBase;
    private LinkedList<Bonus> bonusCompras;

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

    public BigDecimal getLimiteCreditoBase() {
        return limiteCreditoBase;
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

    public void setLimiteCreditoBase(BigDecimal limiteCreditoBase) {
        this.limiteCreditoBase = limiteCreditoBase;
    }

    public void setBonusCompras(LinkedList<Bonus> bonusCompras) {
        this.bonusCompras = bonusCompras;
    }
}
