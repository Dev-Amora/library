ackage br.com.amora.biblioteca.janela;

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

import br.com.amora.biblioteca.controle.Livro;
import br.com.amora.biblioteca.dao.LivroDAO;

public class TelaAtualizarLivro extends JFrame {

	private JPanel contentPane;
    private JLabel titleLabel, authorLabel, publisherLabel, genreLabel, languageLabel, valueLabel, idLabel;
    private JTextField titleField, authorField, publisherField, genreField, languageField, valueField, idField;
    private JButton addButton;
	
	public TelaAtualizarLivro() {
		setTitle("CADASTRO DE LIVROS");
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(50, 50, 685, 516);
	    contentPane = new JPanel();
	    contentPane.setBackground(new Color(128, 128, 128));
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	
	    JPanel panel = new JPanel();
	    panel.setBounds(10, 11, 649, 457);
	    contentPane.add(panel);
	    panel.setLayout(null);
	    
	    idLabel = new JLabel("Id livro:");
	    idLabel.setBounds(10, 58, 163, 40);
	    idLabel.setFont(new Font("Arial", Font.PLAIN, 16));
	    panel.add(idLabel);
	    idField = new JTextField(20);
	    idField.setBounds(183, 65, 456, 30);
	    panel.add(idField);
	
	    titleLabel = new JLabel("Título:");
	    titleLabel.setBounds(10, 99, 163, 40);
	    titleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
	    panel.add(titleLabel);
	    titleField = new JTextField(20);
	    titleField.setBounds(183, 106, 456, 30);
	    panel.add(titleField);
	
	    authorLabel = new JLabel("Autor:");
	    authorLabel.setBounds(10, 143, 163, 40);
	    authorLabel.setFont(new Font("Arial", Font.PLAIN, 16));
	    panel.add(authorLabel);
	    authorField = new JTextField(20);
	    authorField.setBounds(183, 150, 456, 30);
	    panel.add(authorField);
	
	    publisherLabel = new JLabel("Editora:");
	    publisherLabel.setBounds(10, 184, 163, 40);
	    publisherLabel.setFont(new Font("Arial", Font.PLAIN, 16));
	    panel.add(publisherLabel);
	    publisherField = new JTextField(20);
	    publisherField.setBounds(183, 191, 456, 30);
	    panel.add(publisherField);
	
	    genreLabel = new JLabel("Gênero Literário:");
	    genreLabel.setBounds(10, 225, 163, 40);
	    genreLabel.setFont(new Font("Arial", Font.PLAIN, 16));
	    panel.add(genreLabel);
	    genreField = new JTextField(20);
	    genreField.setBounds(183, 232, 456, 30);
	    panel.add(genreField);
	
	    languageLabel = new JLabel("Idioma:");
	    languageLabel.setBounds(10, 266, 163, 40);
	    languageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
	    panel.add(languageLabel);
	    languageField = new JTextField(20);
	    languageField.setBounds(183, 273, 456, 30);
	    panel.add(languageField);
	
	    valueLabel = new JLabel("Valor:");
	    valueLabel.setBounds(10, 307, 163, 40);
	    valueLabel.setFont(new Font("Arial", Font.PLAIN, 16));
	    panel.add(valueLabel);
	    valueField = new JTextField(20);
	    valueField.setBounds(183, 314, 456, 30);
	    panel.add(valueField);
	
	    addButton = new JButton("CADASTRAR");
	    addButton.setFont(new Font("Arial", Font.BOLD, 16));
	    addButton.setBounds(410, 386, 157, 46);
	    panel.add(addButton);
	    
	    JButton btnNewButton_3 = new JButton("CANCELAR");
	    btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 16));
	    btnNewButton_3.setBounds(95, 386, 157, 46);
	    panel.add(btnNewButton_3);
	    
	    JLabel lblNewLabel = new JLabel("Atualizar venda registrada:");
	    lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	    lblNewLabel.setBounds(204, 11, 261, 24);
	    panel.add(lblNewLabel);
	
	    addButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	atualizarLivro();
	        }
	    });
	
	}
	private void atualizarLivro() {
	    // Get the input values from the fields and create a new Livro object
	    String titulo = titleField.getText();
	    String autor = authorField.getText();
	    String editora = publisherField.getText();
	    String generoLiterario = genreField.getText();
	    String idioma = languageField.getText();
	    
	    if (titulo.isEmpty() || autor.isEmpty() || editora.isEmpty() || generoLiterario.isEmpty() || idioma.isEmpty()) {
	   	 JOptionPane.showMessageDialog(null, "Todos os campos obrigatórios devem ser preenchidos!", "Campos vazios",
	                JOptionPane.WARNING_MESSAGE);
	       return;
	   }
	    
	    float valor;
	
	    try {
	        valor = Float.parseFloat(valueField.getText());
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(null, "Valor inserido do livro inválido!", "ERRO", JOptionPane.WARNING_MESSAGE);
	        return;
	    }
	
	    // Create a new Livro object and set its attributes
	    Livro newLivro = new Livro();
	    newLivro.setTitulo(titulo);
	    newLivro.setAutor(autor);
	    newLivro.setEditora(editora);
	    newLivro.setGeneroLiterario(generoLiterario);
	    newLivro.setIdioma(idioma);
	    newLivro.setValor(valor);
	
	    // Save the new book using the DAO
	    LivroDAO dao = new LivroDAO();
	    dao.atualizarLivro(newLivro);
	    // Clear the fields after adding the book
	    clearFields();
	}
	
	private void clearFields() {
	    titleField.setText("");
	    authorField.setText("");
	    publisherField.setText("");
	    genreField.setText("");
	    languageField.setText("");
	    valueField.setText("");
	}
	
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            TelaLivro frame = new TelaLivro();
	            frame.setLocationRelativeTo(null);
	            frame.setVisible(true);
	        }
	    });
	}
	}
