package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_clientes?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "<Eeg$3(i(kX@m#)";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao MySQL", e);
        }
    }
}
