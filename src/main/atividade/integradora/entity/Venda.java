package main.atividade.integradora.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Venda {

    private final String id = UUID.randomUUID().toString();
    private Produto produto;
    private Cliente clienteComprador;
    private Long quantidade;
    private LocalDateTime dataCompra;
    private boolean isCancelamento;
    private Cliente clienteVendedor;
    private boolean isCompraPaga;
    private Bonus bonusAplicado;

    private Venda() {}

    public Cliente getClienteVendedor() {
        return clienteVendedor;
    }

    public void setClienteVendedor(Cliente clienteVendedor) {
        this.clienteVendedor = clienteVendedor;
    }

    public Venda(Produto produto, Cliente clienteComprador, Cliente clienteVendedor, Long quantidade) {
        this.produto = produto;
        this.clienteComprador = clienteComprador;
        this.clienteVendedor = clienteVendedor;
        this.quantidade = quantidade;
        this.isCancelamento = false;
        this.dataCompra = LocalDateTime.now();
        this.isCompraPaga = false;
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

    public Cliente getClienteComprador() {
        return clienteComprador;
    }

    public void setClienteComprador(Cliente clienteComprador) {
        this.clienteComprador = clienteComprador;
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

    public boolean isCompraPaga() {
        return isCompraPaga;
    }

    public void setCompraPaga(boolean compraPaga) {
        isCompraPaga = compraPaga;
    }

    public Bonus getBonusAplicado() {
        return bonusAplicado;
    }

    public void setBonusAplicado(Bonus bonusAplicado) {
        this.bonusAplicado = bonusAplicado;
    }
}
