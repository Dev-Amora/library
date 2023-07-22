package br.com.amora.biblioteca.janela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaInicio extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicio frame = new TelaInicio();
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
	public TelaInicio() {
		setTitle("TELA INICIAL");
		setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 685, 524);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 53, 411, 421);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("SISTEMA DE GERENCIAMENTO ");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
        lblNewLabel.setBounds(72, 11, 249, 33);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("DE BIBLIOTECA");
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
        lblNewLabel_1.setBounds(141, 41, 115, 24);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("All Ringts Resered");
        lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(139, 377, 143, 33);
        panel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Criado por:");
        lblNewLabel_3.setForeground(new Color(0, 0, 0));
        lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(24, 108, 101, 24);
        panel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Gabriela Queiroz Assis");
        lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNewLabel_4.setBounds(34, 130, 163, 24);
        panel.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Contato:");
        lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNewLabel_5.setBounds(24, 195, 81, 24);
        panel.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("gabriela-amora@outlook.com");
        lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNewLabel_6.setBounds(34, 216, 248, 24);
        panel.add(lblNewLabel_6);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(128, 128, 128));
        panel_1.setBounds(10, 11, 649, 30);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JButton btnNewButton = new JButton("Acervo");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	TelaAcervo acervo = new TelaAcervo();
	        	acervo.setVisible(true);
	        	acervo.setLocationRelativeTo(null);
	        	dispose();
            }
        });
        btnNewButton.setBounds(0, 0, 77, 31);
        panel_1.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Cad Cliente");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TelaClientes clientes = new TelaClientes();
	        	clientes.setVisible(true);
	        	clientes.setLocationRelativeTo(null);
	        	dispose();
        	}
        });
        btnNewButton_1.setBounds(87, 0, 101, 31);
        panel_1.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Vendas");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TelaVenda venda = new TelaVenda();
        		venda.setVisible(true);
	        	venda.setLocationRelativeTo(null);
	        	dispose();
        	}
        });
        btnNewButton_2.setBounds(198, 0, 84, 31);
        panel_1.add(btnNewButton_2);

        JButton btnNewButton_4 = new JButton("Cad Livro");
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TelaLivro livro = new TelaLivro();
        		livro.setVisible(true);
	        	livro.setLocationRelativeTo(null);
	        	dispose();
        	}
        });
        btnNewButton_4.setBounds(423, 0, 101, 31);
        panel_1.add(btnNewButton_4);
        
        JButton btnNewButton_5 = new JButton("Fornecedores");
        btnNewButton_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TelaFornecedores forne = new TelaFornecedores();
        		forne.setVisible(true);
	        	forne.setLocationRelativeTo(null);
	        	dispose();
        		
        	}
        });
        btnNewButton_5.setBounds(534, 0, 115, 31);
        panel_1.add(btnNewButton_5);
        
        JButton btnNewButton_3 = new JButton("Notas fiscais");
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TelaNotaFiscais nota = new TelaNotaFiscais();
        		nota.setVisible(true);
	        	nota.setLocationRelativeTo(null);
	        	dispose();
        	}
        });
        btnNewButton_3.setToolTipText("TELA INICIAL");
        btnNewButton_3.setBounds(292, 0, 121, 31);
        panel_1.add(btnNewButton_3);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(192, 192, 192));
        panel_2.setBounds(437, 53, 222, 421);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel_7 = new JLabel("Biblioteca Amora");
        lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 16));
        lblNewLabel_7.setBounds(41, 53, 136, 22);
        panel_2.add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("Projeto para conclusão de curso");
        lblNewLabel_8.setBounds(29, 344, 166, 29);
        panel_2.add(lblNewLabel_8);
        
        JLabel lblNewLabel_9 = new JLabel("SENAI");
        lblNewLabel_9.setBounds(95, 372, 39, 14);
        panel_2.add(lblNewLabel_9);

	}
}
