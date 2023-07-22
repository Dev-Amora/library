package br.com.amora.biblioteca.janela;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import br.com.amora.biblioteca.dao.LivroDAO;


public class TelaDeletarLivro extends JFrame {

    private JButton deleteButton;
    private JLabel lblNewLabel;
    private LivroDAO livroDAO;
    private JTextField idLivroField;

    public TelaDeletarLivro() {
        super("Deletar Venda");
        setTitle("DELETAR");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);

        livroDAO = new LivroDAO();

        JLabel idLivroLabel = new JLabel("Id Venda:");
        idLivroLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        idLivroLabel.setBounds(10, 59, 87, 40);

        idLivroField = new JTextField();
        idLivroField.setFont(new Font("Arial", Font.PLAIN, 12));
        idLivroField.setHorizontalAlignment(SwingConstants.CENTER);
        idLivroField.setBounds(107, 66, 267, 30);

        deleteButton = new JButton("DELETAR");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idLivroText = idLivroField.getText().trim();
                if (idLivroText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Digite o Id_Venda a ser deletado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int idLivro = Integer.parseInt(idLivroText);
                    deletarLivro(idLivro);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "O Id_Venda deve ser um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        deleteButton.setFont(new Font("Arial", Font.BOLD, 14));
        deleteButton.setBounds(226, 145, 109, 55);
        getContentPane().setLayout(null);

        getContentPane().add(idLivroLabel);
        getContentPane().add(idLivroField);
        getContentPane().add(deleteButton);

        lblNewLabel = new JLabel("Deseja deletar livro:");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        lblNewLabel.setBounds(81, 11, 213, 21);
        getContentPane().add(lblNewLabel);

        JButton cancelButton = new JButton("CANCELAR");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaLivro livro = new TelaLivro();
                livro.setVisible(true);
                livro.setLocationRelativeTo(null);
                dispose();
            }
        });
        cancelButton.setFont(new Font("Arial", Font.BOLD, 14));
        cancelButton.setBounds(40, 145, 109, 55);
        getContentPane().add(cancelButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void deletarLivro(int idLivro) {
        livroDAO.deletarLivro(idLivro);
        clearFields();
    }

    private void clearFields() {
        idLivroField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaDeletarLivro::new);
    }
}
