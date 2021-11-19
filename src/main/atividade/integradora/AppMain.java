package main.atividade.integradora;

import main.atividade.integradora.servicos.funcionalidades.ServicoControleClientes;
import main.atividade.integradora.servicos.funcionalidades.ServicoPrincipal;
import main.atividade.integradora.servicos.funcionalidades.impl.ServicoControleClientesImpl;
import main.atividade.integradora.servicos.funcionalidades.impl.ServicoPrincipalImpl;

import java.util.Scanner;

public class AppMain {

    public static void main(String[] args) {
        boolean rodarPrograma = true;
        ServicoPrincipal servicoPrincipal = new ServicoPrincipalImpl();
        ServicoControleClientes controleClientes = new ServicoControleClientesImpl();
        try (Scanner sc = new Scanner(System.in)) {
            while (rodarPrograma) {
                try {
                    rodarPrograma = servicoPrincipal.rodarPrograma(sc, controleClientes);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
