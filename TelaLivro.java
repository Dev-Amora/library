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

import br.com.amora.biblioteca.dao.LivroDAO;
import br.com.amora.biblioteca.controle.Livro;

public class TelaLivro extends JFrame {

    private JPanel contentPane;
    private JLabel titleLabel, authorLabel, publisherLabel, genreLabel, languageLabel, valueLabel;
    private JTextField titleField, authorField, publisherField, genreField, languageField, valueField;
    private JButton addButton;
    private JPanel panel_2;

    public TelaLivro() {
        setTitle("CADASTRO DE LIVROS");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 685, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 53, 649, 397);
        contentPane.add(panel);
        panel.setLayout(null);

        titleLabel = new JLabel("Título:");
        titleLabel.setBounds(10, 16, 163, 40);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(titleLabel);
        titleField = new JTextField(20);
        titleField.setBounds(183, 23, 456, 30);
        panel.add(titleField);

        authorLabel = new JLabel("Autor:");
        authorLabel.setBounds(10, 55, 163, 40);
        authorLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(authorLabel);
        authorField = new JTextField(20);
        authorField.setBounds(183, 62, 456, 30);
        panel.add(authorField);

        publisherLabel = new JLabel("Editora:");
        publisherLabel.setBounds(10, 99, 163, 40);
        publisherLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(publisherLabel);
        publisherField = new JTextField(20);
        publisherField.setBounds(183, 106, 456, 30);
        panel.add(publisherField);

        genreLabel = new JLabel("Gênero Literário:");
        genreLabel.setBounds(10, 140, 163, 40);
        genreLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(genreLabel);
        genreField = new JTextField(20);
        genreField.setBounds(183, 147, 456, 30);
        panel.add(genreField);

        languageLabel = new JLabel("Idioma:");
        languageLabel.setBounds(10, 181, 163, 40);
        languageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(languageLabel);
        languageField = new JTextField(20);
        languageField.setBounds(183, 188, 456, 30);
        panel.add(languageField);

        valueLabel = new JLabel("Valor:");
        valueLabel.setBounds(10, 222, 163, 40);
        valueLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(valueLabel);
        valueField = new JTextField(20);
        valueField.setBounds(183, 229, 456, 30);
        panel.add(valueField);

        addButton = new JButton("CADASTRAR");
        addButton.setFont(new Font("Arial", Font.BOLD, 16));
        addButton.setBounds(409, 302, 157, 46);
        panel.add(addButton);
        
        panel_2 = new JPanel();
        panel_2.setBackground(new Color(128, 128, 128));
        panel_2.setBounds(10, 273, 248, 113);
        panel.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Outras Funções:");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNewLabel.setBounds(64, 11, 122, 14);
        panel_2.add(lblNewLabel);
        
        JButton btnNewButton_9 = new JButton("DELETAR");
        btnNewButton_9.setFont(new Font("Arial", Font.BOLD, 12));
        btnNewButton_9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 TelaDeletarLivro deletar = new TelaDeletarLivro();
                 deletar.setVisible(true);
                 deletar.setLocationRelativeTo(null);
                 dispose();
        	}
        });
        btnNewButton_9.setBounds(10, 66, 100, 36);
        panel_2.add(btnNewButton_9);
        
        JButton btnNewButton_6 = new JButton("ATUALIZAR");
        btnNewButton_6.setFont(new Font("Arial", Font.BOLD, 12));
        btnNewButton_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TelaAtualizarLivro atual = new TelaAtualizarLivro();
                atual.setVisible(true);
                atual.setLocationRelativeTo(null);
                dispose();
        	}
        });
        btnNewButton_6.setBounds(137, 66, 100, 36);
        panel_2.add(btnNewButton_6);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveLivro();
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
    private void saveLivro() {
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
        dao.salvarLivro(newLivro);
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
