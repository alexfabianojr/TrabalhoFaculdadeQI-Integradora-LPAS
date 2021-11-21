package main.atividade.integradora.servicos.utils;

import main.atividade.integradora.entity.Cliente;
import main.atividade.integradora.servicos.funcionalidades.ServicoControleClientes;

public class ClienteUtils {

    public static Cliente getClienteById(final String idCliente, final ServicoControleClientes controleClientes) {
        return controleClientes
                .listarTodosClientes()
                .parallelStream()
                .filter(cliente -> cliente.getId().equals(idCliente))
                .findFirst()
                .orElseThrow();
    }
}
