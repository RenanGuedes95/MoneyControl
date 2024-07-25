package br.edu.vianna.finance.model.finances;

import br.edu.vianna.finance.model.users.Client;

import java.time.LocalDate;

public class Expense extends FinancialTransaction{
    private ETypeOfExpense type;

    public Expense() {
    }

    public Expense(double value, String description, LocalDate date, Client client, ETypeOfExpense type) {
        super(value, description, date, client);
        setType(type);
    }

    public ETypeOfExpense getType() {
        return type;
    }

    public void setType(ETypeOfExpense type) {
        this.type = type;
    }
}
