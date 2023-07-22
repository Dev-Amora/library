package br.com.amora.biblioteca.janela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import br.com.amora.biblioteca.dao.LivroDAO;
import br.com.amora.biblioteca.controle.Livro;
import javax.swing.border.EmptyBorder;

public class TelaAcervo extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaAcervo frame = new TelaAcervo();
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
    public TelaAcervo() {
    	setTitle("ACERVO");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 685, 524);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(128, 128, 128));
        panel.setBounds(10, 53, 649, 421);
        contentPane.add(panel);

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

	
        // Adding the JTable from TelaAcervo class
        String[] columns = {"ID", "Título", "Autor", "Editora", "Gênero Literario", "Idioma", "Valor"};
        tableModel = new DefaultTableModel(columns, 0);
        panel.setLayout(null);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 11, 629, 399);
        panel.add(scrollPane);

        // Preenche a tabela com os dados dos livros
        List<Livro> livros = LivroDAO.listarLivros();
        for (Livro livro : livros) {
            Object[] row = {livro.getId_Livro(), livro.getTitulo(), livro.getAutor(), livro.getEditora(),
                            livro.getGeneroLiterario(), livro.getIdioma(), livro.getValor()};
            tableModel.addRow(row);
        }
    }
}
