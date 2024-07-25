package br.edu.vianna.finance.model.finances;

public enum ETypeOfExpense {
    ALUGUEL("Aluguel"),
    ALIMENTACAO("Alimentação"),
    CARTAO("Cartão de Crédito"),
    LUZ("Luz"),
    AGUA("Agua"),
    AUTOMOVEL("Automóvel"),
    LAZER("Lazer"),
    EXTRA("Extra"),
    OUTRO("Outro");

    private String type;

    ETypeOfExpense(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
