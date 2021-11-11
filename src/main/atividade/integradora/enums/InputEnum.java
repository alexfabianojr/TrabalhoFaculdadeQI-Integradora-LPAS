package main.atividade.integradora.enums;

public enum InputEnum {

    ENCERRAR_PROGRAMA(0),
    CADASTRAR_USUARIO(1),
    REALIZAR_COMPRA(2),
    REALIZAR_PAGAMENTO(3),
    LISTAR_CLIENTES(4);

    private final int valor;

    InputEnum(int valor) {
        this.valor = valor;
    }

    public static InputEnum get(int valor) throws Exception {
        for (InputEnum  inputEnum : InputEnum.values()) {
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
