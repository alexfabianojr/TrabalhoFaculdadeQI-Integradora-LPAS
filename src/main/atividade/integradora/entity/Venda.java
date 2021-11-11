package main.atividade.integradora.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Venda {

    private final String id = UUID.randomUUID().toString();
    private Produto produto;
    private Cliente cliente;
    private Long quantidade;
    private LocalDateTime dataCompra;
    private boolean isCancelamento;

    private Venda() {}

    public Venda(Produto produto, Cliente cliente, Long quantidade) {
        this.produto = produto;
        this.cliente = cliente;
        this.quantidade = quantidade;
        this.isCancelamento = false;
        this.dataCompra = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public boolean isCancelamento() {
        return isCancelamento;
    }

    public void setCancelamento(boolean cancelamento) {
        isCancelamento = cancelamento;
    }
}
