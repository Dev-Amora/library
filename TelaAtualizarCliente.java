package br.com.amora.biblioteca.janela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.amora.biblioteca.dao.ClienteDAO;
import br.com.amora.biblioteca.pessoa.Cliente;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAtualizarCliente extends JFrame {

	private JPanel contentPane;
    private JLabel nameLabel, emailLabel, phoneLabel, genderLabel, typeLabel, cpfCnpjLabel, cepLabel, addressLabel,
            numberLabel, cityLabel, stateLabel, idLabel;
    private JTextField nameField, emailField, phoneField, cpfCnpjField, cepField, addressField, numberField, cityField, idField;
    private JComboBox<String> genderComboBox, typeComboBox, stateComboBox;
    private JButton atualizaButton, voltarButton;
    private JPanel panel_1;

    public TelaAtualizarCliente() {
    	
    	setTitle("ATUALIZAR");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 685, 700);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 45, 649, 605);
        contentPane.add(panel);
        panel.setLayout(null);
        
        idLabel = new JLabel("ID do Cliente:");
        idLabel.setBounds(10, 16, 163, 40);
        idLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(idLabel);
        idField = new JTextField(10);
        idField.setBounds(183, 23,  456, 30);
        panel.add(idField);

        nameLabel = new JLabel("Nome:");
        nameLabel.setBounds(10, 55, 163, 40);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(nameLabel);
        nameField = new JTextField(20);
        nameField.setBounds(183, 62,  456, 30);
        panel.add(nameField);

        emailLabel = new JLabel("E-mail:");
        emailLabel.setBounds(10, 96, 163, 40);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(emailLabel);
        emailField = new JTextField(20);
        emailField.setBounds(183, 103, 456, 30);
        panel.add(emailField);

        phoneLabel = new JLabel("Telefone:");
        phoneLabel.setBounds(10, 137, 163, 40);
        phoneLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(phoneLabel);
        phoneField = new JTextField(20);
        phoneField.setBounds(183, 144, 456, 30);
        panel.add(phoneField);

        genderLabel = new JLabel("Gênero:");
        genderLabel.setBounds(10, 178, 163, 40);
        genderLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(genderLabel);
        String[] genders = { "MASCULINO", "FEMININO", "OUTRO" };
        genderComboBox = new JComboBox<>(genders);
		genderComboBox.setBounds(183,182, 456, 30);
        panel.add(genderComboBox);

        typeLabel = new JLabel("Tipo de pessoa:");
        typeLabel.setBounds(10, 214, 163, 40);
        typeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(typeLabel);
        String[] types = { "PESSAO FISICA", "PESSOA JURIDICA" };
        typeComboBox = new JComboBox<>(types);
        typeComboBox.setBounds(183,217, 456, 30);
        panel.add(typeComboBox);

        cpfCnpjLabel = new JLabel("CPF/CNPJ:");
        cpfCnpjLabel.setBounds(10, 258, 163, 40);
        cpfCnpjLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(cpfCnpjLabel);
        cpfCnpjField = new JTextField(20);
        cpfCnpjField.setBounds(183, 265, 456, 30);
        panel.add(cpfCnpjField);

        cepLabel = new JLabel("CEP:");
        cepLabel.setBounds(10, 299, 163, 40);
        cepLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(cepLabel);
        cepField = new JTextField(20);
        cepField.setBounds(183, 306, 456, 30);
        panel.add(cepField);

        addressLabel = new JLabel("Endereço:");
        addressLabel.setBounds(10, 340,  163, 40);
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(addressLabel);
        addressField = new JTextField(20);
        addressField.setBounds(183, 347, 456, 30);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(addressField);

        numberLabel = new JLabel("Número:");
        numberLabel.setBounds(10, 381, 163, 40);
        numberLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(numberLabel);
        numberField = new JTextField(20);
        numberField.setBounds(183, 388, 456, 30);
        panel.add(numberField);

        cityLabel = new JLabel("Cidade:");
        cityLabel.setBounds(10, 422, 163, 40);
        cityLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(cityLabel);
        cityField = new JTextField(20);
        cityField.setBounds(183, 429, 456, 30);
        panel.add(cityField);

      stateLabel = new JLabel("Estado:");
      stateLabel.setBounds(10, 463, 163, 40);
      stateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
      panel.add(stateLabel);
      String[] states = { "ACRE", "ALAGOAS", "AMAPÁ", "AMAZONAS", "BAHIA", "CEARÁ", "DISTRITO_FEDERAL", "ESPÍRITO_SANTO",
               "GOIÁS", "MARANHÃO", "MATO_GROSSO", "MATO_GROSSO_DO_SUL", "MINAS_GERAIS", "PARÁ", "PARAÍBA", "PARANÁ",
               "PERNAMBUCO", "PIAUÍ", "RIO_DE_JANEIRO", "RIO_GRANDE_DO_NORTE", "RIO_GRANDE_DO_SUL", "RONDÔNIA", "RORAIMA",
               "SANTA_CATARINA", "SÃO_PAULO", "SERGIPE", "TOCANTINS" };
      stateComboBox = new JComboBox<>(states);
      stateComboBox.setBounds(183, 469, 456, 30);
      panel.add(stateComboBox);

      atualizaButton = new JButton("ATUALIZAR");
      atualizaButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		updateCliente();
        	}
        });
      atualizaButton.setFont(new Font("Arial", Font.BOLD, 14));
      atualizaButton.setBounds(401, 544, 138, 50);
        panel.add(atualizaButton);
        
         voltarButton = new JButton("CANCELAR");
         voltarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TelaClientes clientes = new TelaClientes();
                clientes.setVisible(true);
                clientes.setLocationRelativeTo(null);
                dispose();
        	}
        });
         voltarButton.setFont(new Font("Arial", Font.BOLD, 14));
         voltarButton.setBounds(95, 544, 138, 50);
        panel.add(voltarButton);
        
        panel_1 = new JPanel();
        panel_1.setBounds(10, 11, 649, 34);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("ATUALIZAR CADASTRO DE CLIENTES");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
        lblNewLabel.setBounds(170, 11, 312, 23);
        panel_1.add(lblNewLabel);
        
    }
        
        private void updateCliente() {
        	
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

	        int id;
	        try {
	            id = (int) Long.parseLong(idField.getText());
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "ID do cliente inválido!", "ERRO", JOptionPane.WARNING_MESSAGE);
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
	        newClient.setId_Cliente(id);
	
	        // Save the new client using the DAO
	        ClienteDAO dao = new ClienteDAO();
	        dao.updateCliente(newClient);
	
	        // Clear the fields after adding the client
	        clearFields();
        }
        		
       private void clearFields() {
    	   idField.setText("");
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

