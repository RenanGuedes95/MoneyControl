package br.edu.vianna.finance.dao.imp;

import br.edu.vianna.finance.dao.GenericsDAO;
import br.edu.vianna.finance.dao.connectionDB.ConnectionFactory;
import br.edu.vianna.finance.model.users.Auditor;
import br.edu.vianna.finance.utils.CryptoUtils;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AuditorDAO implements GenericsDAO<Auditor, String> {

    private Connection c;

    @Override
    public void insert(Auditor auditor) throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();
        String sql = "INSERT INTO financialapp.auditors \n" +
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
        pst.setString(1, auditor.getCpf());
        pst.setString(2, auditor.getName());
        pst.setString(3, auditor.getLogin());
        pst.setString(4, auditor.getEmail());
        try {
            pst.setString(5, CryptoUtils.md5(auditor.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            throw new SQLException("Erro: A senha não foi gerada corretamente!");
        }
        pst.setString(6, auditor.getDepartment());
        pst.setString(7, auditor.getPosition());
        pst.setString(8, auditor.getDateOfRegister().toString());

        pst.execute();
    }

    @Override
    public void alter(Auditor auditor) throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();
        String sql = "UPDATE financialapp.auditors \n" +
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
        pst.setString(1, auditor.getCpf());
        pst.setString(2, auditor.getName());
        pst.setString(3, auditor.getLogin());
        pst.setString(4, auditor.getEmail());
        try {
            pst.setString(5, CryptoUtils.md5(auditor.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            throw new SQLException("Erro: A senha não foi gerada corretamente!");
        }
        pst.setString(6, auditor.getDepartment());
        pst.setString(7, auditor.getPosition());
        pst.setString(8, auditor.getCpf());

        pst.execute();
    }

    @Override
    public void delete(Auditor auditor) throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();

        String sql = "DELETE FROM financialapp.auditors \n" +
                "WHERE cpf = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, auditor.getCpf());
        pst.execute();
    }

    @Override
    public Auditor searchOne(String cpf) throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();

        String sql = "SELECT cpf, name, login, email, password, \n" +
                "department, position, dateOfRegister \n" +
                "FROM financialapp.auditors \n" +
                "WHERE cpf = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, cpf);

        ResultSet rs = pst.executeQuery();

        Auditor a = null;
        if (rs.next()) {
            a = new Auditor();
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

    public Auditor searchAuditorByLoginAndPassword(String login, String password) throws SQLException, ClassNotFoundException {

        c = ConnectionFactory.getConnection();
        String sql = "SELECT cpf, name, login, email, password, \n" +
                     "department, position, dateOfRegister \n" +
                     "FROM financialapp.auditors \n" +
                     "WHERE login = ? AND password = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, login);
        try {
            pst.setString(2, CryptoUtils.md5(password));
        } catch (NoSuchAlgorithmException e) {
            throw new SQLException("Erro ao criptografar a senha!");
        }

        ResultSet rs = pst.executeQuery();

        Auditor a = null;
        if (rs.next()) {
            a = new Auditor();
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
    public ArrayList<Auditor> searchAll() throws ClassNotFoundException, SQLException {
        c = ConnectionFactory.getConnection();

        String sql = "SELECT cpf, name, login, email, password, \n" +
                     "department, position, dateOfRegister \n" +
                     "FROM financialapp.auditors;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        ArrayList<Auditor> listOfAuditors = new ArrayList<>();
        Auditor a = null;
        while (rs.next()) {
            a = new Auditor();
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
            listOfAuditors.add(a);
        }

        return listOfAuditors;
    }

    public int count() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT count(*) quantidade_de_auditores \n" +
                     "FROM financialapp.auditors;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        rs.next();

        return rs.getInt("quantidade_de_auditores");
    }
}
