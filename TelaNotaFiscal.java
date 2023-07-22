package br.com.amora.biblioteca.janela;

import java.awt.BorderLayout;
import java.awt.Color;

import br.com.amora.biblioteca.controle.NotaFiscal;
import br.com.amora.biblioteca.dao.NotaFiscaisDAO;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class TelaNotaFiscais extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;

    public TelaNotaFiscais() {
        setTitle("Notas Fiscais");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 937, 524);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 53, 900, 421);
        panel.setBackground(new Color(128, 128, 128));
        contentPane.add(panel);
        panel.setLayout(new BorderLayout());

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 11, 900, 30);
        panel_1.setBackground(new Color(128, 128, 128));
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
        btnNewButton_1.setBounds(139, 0, 101, 31);
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
        btnNewButton_2.setBounds(299, 0, 84, 31);
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
        btnNewButton_4.setBounds(621, 0, 101, 31);
        panel_1.add(btnNewButton_4);

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
        btnNewButton_3.setBounds(436, 0, 121, 31);
        panel_1.add(btnNewButton_3);
        
                JButton btnNewButton_5 = new JButton("Fornecedores");
                btnNewButton_5.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		TelaFornecedores forne = new TelaFornecedores();
                		forne.setVisible(true);
        	        	forne.setLocationRelativeTo(null);
        	        	dispose();
                		
                	}
                });
                btnNewButton_5.setBounds(775, 0, 115, 31);
                panel_1.add(btnNewButton_5);
        
        String[] columns = {"ID Venda", "Data Venda", "Vendedor", "Nome Cliente", "Tipo Cliente", "CNPJ/CPF",
                "ID Livro", "Título", "Autor", "Editora", "Gênero Literário", "Idioma", "Valor"};
		DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
		JTable table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(30, 20, 1000, 399);
		panel.add(scrollPane);
		
		//Preenche a tabela com os dados das notas fiscais
		List<NotaFiscal> notasFiscais = NotaFiscaisDAO.obterNotasFiscais();
		for (NotaFiscal notaFiscal : notasFiscais) {
		Object[] row = {notaFiscal.getIdVenda(), notaFiscal.getDataVenda(), notaFiscal.getVendedor(),
		                notaFiscal.getNomeCliente(), notaFiscal.getTipoCliente(), notaFiscal.getCnpjCpf(),
		                notaFiscal.getId_Livro(), notaFiscal.getTitulo(), notaFiscal.getAutor(),
		                notaFiscal.getEditora(), notaFiscal.getGeneroLiterario(), notaFiscal.getIdioma(),
		                notaFiscal.getValor()};
		tableModel.addRow(row);
}

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaNotaFiscais frame = new TelaNotaFiscais();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}





