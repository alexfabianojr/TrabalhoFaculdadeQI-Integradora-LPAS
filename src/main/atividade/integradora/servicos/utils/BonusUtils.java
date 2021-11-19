package main.atividade.integradora.servicos.utils;

import main.atividade.integradora.entity.Bonus;
import main.atividade.integradora.entity.Cliente;
import main.atividade.integradora.enums.TipoClienteEnum;

import java.math.BigDecimal;
import java.util.*;

public class BonusUtils {

    private BonusUtils() {}

    private static final List<TipoClienteEnum> clientesQueNaoPossuemBonus = Collections.unmodifiableList(Arrays.asList(TipoClienteEnum.C));

    public static <T extends Cliente> Bonus proximoBonusAtivo(T cliente) {
        return cliente
                .getBonusCompras()
                .stream()
                .filter(bonus -> !bonus.isUsado())
                .findFirst()
                .orElse(null);
    }

    public static List<Bonus> resgatarBonusComprasFuturas(Cliente cliente) {
        List<Bonus> bonuses = new ArrayList<>();
        final TipoClienteEnum tipoClienteEnum = cliente.getTipoClienteEnum();
        if (!clientesQueNaoPossuemBonus.contains(tipoClienteEnum) ) {
            BigDecimal pagamentosAcumuladosParaBonus = cliente.getPagamentosAcumuladosParaBonus();
            final BigDecimal valorBonus = BonusUtils.valorPagoDesconto(tipoClienteEnum);
            while (pagamentosAcumuladosParaBonus.compareTo(BigDecimal.ZERO) >= 0 && pagamentosAcumuladosParaBonus.compareTo(valorBonus) >= 0) {
                pagamentosAcumuladosParaBonus = pagamentosAcumuladosParaBonus.subtract(valorBonus);
                bonuses.add(new Bonus(BonusUtils.percentualDesconto(tipoClienteEnum)));
            }
        } else {
            bonuses = Collections.emptyList();
        }
        return bonuses;
    }

    private static BigDecimal valorPagoDesconto(TipoClienteEnum tipoClienteEnum) {
        Map<TipoClienteEnum, BigDecimal> valorPagoDesconto = new EnumMap<>(TipoClienteEnum.class);
        valorPagoDesconto.put(TipoClienteEnum.A, BigDecimal.valueOf(2000.0));
        valorPagoDesconto.put(TipoClienteEnum.B, BigDecimal.valueOf(2000.0));
        return valorPagoDesconto.get(tipoClienteEnum);
    }

    private static Double percentualDesconto(TipoClienteEnum tipoClienteEnum) {
        Map<TipoClienteEnum, Double> percentualDesconto = new EnumMap<>(TipoClienteEnum.class);
        percentualDesconto.put(TipoClienteEnum.A, 0.10);
        percentualDesconto.put(TipoClienteEnum.B, 0.05);
        return percentualDesconto.get(tipoClienteEnum);
    }
}
