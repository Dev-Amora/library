package br.com.amora.biblioteca.janela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.amora.biblioteca.controle.Venda;
import br.com.amora.biblioteca.dao.VendaDAO;

public class TelaVenda extends JFrame {


    private JPanel contentPane;
    private JLabel vendedorLabel, idClienteLabel, idLivroLabel;
    private JTextField vendedorField, idClienteField, idLivroField;
    private JButton buttonRegistrar;

    public TelaVenda() {
    	setTitle("VENDAS");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 685, 389);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 53, 649, 286);
        contentPane.add(panel);
        panel.setLayout(null);

        vendedorLabel= new JLabel("Nome do vendedor:");
        vendedorLabel.setBounds(10, 16, 163, 40);
        vendedorLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(vendedorLabel);
        vendedorField = new JTextField(20);
        vendedorField.setBounds(183, 23,  456, 30);
        panel.add(vendedorField);

        idClienteLabel = new JLabel("Id Cliente:");
        idClienteLabel.setBounds(10, 55, 163, 40);
        idClienteLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(idClienteLabel);
        idClienteField = new JTextField(20);
        idClienteField.setBounds(183, 62, 456, 30);
        panel.add(idClienteField);

        idLivroLabel = new JLabel("Id Livro:");
        idLivroLabel.setBounds(10, 99, 163, 40);
        idLivroLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add( idLivroLabel);
        idLivroField = new JTextField(20);
        idLivroField.setBounds(183, 106, 456, 30);
        panel.add(idLivroField);

        buttonRegistrar = new JButton("REGISTRAR");
        buttonRegistrar.setFont(new Font("Arial", Font.BOLD, 16));
        buttonRegistrar.setBounds(411, 190, 163, 57);
        panel.add(buttonRegistrar);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(192, 192, 192));
        panel_2.setBounds(10, 179, 269, 95);
        panel.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Outras Funções:");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNewLabel.setBounds(70, 11, 122, 14);
        panel_2.add(lblNewLabel);
        
        JButton btnNewButton_3 = new JButton("DELETAR");
        btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 12));
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 TelaDeletarVenda deletar = new TelaDeletarVenda();
                 deletar.setVisible(true);
                 deletar.setLocationRelativeTo(null);
                 dispose();
        	}
        });
        btnNewButton_3.setBounds(10, 48, 100, 36);
        panel_2.add(btnNewButton_3);
        
        JButton btnNewButton_6 = new JButton("ATUALIZAR");
        btnNewButton_6.setFont(new Font("Arial", Font.BOLD, 12));
        btnNewButton_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TelaAtualizarVenda atual = new TelaAtualizarVenda();
                atual.setVisible(true);
                atual.setLocationRelativeTo(null);
                dispose();
        	}
        });
        btnNewButton_6.setBounds(159, 48, 100, 36);
        panel_2.add(btnNewButton_6);

        buttonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	salvarLivro();
            }
        });

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
        
        JButton btnNewButton_9 = new JButton("Notas fiscais");
        btnNewButton_9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TelaNotaFiscais nota = new TelaNotaFiscais();
        		nota.setVisible(true);
	        	nota.setLocationRelativeTo(null);
	        	dispose();
        	}
        });
        btnNewButton_9.setToolTipText("TELA INICIAL");
        btnNewButton_9.setBounds(292, 0, 121, 31);
        panel_1.add(btnNewButton_9);

	}
    private void salvarLivro() {
        // Get the input values from the fields and create a new Client object
        String nomeVendedor = vendedorField.getText();
        
        if (nomeVendedor.isEmpty()){
            JOptionPane.showMessageDialog(null, "Todos os campos obrigatórios devem ser preenchidos!", "Campos vazios",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int id_Livro, id_Cliente;
        try {
            id_Livro = (int) Long.parseLong(idLivroField.getText());
            id_Cliente = (int) Long.parseLong(idClienteField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido ou Vazios!", "ERRO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Create a new Client object and set its attributes
        Venda newVenda = new Venda();
        newVenda.setNomeVendedor(nomeVendedor);
        newVenda.setId_Cliente(id_Cliente);
        newVenda.setId_Livro(id_Livro);

        // Save the new client using the DAO
        VendaDAO dao = new VendaDAO();
        dao.inserirVenda(newVenda);

        // Clear the fields after adding the client
        clearFields();
    }

    private void clearFields() {
        vendedorField.setText("");
        idClienteField.setText("");
        idLivroField.setText("");
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaClientes frame = new TelaClientes();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
