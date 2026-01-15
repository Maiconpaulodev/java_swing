package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import controller.ConexaoMySQL;

public class ClienteDAO {

    public void adicionarCliente(Cliente c) {
        String sql = "INSERT INTO cliente (id, nome, cpf_cnpj, email, telefone, endereco) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoMySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getId());
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getCpfCnpj());
            stmt.setString(4, c.getEmail());
            stmt.setString(5, c.getTelefone());
            stmt.setString(6, c.getEndereco());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listarClientes() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try (Connection conn = ConexaoMySQL.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cliente c = new Cliente(
                    rs.getString("id"),
                    rs.getString("nome"),
                    rs.getString("cpf_cnpj"),
                    rs.getString("email"),
                    rs.getString("telefone"),
                    rs.getString("endereco")
                );
                lista.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void atualizarCliente(Cliente c) {
        String sql = "UPDATE cliente SET nome=?, cpf_cnpj=?, email=?, telefone=?, endereco=? WHERE id=?";

        try (Connection conn = ConexaoMySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpfCnpj());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getTelefone());
            stmt.setString(5, c.getEndereco());
            stmt.setString(6, c.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirCliente(String id) {
        String sql = "DELETE FROM cliente WHERE id=?";

        try (Connection conn = ConexaoMySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
