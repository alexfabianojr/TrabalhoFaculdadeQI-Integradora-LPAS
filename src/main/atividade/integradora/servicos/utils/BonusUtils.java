package main.atividade.integradora.servicos.utils;

import main.atividade.integradora.entity.Bonus;
import main.atividade.integradora.entity.Cliente;
import main.atividade.integradora.entity.ClienteA;
import main.atividade.integradora.entity.ClienteB;

import java.util.List;

public class BonusUtils {

    public <T extends Cliente> Bonus proximoBonusAtivo(T cliente) throws Exception {
        return cliente
                .getBonusCompras()
                .stream()
                .filter(bonus -> !bonus.isUsado())
                .findFirst()
                .orElseThrow(() -> new Exception("Nenhum bonus ativo foi encontrado"));
    }

    public List<Bonus> resgatarBonusComprasFuturas(ClienteA clienteA) {
        return null;
    }

    public List<Bonus> resgatarBonusComprasFuturas(ClienteB clienteB) {
        return null;
    }
}
