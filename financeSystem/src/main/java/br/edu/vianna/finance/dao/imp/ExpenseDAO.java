package br.edu.vianna.finance.dao.imp;

import br.edu.vianna.finance.dao.GenericsDAO;
import br.edu.vianna.finance.dao.connectionDB.ConnectionFactory;
import br.edu.vianna.finance.model.finances.ETypeOfExpense;
import br.edu.vianna.finance.model.finances.Expense;
import br.edu.vianna.finance.model.users.Client;

import java.sql.*;
import java.util.ArrayList;

public class ExpenseDAO implements GenericsDAO<Expense, Integer> {
    private Connection c;
    @Override
    public void insert(Expense expense) throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();
        String sql = "INSERT INTO financialapp.expenses \n" +
                     "(idexpenses, \n" +
                     "value, \n" +
                     "description, \n" +
                     "date, \n" +
                     "type_of_expense, \n" +
                     "cpf_client) \n" +
                     "VALUES\n" +
                     "(?, \n" +
                     "?, \n" +
                     "?, \n" +
                     "?, \n" +
                     "?, \n" +
                     "?);";

        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, expense.getId());
        pst.setDouble(2, expense.getValue());
        pst.setString(3, expense.getDescription());
        pst.setObject(4, expense.getDate());
        pst.setString(5, expense.getType().toString());
        pst.setString(6, expense.getClient().getCpf());

        pst.execute();
    }

    @Override
    public void alter(Expense expense) throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();
        String sql = "UPDATE financialapp.expenses \n" +
                "SET \n" +
                "idexpenses = ?, \n" +
                "value = ?, \n" +
                "description = ?, \n" +
                "date = ?, \n" +
                "type_of_expense = ?, \n" +
                "cpf_client = ? \n" +
                "WHERE idexpenses = ? AND cpf_client = ?;";

        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, expense.getId());
        pst.setDouble(2, expense.getValue());
        pst.setString(3, expense.getDescription());
        pst.setDate(4, Date.valueOf(expense.getDate()));
        pst.setString(5, expense.getType().toString());
        pst.setString(6, expense.getClient().getCpf());
        pst.setInt(7, expense.getId());
        pst.setString(8, expense.getClient().getCpf());

        pst.execute();
    }

    @Override
    public void delete(Expense expense) throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();

        String sql = "DELETE FROM financialapp.expenses \n" +
                     "WHERE idexpenses = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, expense.getId());
        pst.execute();
    }

    @Override
    public Expense searchOne(Integer id) throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();

        String sql = "SELECT idexpenses, \n" +
                "value, \n" +
                "description, \n" +
                "date, \n" +
                "type_of_expense, \n" +
                "cpf_client \n" +
                "FROM financialapp.expenses \n" +
                "WHERE idexpenses = ? ;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();

        Expense e = null;
        if (rs.next()) {
            e = new Expense();
            e.setId(rs.getInt("idexpenses"));
            e.setValue(rs.getDouble("value"));
            e.setDescription(rs.getString("description"));
            e.setDate(rs.getDate("date").toLocalDate());
            e.setType(ETypeOfExpense.valueOf(rs.getString("type_of_expense")));
            Client c = new ClientDAO().searchOne(rs.getString("cpf_client"));
            e.setClient(c);
        }
        return e;
    }

    @Override
    public ArrayList<Expense> searchAll() throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();

        String sql = "SELECT idexpenses, \n" +
                "value, \n" +
                "description, \n" +
                "date, \n" +
                "type_of_expense, \n" +
                "cpf_client \n" +
                "FROM financialapp.expenses;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        ArrayList<Expense> listOfExpenses = new ArrayList<>();
        Expense e = null;
        while (rs.next()) {
            e = new Expense();
            e.setId(rs.getInt("idexpenses"));
            e.setValue(rs.getDouble("value"));
            e.setDescription(rs.getString("description"));
            e.setDate(rs.getDate("date").toLocalDate());
            e.setType(ETypeOfExpense.valueOf(rs.getString("type_of_expense")));
            Client c = new ClientDAO().searchOne(rs.getString("cpf_client"));
            e.setClient(c);
            listOfExpenses.add(e);
        }

        return listOfExpenses;
    }

    public ArrayList<Expense> searchClientExpenses(Client client) throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();

        String sql = "SELECT idexpenses, \n" +
                "value, \n" +
                "description, \n" +
                "date, \n" +
                "type_of_expense, \n" +
                "cpf_client \n" +
                "FROM financialapp.expenses \n" +
                "WHERE cpf_client = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, client.getCpf());

        ResultSet rs = pst.executeQuery();

        ArrayList<Expense> listOfClientExpenses = new ArrayList<>();
        Expense e = null;
        while (rs.next()) {
            e = new Expense();
            e.setId(rs.getInt("idexpenses"));
            e.setValue(rs.getDouble("value"));
            e.setDescription(rs.getString("description"));
            e.setDate(rs.getDate("date").toLocalDate());
            e.setType(ETypeOfExpense.valueOf(rs.getString("type_of_expense")));
            e.setClient(client);
            listOfClientExpenses.add(e);
        }

        return listOfClientExpenses;
    }

    public ArrayList<Expense> searchMonthlyExpenses (Client client, int month, int year) throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();

        String sql = "SELECT idexpenses, \n" +
                "value, \n" +
                "description, \n" +
                "date, \n" +
                "type_of_expense, \n" +
                "cpf_client \n" +
                "FROM financialapp.expenses \n" +
                "WHERE cpf_client = ? AND month(date) = ? AND year(date) = ? ;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, client.getCpf());
        pst.setInt(2, month);
        pst.setInt(3, year);

        ResultSet rs = pst.executeQuery();

        ArrayList<Expense> listOfMonthlyExpenses = new ArrayList<>();
        Expense e = null;
        while (rs.next()) {
            e = new Expense();
            e.setId(rs.getInt("idexpenses"));
            e.setValue(rs.getDouble("value"));
            e.setDescription(rs.getString("description"));
            e.setDate(rs.getDate("date").toLocalDate());
            e.setType(ETypeOfExpense.valueOf(rs.getString("type_of_expense")));
            e.setClient(client);
            listOfMonthlyExpenses.add(e);
        }

        return listOfMonthlyExpenses;
    }

    public ArrayList<Expense> searchTypeExpense(Client client, int idExpense) throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();

        String sql = "SELECT idexpenses, \n" +
                "value, \n" +
                "description, \n" +
                "date, \n" +
                "type_of_expense, \n" +
                "cpf_client \n" +
                "FROM financialapp.expenses \n" +
                "WHERE cpf_client = ? AND type_of_expense = ? ;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, client.getCpf());
        pst.setInt(2, idExpense);

        ResultSet rs = pst.executeQuery();

        ArrayList<Expense> listOfTypeExpenses = new ArrayList<>();
        Expense e = null;
        while (rs.next()) {
            e = new Expense();
            e.setId(rs.getInt("idexpenses"));
            e.setValue(rs.getDouble("value"));
            e.setDescription(rs.getString("description"));
            e.setDate(rs.getDate("date").toLocalDate());
            e.setType(ETypeOfExpense.valueOf(rs.getString("type_of_expense")));
            e.setClient(client);
            listOfTypeExpenses.add(e);
        }
        return listOfTypeExpenses;
    }

    public int count() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT count(*) quantidade_de_despesas \n" +
                     "FROM financialapp.expenses;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        rs.next();

        return rs.getInt("quantidade_de_despesas");
    }
}
