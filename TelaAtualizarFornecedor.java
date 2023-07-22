package br.com.amora.biblioteca.janela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.amora.biblioteca.dao.FornecedorDAO;
import br.com.amora.biblioteca.pessoa.Fornecedor;

public class TelaAtualizarFornecedor extends JFrame {

	private JPanel contentPane;
    private JLabel nameLabel, typeLabel, cpfCnpjLabel, contactLabel, addressLabel, productLabel, deliveryLabel, idLabel;
    private JTextField nameField, cpfCnpjField, contactField, addressField, productField, deliveryField, idField;
    private JComboBox<String> typeComboBox;
    private JButton addButton;
    private FornecedorDAO fornecedorDAO;

	public TelaAtualizarFornecedor() {
        setTitle("ATUALIZAR");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 685, 527);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        fornecedorDAO = new FornecedorDAO();

        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 649, 466);
        contentPane.add(panel);
        panel.setLayout(null);
        
        idLabel = new JLabel("Id Fornecedor:");
        idLabel.setBounds(10, 48, 163, 40);
        idLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(idLabel);
        idField = new JTextField(20);
        idField.setBounds(183, 55, 456, 30);
        panel.add(idField);

        nameLabel = new JLabel("Nome:");
        nameLabel.setBounds(10, 89, 163, 40);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(nameLabel);
        nameField = new JTextField(20);
        nameField.setBounds(183, 96, 456, 30);
        panel.add(nameField);

        typeLabel = new JLabel("Tipo:");
        typeLabel.setBounds(10, 130, 163, 40);
        typeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(typeLabel);
        String[] types = { "FISIC0", "JURIDIC0" };
        typeComboBox = new JComboBox<>(types);
        typeComboBox.setBounds(183, 136, 456, 30);
        panel.add(typeComboBox);

        cpfCnpjLabel = new JLabel("CPF/CNPJ:");
        cpfCnpjLabel.setBounds(10, 164, 163, 40);
        cpfCnpjLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(cpfCnpjLabel);
        cpfCnpjField = new JTextField(20);
        cpfCnpjField.setBounds(183, 171, 456, 30);
        panel.add(cpfCnpjField);

        contactLabel = new JLabel("Contato:");
        contactLabel.setBounds(10, 205, 163, 40);
        contactLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(contactLabel);
        contactField = new JTextField(20);
        contactField.setBounds(183, 212, 456, 30);
        panel.add(contactField);

        addressLabel = new JLabel("Endereço:");
        addressLabel.setBounds(10, 245, 163, 40);
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(addressLabel);
        addressField = new JTextField(20);
        addressField.setBounds(183, 252, 456, 30);
        panel.add(addressField);

        productLabel = new JLabel("Produtos/Serviços:");
        productLabel.setBounds(10, 286, 163, 40);
        productLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(productLabel);
        productField = new JTextField(20);
        productField.setBounds(183, 293, 456, 30);
        panel.add(productField);

        deliveryLabel = new JLabel("Prazo de Entrega:");
        deliveryLabel.setBounds(10, 327, 163, 40);
        deliveryLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(deliveryLabel);
        deliveryField = new JTextField(20);
        deliveryField.setBounds(183, 334, 456, 30);
        panel.add(deliveryField);

        addButton = new JButton("ATUALIZAR");
        addButton.setFont(new Font("Arial", Font.BOLD, 16));
        addButton.setBounds(395, 395, 157, 46);
        panel.add(addButton);
        
        JLabel lblNewLabel_1 = new JLabel("Atualizar venda registrada:");
        lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(196, 11, 261, 24);
        panel.add(lblNewLabel_1);
        
        JButton btnNewButton = new JButton("CANCELAR");
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
        btnNewButton.setBounds(101, 395, 157, 46);
        panel.add(btnNewButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	atualizarFornecedor();
            }
        });
    }

    private void atualizarFornecedor() {
        String nome = nameField.getText();
        String tipo = (String) typeComboBox.getSelectedItem();
        String cpfCnpj = cpfCnpjField.getText();
        String contato = contactField.getText();
        String endereco = addressField.getText();
        String produtosOuServico = productField.getText();
        String prazoDeEntrega = deliveryField.getText();

        if (nome.isEmpty() || cpfCnpj.isEmpty() || contato.isEmpty() || endereco.isEmpty() || produtosOuServico.isEmpty() || prazoDeEntrega.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos obrigatórios devem ser preenchidos!", "Campos vazios",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        int id;
    	
	    try {
	    	id = (int) Long.parseLong(idField.getText());
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(null, "Valor inserido do livro inválido!", "ERRO", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(nome);
        fornecedor.setTipo(tipo);
        fornecedor.setCnpj_cpf(cpfCnpj);
        fornecedor.setContato(contato);
        fornecedor.setEndereço(endereco);
        fornecedor.setProdutosOuServiço(produtosOuServico);
        fornecedor.setPrazoDeEntrega(prazoDeEntrega);
        fornecedor.setId_Fornecedor(id);

        fornecedorDAO.salvarFornecedor(fornecedor);

        clearFields();
    }

    private void clearFields() {
    	idField.setText("");
        nameField.setText("");
        cpfCnpjField.setText("");
        contactField.setText("");
        addressField.setText("");
        productField.setText("");
        deliveryField.setText("");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaFornecedores frame = new TelaFornecedores();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
