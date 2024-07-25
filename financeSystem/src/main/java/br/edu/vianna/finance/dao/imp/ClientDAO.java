package br.edu.vianna.finance.dao.imp;

import br.edu.vianna.finance.dao.GenericsDAO;
import br.edu.vianna.finance.dao.connectionDB.ConnectionFactory;
import br.edu.vianna.finance.model.finances.Expense;
import br.edu.vianna.finance.model.finances.FinancialGoal;
import br.edu.vianna.finance.model.finances.Income;
import br.edu.vianna.finance.model.users.Client;
import br.edu.vianna.finance.utils.CryptoUtils;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ClientDAO implements GenericsDAO<Client, String> {
    private Connection c;

    @Override
    public void insert(Client client) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "INSERT INTO financialapp.clients \n" +
                     "(cpf, \n" +
                     "name, \n" +
                     "login, \n" +
                     "email, \n" +
                     "password, \n" +
                     "profession, \n" +
                     "maritalStatus, \n" +
                     "dateOfRegister)\n" +
                     "VALUES\n" +
                     "(?, \n" +
                     "?, \n" +
                     "?, \n" +
                     "?, \n" +
                     "?, \n" +
                     "?, \n" +
                     "?, \n" +
                     "?);";

        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, client.getCpf());
        pst.setString(2, client.getName());
        pst.setString(3, client.getLogin());
        pst.setString(4, client.getEmail());
        try {
            pst.setString(5, CryptoUtils.md5(client.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            throw new SQLException("Erro: A senha não foi gerada corretamente!");
        }
        pst.setString(6, client.getProfession());
        pst.setString(7, client.getMaritalStatus());
        pst.setString(8, client.getDateOfRegister().toString());

        pst.execute();
    }

    @Override
    public void alter(Client client) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "UPDATE financialapp.clients \n" +
                     "SET \n" +
                     "cpf = ?, \n" +
                     "name = ?, \n" +
                     "login = ?, \n" +
                     "email = ?, \n" +
                     "password = ?, \n" +
                     "profession = ?, \n" +
                     "maritalStatus = ? \n" +
                     "WHERE cpf = ?;";

        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, client.getCpf());
        pst.setString(2, client.getName());
        pst.setString(3, client.getLogin());
        pst.setString(4, client.getEmail());
        try {
            pst.setString(5, CryptoUtils.md5(client.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            throw new SQLException("Erro: A senha não foi gerada corretamente!");
        }
        pst.setString(6, client.getProfession());
        pst.setString(7, client.getMaritalStatus());
        pst.setString(8, client.getCpf());

        pst.execute();
    }
//
    @Override
    public void delete(Client client) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();

        String sql = "DELETE FROM financialapp.clients \n" +
                     "WHERE cpf = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, client.getCpf());
        pst.execute();
    }

    @Override
    public Client searchOne(String cpf) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();

        String sql = "SELECT cpf, name, login, email, password, \n" +
                     "profession, maritalStatus, dateOfRegister \n" +
                     "FROM financialapp.clients \n" +
                     "WHERE cpf = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, cpf);

        ResultSet rs = pst.executeQuery();

        Client cli = null;
        if (rs.next()) {
            cli = new Client();
            cli.setCpf(rs.getString("cpf"));
            cli.setName(rs.getString("name"));
            cli.setLogin(rs.getString("login"));
            cli.setEmail(rs.getString("email"));
            cli.setPassword(rs.getString("password"));
            cli.setProfession(rs.getString("profession"));
            cli.setMaritalStatus(rs.getString("maritalStatus"));
            String dt = rs.getString("dateOfRegister");
            if (dt != null && !dt.isEmpty() && !dt.isBlank()) {
                LocalDateTime dt1 = LocalDateTime.parse(dt.substring(0, 16),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                cli.setDateOfRegister(dt1);
            }
            ArrayList<Income> listOfIncomes = new IncomeDAO().searchClientIncomes(cli);
            cli.setListOfIncomes(listOfIncomes);
            ArrayList<Expense> listOfExpenses = new ExpenseDAO().searchClientExpenses(cli);
            cli.setListOfExpenses(listOfExpenses);
            ArrayList<FinancialGoal> listOfFinancialGoal = new FinancialGoalDAO().searchFinancialGoalClient(cli);
            cli.setListOfFinancialGoal(listOfFinancialGoal);
        }

       return cli;
    }

    public Client searchClientByLoginAndPassword(String login, String password) throws SQLException, ClassNotFoundException {

        c = ConnectionFactory.getConnection();
        String sql = "SELECT cpf, name, login, email, password, \n" +
                     "profession, maritalStatus, dateOfRegister \n" +
                     "FROM financialapp.clients \n" +
                     "WHERE login = ? AND password = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, login);
        try {
            pst.setString(2, CryptoUtils.md5(password));
        } catch (NoSuchAlgorithmException e) {
            throw new SQLException("Erro ao criptografar a senha!");
        }

        ResultSet rs = pst.executeQuery();

        Client cli = null;
        if (rs.next()) {
            cli = new Client();
            cli.setCpf(rs.getString("cpf"));
            cli.setName(rs.getString("name"));
            cli.setLogin(rs.getString("login"));
            cli.setEmail(rs.getString("email"));
            cli.setPassword(rs.getString("password"));
            cli.setProfession(rs.getString("profession"));
            cli.setMaritalStatus(rs.getString("maritalStatus"));
            String dt = rs.getString("dateOfRegister");
            if (dt != null && !dt.isEmpty() && !dt.isBlank()) {
                LocalDateTime dt1 = LocalDateTime.parse(dt.substring(0, 16),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                cli.setDateOfRegister(dt1);
            }
            ArrayList<Income> listOfIncomes = new IncomeDAO().searchClientIncomes(cli);
            cli.setListOfIncomes(listOfIncomes);
            ArrayList<Expense> listOfExpenses = new ExpenseDAO().searchClientExpenses(cli);
            cli.setListOfExpenses(listOfExpenses);
            ArrayList<FinancialGoal> listOfFinancialGoal = new FinancialGoalDAO().searchFinancialGoalClient(cli);
            cli.setListOfFinancialGoal(listOfFinancialGoal);
        }

        return cli;
    }

    @Override
    public ArrayList<Client> searchAll() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();

        String sql = "SELECT cpf, name, login, email, password, \n" +
                     "profession, maritalStatus, dateOfRegister \n" +
                     "FROM financialapp.clients;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        ArrayList<Client> listOfClients = new ArrayList<>();
        Client c = null;
        while (rs.next()) {
            c = new Client();
            c.setCpf(rs.getString("cpf"));
            c.setName(rs.getString("name"));
            c.setLogin(rs.getString("login"));
            c.setEmail(rs.getString("email"));
            c.setPassword(rs.getString("password"));
            c.setProfession(rs.getString("profession"));
            c.setMaritalStatus(rs.getString("maritalStatus"));
            String dt = rs.getString("dateOfRegister");
            if (dt != null && !dt.isEmpty() && !dt.isBlank()) {
                LocalDateTime dt1 = LocalDateTime.parse(dt.substring(0, 16),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                c.setDateOfRegister(dt1);
            }
            ArrayList<Income> listOfIncomes = new IncomeDAO().searchClientIncomes(c);
            c.setListOfIncomes(listOfIncomes);
            ArrayList<Expense> listOfExpenses = new ExpenseDAO().searchClientExpenses(c);
            c.setListOfExpenses(listOfExpenses);
            ArrayList<FinancialGoal> listOfFinancialGoal = new FinancialGoalDAO().searchFinancialGoalClient(c);
            c.setListOfFinancialGoal(listOfFinancialGoal);
            listOfClients.add(c);
        }

        return listOfClients;
    }

    public int count() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT count(*) quantidade_de_clientes " +
                     "FROM financialapp.clients;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        rs.next();

        return rs.getInt("quantidade_de_clientes");
    }
}
