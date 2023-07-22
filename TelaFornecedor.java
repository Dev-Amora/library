package br.com.amora.biblioteca.janela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.amora.biblioteca.dao.FornecedorDAO;
import br.com.amora.biblioteca.pessoa.Fornecedor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaFornecedores extends JFrame {

    private JPanel contentPane;
    private JLabel nameLabel, typeLabel, cpfCnpjLabel, contactLabel, addressLabel, productLabel, deliveryLabel;
    private JTextField nameField, cpfCnpjField, contactField, addressField, productField, deliveryField;
    private JComboBox<String> typeComboBox;
    private JButton addButton;
    private FornecedorDAO fornecedorDAO;

    public TelaFornecedores() {
        setTitle("CADASTRO DE FORNECEDORES");
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
        panel.setBounds(10, 53, 649, 424);
        contentPane.add(panel);
        panel.setLayout(null);

        nameLabel = new JLabel("Nome:");
        nameLabel.setBounds(10, 9, 163, 40);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(nameLabel);
        nameField = new JTextField(20);
        nameField.setBounds(183, 16, 456, 30);
        panel.add(nameField);

        typeLabel = new JLabel("Tipo:");
        typeLabel.setBounds(10, 43, 163, 40);
        typeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(typeLabel);
        String[] types = { "FISIC0", "JURIDIC0" };
        typeComboBox = new JComboBox<>(types);
        typeComboBox.setBounds(183, 54, 456, 30);
        panel.add(typeComboBox);

        cpfCnpjLabel = new JLabel("CPF/CNPJ:");
        cpfCnpjLabel.setBounds(10, 84, 163, 40);
        cpfCnpjLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(cpfCnpjLabel);
        cpfCnpjField = new JTextField(20);
        cpfCnpjField.setBounds(183, 91, 456, 30);
        panel.add(cpfCnpjField);

        contactLabel = new JLabel("Contato:");
        contactLabel.setBounds(10, 125, 163, 40);
        contactLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(contactLabel);
        contactField = new JTextField(20);
        contactField.setBounds(183, 132, 456, 30);
        panel.add(contactField);

        addressLabel = new JLabel("Endereço:");
        addressLabel.setBounds(10, 166, 163, 40);
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(addressLabel);
        addressField = new JTextField(20);
        addressField.setBounds(183, 173, 456, 30);
        panel.add(addressField);

        productLabel = new JLabel("Produtos/Serviços:");
        productLabel.setBounds(10, 207, 163, 40);
        productLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(productLabel);
        productField = new JTextField(20);
        productField.setBounds(183, 214, 456, 30);
        panel.add(productField);

        deliveryLabel = new JLabel("Prazo de Entrega:");
        deliveryLabel.setBounds(10, 248, 163, 40);
        deliveryLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(deliveryLabel);
        deliveryField = new JTextField(20);
        deliveryField.setBounds(183, 255, 456, 30);
        panel.add(deliveryField);

        addButton = new JButton("CADASTRAR");
        addButton.setFont(new Font("Arial", Font.BOLD, 16));
        addButton.setBounds(412, 330, 157, 46);
        panel.add(addButton);
        
        JPanel panel_2 = new JPanel();
        panel_2.setLayout(null);
        panel_2.setBackground(Color.LIGHT_GRAY);
        panel_2.setBounds(10, 318, 269, 95);
        panel.add(panel_2);
        
        JLabel lblNewLabel = new JLabel("Outras Funções:");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNewLabel.setBounds(70, 11, 122, 14);
        panel_2.add(lblNewLabel);
        
        JButton btnNewButton_3 = new JButton("DELETAR");
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TelaDeletarFornecedor deletar = new TelaDeletarFornecedor();
                deletar.setVisible(true);
                deletar.setLocationRelativeTo(null);
                dispose();
        	}
        });
        btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 12));
        btnNewButton_3.setBounds(10, 48, 100, 36);
        panel_2.add(btnNewButton_3);
        
        JButton btnNewButton_6 = new JButton("ATUALIZAR");
        btnNewButton_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TelaAtualizarFornecedor atual = new TelaAtualizarFornecedor();
                atual.setVisible(true);
                atual.setLocationRelativeTo(null);
                dispose();
        	}
        });
        btnNewButton_6.setFont(new Font("Arial", Font.BOLD, 12));
        btnNewButton_6.setBounds(159, 48, 100, 36);
        panel_2.add(btnNewButton_6);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFornecedor();
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

        JButton btnNewButton_7 = new JButton("Notas fiscais");
        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaNotaFiscais nota = new TelaNotaFiscais();
                nota.setVisible(true);
                nota.setLocationRelativeTo(null);
                dispose();
            }
        });
        btnNewButton_7.setToolTipText("TELA INICIAL");
        btnNewButton_7.setBounds(292, 0, 121, 31);
        panel_1.add(btnNewButton_7);
    }

    private void saveFornecedor() {
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

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(nome);
        fornecedor.setTipo(tipo);
        fornecedor.setCnpj_cpf(cpfCnpj);
        fornecedor.setContato(contato);
        fornecedor.setEndereço(endereco);
        fornecedor.setProdutosOuServiço(produtosOuServico);
        fornecedor.setPrazoDeEntrega(prazoDeEntrega);

        fornecedorDAO.salvarFornecedor(fornecedor);

        clearFields();
    }

    private void clearFields() {
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
