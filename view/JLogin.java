package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JLogin extends JFrame {

    private JTextField textFieldUsuario;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                JLogin frame = new JLogin();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public JLogin() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblTitulo = new JLabel("Bem-vindo");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setBounds(150, 20, 120, 25);
        contentPane.add(lblTitulo);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(50, 70, 80, 20);
        contentPane.add(lblUsuario);

        textFieldUsuario = new JTextField();
        textFieldUsuario.setBounds(130, 70, 180, 20);
        contentPane.add(textFieldUsuario);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(50, 110, 80, 20);
        contentPane.add(lblSenha);

        passwordField = new JPasswordField();
        passwordField.setBounds(130, 110, 180, 20);
        contentPane.add(passwordField);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(150, 160, 100, 25);
        contentPane.add(btnEntrar);

        
        btnEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = textFieldUsuario.getText();
                String senha = new String(passwordField.getPassword());

                if (!usuario.isEmpty() && !senha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Login válido!");
                   
                    Jprincipal principal = new Jprincipal();
                    principal.setVisible(true);
                    dispose(); 
                } else {
                    JOptionPane.showMessageDialog(null, "Preencha usuário e senha!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
