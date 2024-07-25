package br.edu.vianna.finance.model.finances;

import br.edu.vianna.finance.model.users.Client;

import java.time.LocalDate;

public class Income extends FinancialTransaction{

    private ETypeOfIncome type;

    public Income() {
    }

    public Income(double value, String description, LocalDate date, Client client, ETypeOfIncome type) {
        super(value, description, date, client);
        setType(type);
    }

    public ETypeOfIncome getType() {
        return type;
    }

    public void setType(ETypeOfIncome type) {
        this.type = type;
    }
}
