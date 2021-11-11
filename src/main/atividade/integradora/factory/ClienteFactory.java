package main.atividade.integradora.factory;

import main.atividade.integradora.entity.ClienteA;
import main.atividade.integradora.entity.ClienteB;
import main.atividade.integradora.entity.ClienteC;

public interface ClienteFactory {

    ClienteA tipoA(String nome);

    ClienteB tipoB(String nome);

    ClienteC tipoC(String nome);
}
