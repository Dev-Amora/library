package br.com.amora.biblioteca.janela;

import java.awt.Color;
import java.awt.EventQueue;
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

import  br.com.amora.biblioteca.pessoa.Cliente;
import br.com.amora.biblioteca.dao.ClienteDAO;
import java.awt.Font;

public class TelaClientes extends JFrame {

    private JPanel contentPane;
    private JLabel nameLabel, emailLabel, phoneLabel, genderLabel, typeLabel, cpfCnpjLabel, cepLabel, addressLabel,
            numberLabel, cityLabel, stateLabel;
    private JTextField nameField, emailField, phoneField, cpfCnpjField, cepField, addressField, numberField, cityField;
    private JComboBox<String> genderComboBox, typeComboBox, stateComboBox;
    private JButton addButton;

    public TelaClientes() {
    	setTitle("CADASTRO DE CLIENTES");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 685, 700);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 53, 649, 600);
        contentPane.add(panel);
        panel.setLayout(null);

        nameLabel = new JLabel("Nome:");
        nameLabel.setBounds(10, 16, 163, 40);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(nameLabel);
        nameField = new JTextField(20);
        nameField.setBounds(183, 23,  456, 30);
        panel.add(nameField);

        emailLabel = new JLabel("E-mail:");
        emailLabel.setBounds(10, 55, 163, 40);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(emailLabel);
        emailField = new JTextField(20);
        emailField.setBounds(183, 62, 456, 30);
        panel.add(emailField);

        phoneLabel = new JLabel("Telefone:");
        phoneLabel.setBounds(10, 99, 163, 40);
        phoneLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(phoneLabel);
        phoneField = new JTextField(20);
        phoneField.setBounds(183, 106, 456, 30);
        panel.add(phoneField);

        genderLabel = new JLabel("Gênero:");
        genderLabel.setBounds(10, 140, 163, 40);
        genderLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(genderLabel);
        String[] genders = { "MASCULINO", "FEMININO", "OUTRO" };
        genderComboBox = new JComboBox<>(genders);
		genderComboBox.setBounds(183,148, 456, 30);
        panel.add(genderComboBox);

        typeLabel = new JLabel("Tipo de pessoa:");
        typeLabel.setBounds(10, 181, 163, 40);
        typeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(typeLabel);
        String[] types = { "PESSAO FISICA", "PESSOA JURIDICA" };
        typeComboBox = new JComboBox<>(types);
        typeComboBox.setBounds(183,187, 456, 30);
        panel.add(typeComboBox);

        cpfCnpjLabel = new JLabel("CPF/CNPJ:");
        cpfCnpjLabel.setBounds(10, 222, 163, 40);
        cpfCnpjLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(cpfCnpjLabel);
        cpfCnpjField = new JTextField(20);
        cpfCnpjField.setBounds(183, 229, 456, 30);
        panel.add(cpfCnpjField);

        cepLabel = new JLabel("CEP:");
        cepLabel.setBounds(10, 265, 163, 40);
        cepLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(cepLabel);
        cepField = new JTextField(20);
        cepField.setBounds(183, 272, 456, 30);
        panel.add(cepField);

        addressLabel = new JLabel("Endereço:");
        addressLabel.setBounds(10, 309,  163, 40);
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(addressLabel);
        addressField = new JTextField(20);
        addressField.setBounds(183, 316, 456, 30);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(addressField);

        numberLabel = new JLabel("Número:");
        numberLabel.setBounds(10, 350, 163, 40);
        numberLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(numberLabel);
        numberField = new JTextField(20);
        numberField.setBounds(183, 357, 456, 30);
        panel.add(numberField);

        cityLabel = new JLabel("Cidade:");
        cityLabel.setBounds(10, 393, 163, 40);
        cityLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(cityLabel);
        cityField = new JTextField(20);
        cityField.setBounds(183, 400, 456, 30);
        panel.add(cityField);

      stateLabel = new JLabel("Estado:");
      stateLabel.setBounds(10, 434, 163, 40);
      stateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
      panel.add(stateLabel);
      String[] states = { "ACRE", "ALAGOAS", "AMAPÁ", "AMAZONAS", "BAHIA", "CEARÁ", "DISTRITO_FEDERAL", "ESPÍRITO_SANTO",
               "GOIÁS", "MARANHÃO", "MATO_GROSSO", "MATO_GROSSO_DO_SUL", "MINAS_GERAIS", "PARÁ", "PARAÍBA", "PARANÁ",
               "PERNAMBUCO", "PIAUÍ", "RIO_DE_JANEIRO", "RIO_GRANDE_DO_NORTE", "RIO_GRANDE_DO_SUL", "RONDÔNIA", "RORAIMA",
               "SANTA_CATARINA", "SÃO_PAULO", "SERGIPE", "TOCANTINS" };
      stateComboBox = new JComboBox<>(states);
      stateComboBox.setBounds(183, 438, 456, 30);
      panel.add(stateComboBox);

        addButton = new JButton("CADASTRAR");
        addButton.setFont(new Font("Arial", Font.BOLD, 16));
        addButton.setBounds(422, 510, 157, 56);
        panel.add(addButton);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(192, 192, 192));
        panel_2.setBounds(10, 494, 269, 95);
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
        		 TelaDeletarCliente deletar = new TelaDeletarCliente();
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
        		TelaAtualizarCliente atual = new TelaAtualizarCliente();
                atual.setVisible(true);
                atual.setLocationRelativeTo(null);
                dispose();
        	}
        });
        btnNewButton_6.setBounds(159, 48, 100, 36);
        panel_2.add(btnNewButton_6);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveClient();
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
    private void saveClient() {
        // Get the input values from the fields and create a new Client object
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String gender = (String) genderComboBox.getSelectedItem();
        String type = (String) typeComboBox.getSelectedItem();
        String cpfCnpj = cpfCnpjField.getText();
        String cep = cepField.getText();
        String address = addressField.getText();
        String number = numberField.getText();
        String city = cityField.getText();
        String state = (String) stateComboBox.getSelectedItem();
        
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || cpfCnpj.isEmpty() || cep.isEmpty() || address.isEmpty()
                || number.isEmpty() || city.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos obrigatórios devem ser preenchidos!", "Campos vazios",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Create a new Client object and set its attributes
        Cliente newClient = new Cliente();
        newClient.setNome(name);
        newClient.setEmail(email);
        newClient.setTelefone(phone);
        newClient.setGenero(gender);
        newClient.setTipoPessoa(type);
        newClient.setCnpj_cpf(cpfCnpj);
        newClient.setCEP(cep);
        newClient.setEndereco(address);
        newClient.setNumero(number);
        newClient.setCidade(city);
        newClient.setEstado(state);

        // Save the new client using the DAO
        ClienteDAO dao = new ClienteDAO();
        dao.saveCliente(newClient);

        // Clear the fields after adding the client
        clearFields();
    }

    private void clearFields() {
        nameField.setText("");
        emailField.setText("");
        phoneField.setText("");
        cpfCnpjField.setText("");
        cepField.setText("");
        addressField.setText("");
        numberField.setText("");
        cityField.setText("");
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
