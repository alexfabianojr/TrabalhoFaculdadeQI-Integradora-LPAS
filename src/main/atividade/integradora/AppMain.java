package main.atividade.integradora;

import main.atividade.integradora.servicos.funcionalidades.ControleClientes;
import main.atividade.integradora.servicos.funcionalidades.PainelPrincipal;
import main.atividade.integradora.servicos.funcionalidades.impl.ControleClientesImpl;
import main.atividade.integradora.servicos.funcionalidades.impl.PainelPrincipalImpl;

import java.util.Scanner;

public class AppMain {

    public static void main(String[] args) {
        boolean rodarPrograma = true;
        PainelPrincipal painelPrincipal = new PainelPrincipalImpl();
        ControleClientes controleClientes = new ControleClientesImpl();
        try (Scanner sc = new Scanner(System.in)) {
            while (rodarPrograma) {
                try {
                    rodarPrograma = painelPrincipal.rodarPrograma(sc, controleClientes);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
