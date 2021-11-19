package main.atividade.integradora.factory.impl;

import main.atividade.integradora.entity.ClienteA;
import main.atividade.integradora.entity.ClienteB;
import main.atividade.integradora.entity.ClienteC;
import main.atividade.integradora.factory.ClienteFactory;

import java.math.BigDecimal;

public class ClienteFactoryImpl implements ClienteFactory {

    @Override
    public ClienteA tipoA(String nome) {
        ClienteA clienteA = new ClienteA();
        clienteA.setNome(nome);
        clienteA.setLimiteCredito(BigDecimal.valueOf(10000.0));
        clienteA.setLimiteCreditoUsado(BigDecimal.ZERO);
        return clienteA;
    }

    @Override
    public ClienteB tipoB(String nome) {
        ClienteB clienteB = new ClienteB();
        clienteB.setNome(nome);
        clienteB.setLimiteCredito(BigDecimal.valueOf(5000.0));
        clienteB.setLimiteCreditoUsado(BigDecimal.ZERO);
        return clienteB;
    }

    @Override
    public ClienteC tipoC(String nome) {
        ClienteC clienteC = new ClienteC();
        clienteC.setNome(nome);
        clienteC.setLimiteCredito(BigDecimal.valueOf(1000.0));
        clienteC.setLimiteCreditoUsado(BigDecimal.ZERO);
        return clienteC;
    }
}
