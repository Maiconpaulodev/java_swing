package controller;

import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        try (Connection c = ConexaoMySQL.getConnection()) {
            System.out.println("CONECTADO NO MYSQL!");
        } catch (Exception e) { 
            e.printStackTrace();
        }
    }
}
