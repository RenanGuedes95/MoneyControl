package br.edu.vianna.finance.model.finances;

import br.edu.vianna.finance.model.users.Client;

import java.time.LocalDate;

public abstract class FinancialTransaction {
    private int id;
    private double value;
    private String description;
    private LocalDate date;
    private Client client;

    public FinancialTransaction() {
    }

    public FinancialTransaction(double value, String description, LocalDate date, Client client) {
        setValue(value);
        setDescription(description);
        setDate(date);
        setClient(client);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id > 0){
            this.id = id;
        }
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        if(value > 0){
            this.value = value;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description != null && !description.isEmpty() && !description.isBlank()){
            this.description = description;
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if(date != null){
            this.date = date;
        }
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        if(client != null){
            this.client = client;
        }
    }
}
