package br.edu.vianna.finance.model.users;

import br.edu.vianna.finance.dao.imp.ExpenseDAO;
import br.edu.vianna.finance.model.finances.Expense;
import br.edu.vianna.finance.model.finances.FinancialGoal;
import br.edu.vianna.finance.model.finances.Income;

import java.sql.SQLException;
import java.util.ArrayList;

public class Client extends User{
    private String profession;
    private String maritalStatus;
    private ArrayList<Income> listOfIncomes;
    private ArrayList<Expense> listOfExpenses;
    private ArrayList<FinancialGoal> listOfFinancialGoal;


    public Client() {
        listOfIncomes = new ArrayList<>();
        listOfExpenses = new ArrayList<>();
        listOfFinancialGoal = new ArrayList<>();
    }

    public Client(String cpf, String name, String login, String email, String password, String profession, String maritalStatus) {
        super(cpf, name, login, email, password);
        setProfession(profession);
        setMaritalStatus(maritalStatus);
        listOfIncomes = new ArrayList<>();
        listOfExpenses = new ArrayList<>();
        listOfFinancialGoal = new ArrayList<>();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        if(profession != null && !profession.isEmpty() && !profession.isBlank()){
            this.profession = profession;
        }
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        if(maritalStatus != null && !maritalStatus.isEmpty() && !maritalStatus.isBlank()){
            this.maritalStatus = maritalStatus;
        }
    }

    public ArrayList<Income> getListOfIncomes() {
        return listOfIncomes;
    }

    public void setListOfIncomes(ArrayList<Income> listOfIncomes) {
        this.listOfIncomes = listOfIncomes;
    }

    public void addIncome(Income income){
        listOfIncomes.add(income);
    }

    public ArrayList<Expense> getListOfExpenses() {
        return listOfExpenses;
    }

    public void setListOfExpenses(ArrayList<Expense> listOfExpenses) {
        this.listOfExpenses = listOfExpenses;
    }

    public void addExpense(Expense expense){
        listOfExpenses.add(expense);
    }

    public ArrayList<FinancialGoal> getListOfFinancialGoal() {
        return listOfFinancialGoal;
    }

    public void setListOfFinancialGoal(ArrayList<FinancialGoal> listOfFinancialGoal) {
        this.listOfFinancialGoal = listOfFinancialGoal;
    }

    public void addFinancialGoal(FinancialGoal financialGoal){
        listOfFinancialGoal.add(financialGoal);
    }

    public ArrayList<Income> returnIncomesPerMonthAndYear(String month, String year) throws SQLException, ClassNotFoundException {
        ArrayList<Income> listOfMonthAndYear = new ArrayList<>();

        for(Income i : listOfIncomes){
            if(i.getDate().getMonthValue() == Integer.parseInt(month) && i.getDate().getYear() == Integer.parseInt(year)){
                listOfMonthAndYear.add(i);
            }
        }

        return listOfMonthAndYear;
    }

    public ArrayList<Expense> returnExpensesPerMonthAndYear(String month, String year) throws SQLException, ClassNotFoundException {
        ArrayList<Expense> listOfMonthAndYear = new ArrayList<>();

        for(Expense e : listOfExpenses){
            if(e.getDate().getMonthValue() == Integer.parseInt(month) && e.getDate().getYear() == Integer.parseInt(year)){
                listOfMonthAndYear.add(e);
            }
        }

        return listOfMonthAndYear;
    }

    public double calculateTotalIncomesByMonthAndYear(String month, String year){
        double totalValue = 0;
        for(Income i : listOfIncomes){
            if(i.getDate().getMonthValue() == Integer.parseInt(month) && i.getDate().getYear() == Integer.parseInt(year)){
                totalValue += i.getValue();
            }
        }
        return totalValue;
    }

    public double calculateTotalIncomes(){
        double totalValue = 0;
        for(Income i : listOfIncomes){
            totalValue += i.getValue();
        }
        return totalValue;
    }

    public double calculateTotalExpensesByMonthAndYear(String month, String year){
        double totalValue = 0;
        for(Expense e : listOfExpenses){
            if(e.getDate().getMonthValue() == Integer.parseInt(month) && e.getDate().getYear() == Integer.parseInt(year)){
                totalValue += e.getValue();
            }
        }
        return totalValue;
    }

    public double calculateTotalExpenses(){
        double totalValue = 0;
        for(Expense e : listOfExpenses){
           totalValue += e.getValue();
        }
        return totalValue;
    }

    public double calculateFinalBalance(String month, String year){
        return calculateTotalIncomesByMonthAndYear(month, year) - calculateTotalExpensesByMonthAndYear(month, year);
    }
}
