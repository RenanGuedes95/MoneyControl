package br.edu.vianna.finance.model.finances;

import br.edu.vianna.finance.model.users.Client;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class FinancialGoal {
    private int id;
    private String name;
    private String description;
    private double value;
    private double actualValue;
    private double monthlyContribuition;
    private LocalDate inicialDate;
    private LocalDate finalDate;

    private Boolean completed;
    private Client client;

    public FinancialGoal() {
    }

    public FinancialGoal(String name, String description, double value, double monthlyContribuition, LocalDate inicialDate, Client client) {
        setName(name);
        setDescription(description);
        setValue(value);
        setMonthlyContribuition(monthlyContribuition);
        setInicialDate(inicialDate);
        setFinalDate(calculateFinalDate());
        setActualValue(calculateAtualValue());
        setCompleted(checkGoalComplete());
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null && !name.isEmpty() && !name.isBlank()){
            this.name = name;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description != null && !description.isEmpty() && !description.isBlank()){
            this.description = description;
        }else{
            this.description = "";
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

    public double getActualValue() {
        return actualValue;
    }

    public double getMonthlyContribuition() {
        return monthlyContribuition;
    }

    public void setMonthlyContribuition(double monthlyContribuition) {
        if(monthlyContribuition > 0){
            this.monthlyContribuition = monthlyContribuition;
        }
    }

    public LocalDate getInicialDate() {
        return inicialDate;
    }

    public void setInicialDate(LocalDate inicialDate) {
        if(inicialDate != null){
            this.inicialDate = inicialDate;
        }
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(LocalDate finalDate) {
        this.finalDate = finalDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void setActualValue(double actualValue) {
        if(actualValue > 0){
            this.actualValue = actualValue;
        }else{
            this.actualValue = 0.00;
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

    public LocalDate calculateFinalDate(){
        return inicialDate.plusMonths(calculateInstallments() - 1);
    }

    public int calculateInstallments(){
        return (int) Math.ceil(value / monthlyContribuition);
    }

    public int calculateRemainingInstallments(){
        if(actualValue >= value){
            return 0;
        }else{
            return calculatePeriod();
        }
    }

    private int calculatePeriod() {
        Period period = Period.between(LocalDate.now(), finalDate);
        int totalMonths = (period.getYears() * 12 + period.getMonths()) + 1;
        if(totalMonths > 0){
            return totalMonths;
        }else{
            return 0;
        }
    }

    public double calculateAtualValue(){
        if(inicialDate.isAfter(LocalDate.now())){
            return 0;
        }else{
            int numberOfMonths = calculateInstallments() - calculateRemainingInstallments();
            if(checkGoalComplete() || numberOfMonths == 0){
                return value;
            }else{
                return monthlyContribuition * numberOfMonths;
            }
        }
    }

    public Boolean checkGoalComplete(){
        return calculateRemainingInstallments() <= 0;
    }

    public Double calculatePercentageCompleted() {
        if(calculateRemainingInstallments() == 0){
            return 100.00;
        }

        if(inicialDate.isAfter(LocalDate.now())){
            return 0.00;
        }else{
            return 100.00 - ((double) calculateRemainingInstallments() / (double) calculateInstallments()) * 100.00;
        }
    }
}
