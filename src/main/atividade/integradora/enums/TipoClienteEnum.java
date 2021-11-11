package main.atividade.integradora.enums;

public enum TipoClienteEnum {
    A(1), B(2), C(3);

    private final int valor;

    TipoClienteEnum(int valor) {
        this.valor = valor;
    }

    public static TipoClienteEnum get(int valor) throws Exception {
        for (TipoClienteEnum inputEnum : TipoClienteEnum.values()) {
            if (inputEnum.getValor() == valor) {
                return inputEnum;
            }
        }
        throw new Exception("Enum nao encontrado");
    }

    public int getValor() {
        return valor;
    }
}
