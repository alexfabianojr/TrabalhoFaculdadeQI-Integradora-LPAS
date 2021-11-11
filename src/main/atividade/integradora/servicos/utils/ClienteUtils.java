package main.atividade.integradora.servicos.utils;

import main.atividade.integradora.entity.Cliente;
import main.atividade.integradora.servicos.funcionalidades.ControleClientes;

public class ClienteUtils {

    public static Cliente getClienteById(String idCliente, ControleClientes controleClientes) {
        return controleClientes
                .listarTodosClientes()
                .parallelStream()
                .filter(cliente -> cliente.getId().equals(idCliente))
                .findFirst()
                .orElseThrow();
    }
}
