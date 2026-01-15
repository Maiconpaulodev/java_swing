package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

import model.Cliente;
import model.ModeloTabela;
import dao.ClienteDAO;

public class Jprincipal extends JFrame {

    private ModeloTabela modeloTabela;
    private JTable table;
    private ClienteDAO dao;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Jprincipal frame = new Jprincipal();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Jprincipal() {
        setTitle("Cadastro de Clientes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 500);

        dao = new ClienteDAO();
        List<Cliente> clientes = dao.listarClientes();

        modeloTabela = new ModeloTabela(clientes);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(50, 10, 100, 25);
        contentPane.add(btnCadastrar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 50, 660, 400);
        contentPane.add(scrollPane);

        table = new JTable(modeloTabela);
        scrollPane.setViewportView(table);

        
        btnCadastrar.addActionListener((ActionEvent e) -> {
            String id = JOptionPane.showInputDialog("Digite o ID do cliente:");
            String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
            String cpf = JOptionPane.showInputDialog("Digite o CPF/CNPJ:");
            String email = JOptionPane.showInputDialog("Digite o e-mail:");
            String telefone = JOptionPane.showInputDialog("Digite o telefone:");
            String endereco = JOptionPane.showInputDialog("Digite o endereço:");

            if (id != null && nome != null) {
                Cliente novo = new Cliente(id, nome, cpf, email, telefone, endereco);
                dao.adicionarCliente(novo);

               
                modeloTabela.setClientes(dao.listarClientes());
                modeloTabela.fireTableDataChanged();
            }
        });
    }
}
