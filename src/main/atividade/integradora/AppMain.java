package main.atividade.integradora;

import main.atividade.integradora.servicos.funcionalidades.PainelControleClientes;
import main.atividade.integradora.servicos.funcionalidades.PainelPrincipal;
import main.atividade.integradora.servicos.funcionalidades.impl.PainelControleClientesImpl;
import main.atividade.integradora.servicos.funcionalidades.impl.PainelPrincipalImpl;

import java.util.Scanner;

public class AppMain {

    public static void main(String[] args) {
        boolean rodarPrograma = true;
        PainelPrincipal painelPrincipal = new PainelPrincipalImpl();
        PainelControleClientes controleClientes = new PainelControleClientesImpl();
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
