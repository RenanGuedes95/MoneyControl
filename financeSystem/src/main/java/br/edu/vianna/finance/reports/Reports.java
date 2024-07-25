package br.edu.vianna.finance.reports;

import br.edu.vianna.finance.dao.imp.ClientDAO;
import br.edu.vianna.finance.dao.imp.ExpenseDAO;
import br.edu.vianna.finance.dao.imp.FinancialGoalDAO;
import br.edu.vianna.finance.dao.imp.IncomeDAO;

import java.sql.SQLException;

public class Reports {
    public static int returnNumberOfClients() throws SQLException, ClassNotFoundException{
        return new ClientDAO().count();
    }

    public static int returnNumberOfIncomes() throws SQLException, ClassNotFoundException{
        return new IncomeDAO().count();
    }

    public static int returnNumberOfExpenses() throws SQLException, ClassNotFoundException{
        return new ExpenseDAO().count();
    }

    public static int returnNumberOfFinancialGoals() throws SQLException, ClassNotFoundException{
        return new FinancialGoalDAO().count();
    }
}
