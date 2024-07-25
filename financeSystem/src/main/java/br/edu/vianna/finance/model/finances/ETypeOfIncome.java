package br.edu.vianna.finance.model.finances;

public enum ETypeOfIncome {
    SALARIO("Salário"),
    INVESTIMENTO("Investimento"),
    HORA_EXTRA("Hora Extra"),
    OUTRO ("Outro");

    private String type;
    ETypeOfIncome(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
