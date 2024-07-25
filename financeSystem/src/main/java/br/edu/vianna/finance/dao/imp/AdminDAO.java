package br.edu.vianna.finance.dao.imp;

import br.edu.vianna.finance.dao.GenericsDAO;
import br.edu.vianna.finance.dao.connectionDB.ConnectionFactory;
import br.edu.vianna.finance.model.finances.Expense;
import br.edu.vianna.finance.model.finances.FinancialGoal;
import br.edu.vianna.finance.model.finances.Income;
import br.edu.vianna.finance.model.users.Admin;
import br.edu.vianna.finance.model.users.Client;
import br.edu.vianna.finance.utils.CryptoUtils;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AdminDAO implements GenericsDAO<Admin, String> {
    private Connection c;

    @Override
    public void insert(Admin admin) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "INSERT INTO financialapp.admins \n" +
                     "(cpf, \n" +
                     "name, \n" +
                     "login, \n" +
                     "email, \n" +
                     "password, \n" +
                     "department, \n" +
                     "position, \n" +
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
        pst.setString(1, admin.getCpf());
        pst.setString(2, admin.getName());
        pst.setString(3, admin.getLogin());
        pst.setString(4, admin.getEmail());
        try {
            pst.setString(5, CryptoUtils.md5(admin.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            throw new SQLException("Erro: A senha não foi gerada corretamente!");
        }
        pst.setString(6, admin.getDepartment());
        pst.setString(7, admin.getPosition());
        pst.setString(8, admin.getDateOfRegister().toString());

        pst.execute();
    }

    @Override
    public void alter(Admin admin) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "UPDATE financialapp.admins\n" +
                     "SET\n" +
                     "cpf = ?,\n" +
                     "name = ?,\n" +
                     "login = ?,\n" +
                     "email = ?,\n" +
                     "password = ?,\n" +
                     "department = ?,\n" +
                     "position = ?\n" +
                     "WHERE `cpf` = ?;";

        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, admin.getCpf());
        pst.setString(2, admin.getName());
        pst.setString(3, admin.getLogin());
        pst.setString(4, admin.getEmail());
        try {
            pst.setString(5, CryptoUtils.md5(admin.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            throw new SQLException("Erro: A senha não foi gerada corretamente!");
        }
        pst.setString(6, admin.getDepartment());
        pst.setString(7, admin.getPosition());
        pst.setString(8, admin.getCpf());

        pst.execute();
    }
    //
    @Override
    public void delete(Admin admin) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();

        String sql = "DELETE FROM financialapp.admins \n" +
                     "WHERE cpf = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, admin.getCpf());
        pst.execute();
    }

    @Override
    public Admin searchOne(String cpf) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();

        String sql = "SELECT cpf, name, login, email, password, " +
                     "department, position, dateOfRegister \n" +
                     "FROM financialapp.admins \n" +
                     "WHERE cpf = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, cpf);

        ResultSet rs = pst.executeQuery();

        Admin a = null;
        if (rs.next()) {
            a = new Admin();
            a.setCpf(rs.getString("cpf"));
            a.setName(rs.getString("name"));
            a.setLogin(rs.getString("login"));
            a.setEmail(rs.getString("email"));
            a.setPassword(rs.getString("password"));
            a.setDepartment(rs.getString("department"));
            a.setPosition(rs.getString("position"));
            String dt = rs.getString("dateOfRegister");
            if (dt != null && !dt.isEmpty() && !dt.isBlank()) {
                LocalDateTime dt1 = LocalDateTime.parse(dt.substring(0, 16),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                a.setDateOfRegister(dt1);
            }
        }

        return a;
    }

    public Admin searchAdminByLoginAndPassword(String login, String password) throws SQLException, ClassNotFoundException {

        c = ConnectionFactory.getConnection();
        String sql = "SELECT cpf, name, login, email, password, " +
                     "department, position, dateOfRegister \n" +
                     "FROM financialapp.admins \n" +
                     "WHERE login = ? AND password = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, login);
        try {
            pst.setString(2, CryptoUtils.md5(password));
        } catch (NoSuchAlgorithmException e) {
            throw new SQLException("Erro ao criptografar a senha!");
        }

        ResultSet rs = pst.executeQuery();

        Admin a = null;
        if (rs.next()) {
            a = new Admin();
            a.setCpf(rs.getString("cpf"));
            a.setName(rs.getString("name"));
            a.setLogin(rs.getString("login"));
            a.setEmail(rs.getString("email"));
            a.setPassword(rs.getString("password"));
            a.setDepartment(rs.getString("department"));
            a.setPosition(rs.getString("position"));
            String dt = rs.getString("dateOfRegister");
            if (dt != null && !dt.isEmpty() && !dt.isBlank()) {
                LocalDateTime dt1 = LocalDateTime.parse(dt.substring(0, 16),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                a.setDateOfRegister(dt1);
            }
        }

        return a;
    }

    @Override
    public ArrayList<Admin> searchAll() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();

        String sql = "SELECT cpf, name, login, email, password, " +
                "department, position, dateOfRegister \n" +
                "FROM financialapp.admins;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        ArrayList<Admin> listOfAdmins = new ArrayList<>();
        Admin a = null;
        while (rs.next()) {
            a = new Admin();
            a.setCpf(rs.getString("cpf"));
            a.setName(rs.getString("name"));
            a.setLogin(rs.getString("login"));
            a.setEmail(rs.getString("email"));
            a.setPassword(rs.getString("password"));
            a.setDepartment(rs.getString("department"));
            a.setPosition(rs.getString("position"));
            String dt = rs.getString("dateOfRegister");
            if (dt != null && !dt.isEmpty() && !dt.isBlank()) {
                LocalDateTime dt1 = LocalDateTime.parse(dt.substring(0, 16),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                a.setDateOfRegister(dt1);
            }
            listOfAdmins.add(a);
        }

        return listOfAdmins;
    }

    public int count() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT count(*) quantidade_de_administradores " +
                " FROM financialapp.admins;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        rs.next();

        return rs.getInt("quantidade_de_administradores");
    }
}
