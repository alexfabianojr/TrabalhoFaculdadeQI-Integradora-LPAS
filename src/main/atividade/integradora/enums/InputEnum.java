package main.atividade.integradora.enums;

public enum InputEnum {

    ENCERRAR_PROGRAMA(0),
    CADASTRAR_USUARIO(1),
    ADICIONAR_PRODUTO(2),
    REALIZAR_COMPRA(3),
    REALIZAR_PAGAMENTO(4),
    REMOVER_PRODUTO(5),
    LISTAR_CLIENTES(6),
    LISTAR_CLIENTES_DETALHES(7),
    MOCKAR_DADOS_TESTE(8);

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
