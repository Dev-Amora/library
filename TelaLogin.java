package br.com.amora.biblioteca.janela;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import br.com.amora.biblioteca.dao.DatabaseConnection;

public class TelaLogin extends JFrame {
	
	public TelaLogin() {
	    initComponents();
	}

	private boolean verificarCredenciais(String usuario, String senha) {
	    String sql = "SELECT * FROM biblioteca.acesso WHERE usuario = ? AND senha = ?";
	    
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        
	        stmt.setString(1, usuario);
	        stmt.setString(2, senha);
	        ResultSet rs = stmt.executeQuery();
	        
	        return rs.next(); // Retorna true se houver um registro correspondente, ou false caso contrário
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}


	
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private void initComponents() {
		setResizable(false);
		setBackground(new Color(0, 0, 0));
		setForeground(new Color(0, 0, 0));
		setFont(new Font("Arial", Font.BOLD, 14));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 400, 250);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER:");
		lblNewLabel.setBounds(10, 11, 73, 23);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 34, 326, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("SENHA:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 66, 73, 23);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(105, 140, 122, 30);
		panel.add(btnNewButton);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 88, 326, 23);
		panel.add(passwordField);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String usuario = textField.getText();
		        String senha = new String(passwordField.getPassword());
		        
		        if (verificarCredenciais(usuario, senha)) {
		        	TelaInicio inicio = new TelaInicio();
		        	inicio.setVisible(true);
		        	inicio.setLocationRelativeTo(null);
		        	dispose();
		        } else {
		            JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
	}
}
