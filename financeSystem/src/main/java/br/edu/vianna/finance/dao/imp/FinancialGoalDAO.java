package br.edu.vianna.finance.dao.imp;

import br.edu.vianna.finance.dao.GenericsDAO;
import br.edu.vianna.finance.dao.connectionDB.ConnectionFactory;
import br.edu.vianna.finance.model.finances.FinancialGoal;
import br.edu.vianna.finance.model.users.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FinancialGoalDAO implements GenericsDAO<FinancialGoal, Integer> {
    private Connection c;
    @Override
    public void insert(FinancialGoal goal) throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();
        String sql = "INSERT INTO financialapp.financial_goals \n" +
                     "(name, \n" +
                     "description, \n" +
                     "value, \n" +
                     "actual_value, \n" +
                     "monthly_contribuition, \n" +
                     "inicial_date, \n" +
                     "final_date, \n" +
                     "owner, \n" +
                     "completed) \n" +
                     "VALUES \n" +
                     "(?, \n" +
                     "?, \n" +
                     "?, \n" +
                     "?, \n" +
                     "?, \n" +
                     "?, \n" +
                     "?, \n" +
                     "?, \n" +
                     "?);";

        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, goal.getName());
        pst.setString(2, goal.getDescription());
        pst.setDouble(3, goal.getValue());
        pst.setDouble(4, goal.getActualValue());
        pst.setDouble(5, goal.getMonthlyContribuition());
        pst.setObject(6, goal.getInicialDate());
        pst.setObject(7, goal.getFinalDate());
        pst.setString(8, goal.getClient().getCpf());
        pst.setBoolean(9, goal.getCompleted());

        pst.execute();
    }

    @Override
    public void alter(FinancialGoal goal) throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();
        String sql = "UPDATE financialapp.financial_goals \n" +
                     "SET \n" +
                     "name = ?, \n" +
                     "description = ?, \n" +
                     "value = ?, \n" +
                     "actual_value = ?, \n" +
                     "monthly_contribuition = ?, \n" +
                     "inicial_date = ?, \n" +
                     "final_date = ?, \n" +
                     "owner = ?, \n" +
                     "completed = ? \n" +
                     "WHERE id = ?;";

        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, goal.getName());
        pst.setString(2, goal.getDescription());
        pst.setDouble(3, goal.getValue());
        pst.setDouble(4, goal.getActualValue());
        pst.setDouble(5, goal.getMonthlyContribuition());
        pst.setObject(6, goal.getInicialDate());
        pst.setObject(7, goal.getFinalDate());
        pst.setString(8, goal.getClient().getCpf());
        pst.setBoolean(9, goal.getCompleted());
        pst.setInt(10, goal.getId());

        pst.execute();
    }

    @Override
    public void delete(FinancialGoal goal) throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();

        String sql = "DELETE FROM financialapp.financial_goals \n" +
                     "WHERE id = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, goal.getId());
        pst.execute();
    }

    @Override
    public FinancialGoal searchOne(Integer id) throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();

        String sql = "SELECT financial_goals.id, \n" +
                     "name, \n" +
                     "description, \n" +
                     "value, \n" +
                     "actual_value, \n" +
                     "monthly_contribuition, \n" +
                     "inicial_date, \n" +
                     "final_date,\n" +
                     "owner, \n" +
                     "completed \n" +
                     "FROM financialapp.financial_goals \n" +
                     "WHERE id = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();

        FinancialGoal fg = null;
        if (rs.next()) {
            fg = new FinancialGoal();
            fg.setId(rs.getInt("id"));
            fg.setName(rs.getString("name"));
            fg.setDescription(rs.getString("description"));
            fg.setValue(rs.getDouble("value"));
            fg.setActualValue(rs.getDouble("actual_value"));
            fg.setMonthlyContribuition(rs.getDouble("monthly_contribuition"));
            fg.setInicialDate(rs.getDate("inicial_date").toLocalDate());
            fg.setFinalDate(rs.getDate("final_date").toLocalDate());
            Client c = new ClientDAO().searchOne(rs.getString("owner"));
            fg.setClient(c);
            fg.setCompleted(rs.getBoolean("completed"));
        }
        return fg;
    }

    @Override
    public ArrayList<FinancialGoal> searchAll() throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();

        String sql = "SELECT financial_goals.id, \n" +
                     "name, \n" +
                     "description, \n" +
                     "value, \n" +
                     "actual_value, \n" +
                     "monthly_contribuition, \n" +
                     "inicial_date, \n" +
                     "final_date,\n" +
                     "owner, \n" +
                     "completed \n" +
                     "FROM financialapp.financial_goals;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        ArrayList<FinancialGoal> listOfFinancialGoal = new ArrayList<>();
        FinancialGoal fg = null;
        while (rs.next()) {
            fg = new FinancialGoal();
            fg.setId(rs.getInt("id"));
            fg.setName(rs.getString("name"));
            fg.setDescription(rs.getString("description"));
            fg.setValue(rs.getDouble("value"));
            fg.setActualValue(rs.getDouble("actual_value"));
            fg.setMonthlyContribuition(rs.getDouble("monthly_contribuition"));
            fg.setInicialDate(rs.getDate("inicial_date").toLocalDate());
            fg.setFinalDate(rs.getDate("final_date").toLocalDate());
            Client c = new ClientDAO().searchOne(rs.getString("owner"));
            fg.setClient(c);
            fg.setCompleted(rs.getBoolean("completed"));
            listOfFinancialGoal.add(fg);
        }

        return listOfFinancialGoal;
    }

    public ArrayList<FinancialGoal> searchFinancialGoalClient(Client client) throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();

        String sql = "SELECT financial_goals.id, \n" +
                     "name, \n" +
                     "description, \n" +
                     "value, \n" +
                     "actual_value, \n" +
                     "monthly_contribuition, \n" +
                     "inicial_date, \n" +
                     "final_date,\n" +
                     "owner, \n" +
                     "completed \n" +
                     "FROM financialapp.financial_goals \n" +
                     "WHERE owner = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, client.getCpf());

        ResultSet rs = pst.executeQuery();

        ArrayList<FinancialGoal> listOfFinancialGoal = new ArrayList<>();
        FinancialGoal fg = null;
        while (rs.next()) {
            fg = new FinancialGoal();
            fg.setId(rs.getInt("id"));
            fg.setName(rs.getString("name"));
            fg.setDescription(rs.getString("description"));
            fg.setValue(rs.getDouble("value"));
            fg.setActualValue(rs.getDouble("actual_value"));
            fg.setMonthlyContribuition(rs.getDouble("monthly_contribuition"));
            fg.setInicialDate(rs.getDate("inicial_date").toLocalDate());
            fg.setFinalDate(rs.getDate("final_date").toLocalDate());
            fg.setClient(client);
            fg.setCompleted(rs.getBoolean("completed"));
            listOfFinancialGoal.add(fg);
        }

        return listOfFinancialGoal;
    }

    public int count() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT count(*) quantidade_de_metas \n" +
                     "FROM financialapp.financial_goals;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        rs.next();

        return rs.getInt("quantidade_de_metas");
    }
}
