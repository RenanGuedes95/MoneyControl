package br.edu.vianna.finance.dao.imp;

import br.edu.vianna.finance.dao.GenericsDAO;
import br.edu.vianna.finance.dao.connectionDB.ConnectionFactory;
import br.edu.vianna.finance.model.finances.ETypeOfIncome;
import br.edu.vianna.finance.model.finances.Income;
import br.edu.vianna.finance.model.users.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IncomeDAO implements GenericsDAO<Income, Integer> {
    private Connection c;
    @Override
    public void insert(Income income) throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();
        String sql = "INSERT INTO financialapp.incomes \n" +
                     "(value, \n" +
                     "description, \n" +
                     "date, \n" +
                     "type_of_income, \n" +
                     "cpf_client) \n" +
                     "VALUES\n" +
                     "(?, \n" +
                     "?, \n" +
                     "?, \n" +
                     "?, \n" +
                     "?);";

        PreparedStatement pst = c.prepareStatement(sql);
        pst.setDouble(1, income.getValue());
        pst.setString(2, income.getDescription());
        pst.setObject(3, income.getDate());
        pst.setString(4, income.getType().toString());
        pst.setString(5, income.getClient().getCpf());

        pst.execute();
    }

    @Override
    public void alter(Income income) throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();
        String sql = "UPDATE financialapp.incomes \n" +
                     "SET \n" +
                     "value = ?, \n" +
                     "description = ?, \n" +
                     "date = ?, \n" +
                     "type_of_income = ?, \n" +
                     "cpf_client = ? \n" +
                     "WHERE idincomes = ? AND cpf_client = ?;";

        PreparedStatement pst = c.prepareStatement(sql);
        pst.setDouble(1, income.getValue());
        pst.setString(2, income.getDescription());
        pst.setObject(3, income.getDate());
        pst.setString(4, income.getType().toString());
        pst.setString(5, income.getClient().getCpf());
        pst.setInt(6, income.getId());
        pst.setString(7, income.getClient().getCpf());

        pst.execute();
    }

    @Override
    public void delete(Income income) throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();

        String sql = "DELETE FROM financialapp.incomes \n" +
                     "WHERE idincomes = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, income.getId());
        pst.execute();
    }

    @Override
    public Income searchOne(Integer id) throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();

        String sql = "SELECT idincomes, \n" +
                     "value, \n" +
                     "description, \n" +
                     "date, \n" +
                     "type_of_income, \n" +
                     "cpf_client \n" +
                     "FROM financialapp.incomes \n" +
                     "WHERE idincomes = ? ;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();

        Income i = null;
        if (rs.next()) {
            i = new Income();
            i.setId(rs.getInt("idincomes"));
            i.setValue(rs.getDouble("value"));
            i.setDescription(rs.getString("description"));
            i.setDate(rs.getDate("date").toLocalDate());
            i.setType(ETypeOfIncome.valueOf(rs.getString("type_of_income")));
            Client c = new ClientDAO().searchOne(rs.getString("cpf_client"));
            i.setClient(c);
        }
        return i;
    }

    @Override
    public ArrayList<Income> searchAll() throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();

        String sql = "SELECT idincomes, \n" +
                     "value, \n" +
                     "description, \n" +
                     "date, \n" +
                     "type_of_income, \n" +
                     "cpf_client \n" +
                     "FROM financialapp.incomes;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        ArrayList<Income> listOfIncomes = new ArrayList<>();
        Income i = null;
        while (rs.next()) {
            i = new Income();
            i.setId(rs.getInt("idincomes"));
            i.setValue(rs.getDouble("value"));
            i.setDescription(rs.getString("description"));
            i.setDate(rs.getDate("date").toLocalDate());
            i.setType(ETypeOfIncome.valueOf(rs.getString("type_of_income")));
            Client c = new ClientDAO().searchOne(rs.getString("cpf_client"));
            i.setClient(c);
            listOfIncomes.add(i);
        }

        return listOfIncomes;
    }

    public ArrayList<Income> searchClientIncomes(Client client) throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();

        String sql = "SELECT idincomes, \n" +
                     "value, \n" +
                     "description, \n" +
                     "date, \n" +
                     "type_of_income, \n" +
                     "cpf_client \n" +
                     "FROM financialapp.incomes \n" +
                     "WHERE cpf_client = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, client.getCpf());

        ResultSet rs = pst.executeQuery();

        ArrayList<Income> listOfClientIncomes = new ArrayList<>();
        Income i = null;
        while (rs.next()) {
            i = new Income();
            i.setId(rs.getInt("idincomes"));
            i.setValue(rs.getDouble("value"));
            i.setDescription(rs.getString("description"));
            i.setDate(rs.getDate("date").toLocalDate());
            i.setType(ETypeOfIncome.valueOf(rs.getString("type_of_income")));
            i.setClient(client);
            listOfClientIncomes.add(i);
        }
        return listOfClientIncomes;
    }

    public ArrayList<Income> searchMonthlyIncomes(Client client, int month, int year) throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();

        String sql = "SELECT idincomes, \n" +
                     "value, \n" +
                     "description, \n" +
                     "date, \n" +
                     "type_of_income, \n" +
                     "cpf_client \n" +
                     "FROM financialapp.incomes \n" +
                     "WHERE cpf_client = ? AND month(date) = ? AND year(date) = ? ;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, client.getCpf());
        pst.setInt(2, month);
        pst.setInt(3, year);

        ResultSet rs = pst.executeQuery();

        ArrayList<Income> listOfMonthlyIncomes = new ArrayList<>();
        Income i = null;
        while (rs.next()) {
            i = new Income();
            i.setId(rs.getInt("idincomes"));
            i.setValue(rs.getDouble("value"));
            i.setDescription(rs.getString("description"));
            i.setDate(rs.getDate("date").toLocalDate());
            i.setType(ETypeOfIncome.valueOf(rs.getString("type_of_income")));
            i.setClient(client);
            listOfMonthlyIncomes.add(i);
        }

        return listOfMonthlyIncomes;
    }

    public ArrayList<Income> searchTypeIncome(Client client, int idIncome) throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();

        String sql = "SELECT idincomes, \n" +
                     "value, \n" +
                     "description, \n" +
                     "date, \n" +
                     "type_of_income, \n" +
                     "cpf_client \n" +
                     "FROM financialapp.incomes \n" +
                     "WHERE cpf_client = ? AND type_of_income = ? ;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, client.getCpf());
        pst.setInt(2, idIncome);

        ResultSet rs = pst.executeQuery();

        ArrayList<Income> listOfTypeIncomes = new ArrayList<>();
        Income i = null;
        while (rs.next()) {
            i = new Income();
            i.setId(rs.getInt("idincomes"));
            i.setValue(rs.getDouble("value"));
            i.setDescription(rs.getString("description"));
            i.setDate(rs.getDate("date").toLocalDate());
            i.setType(ETypeOfIncome.valueOf(rs.getString("type_of_income")));
            i.setClient(client);
            listOfTypeIncomes.add(i);
        }
        return listOfTypeIncomes;
    }

    public int count() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT count(*) quantidade_de_receitas \n" +
                     "FROM financialapp.incomes;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        rs.next();

        return rs.getInt("quantidade_de_receitas");
    }
}
