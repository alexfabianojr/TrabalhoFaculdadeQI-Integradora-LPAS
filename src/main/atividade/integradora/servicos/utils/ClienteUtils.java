package main.atividade.integradora.servicos.utils;

import main.atividade.integradora.entity.Cliente;
import main.atividade.integradora.servicos.funcionalidades.PainelControleClientes;

public class ClienteUtils {

    public static Cliente getClienteById(String idCliente, PainelControleClientes controleClientes) {
        return controleClientes
                .listarTodosClientes()
                .parallelStream()
                .filter(cliente -> cliente.getId().equals(idCliente))
                .findFirst()
                .orElseThrow();
    }
}
