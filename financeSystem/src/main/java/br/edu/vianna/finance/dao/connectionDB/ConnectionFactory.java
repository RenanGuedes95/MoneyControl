package br.edu.vianna.finance.dao.connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static final String url = "jdbc:mysql://localhost:3306/financialapp";
    public static final String user = "admin";
    public static final String PASSWORD = "admin";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url,
                user,
                PASSWORD);
    }

    public static void main(String[] args) {
        try {
            Connection c = getConnection();
            System.out.println("Conexão realizada com sucesso!");
            System.out.println("Você está conectado ao banco de dados: " + c.getCatalog());
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }
}
