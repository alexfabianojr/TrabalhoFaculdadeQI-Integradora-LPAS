package main.atividade.integradora.servicos.utils;

import main.atividade.integradora.entity.Bonus;
import main.atividade.integradora.entity.Cliente;
import main.atividade.integradora.entity.ClienteA;
import main.atividade.integradora.entity.ClienteB;

import java.util.List;

public interface BonusUtils {

    <T extends Cliente> Bonus proximoBonusAtivo(T cliente) throws Exception;

    List<Bonus> resgatarBonusComprasFuturas(ClienteA clienteA);

    List<Bonus> resgatarBonusComprasFuturas(ClienteB clienteB);
}
