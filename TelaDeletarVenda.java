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

import br.com.amora.biblioteca.dao.VendaDAO;

public class TelaDeletarVenda extends JFrame {

    private JTextField idVendaField;
    private JButton deleteButton;
    private JLabel lblNewLabel;
    private VendaDAO vendaDAO;

    public TelaDeletarVenda() {
        super("Deletar Venda");
        setTitle("DELETAR");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);

        vendaDAO = new VendaDAO();

        JLabel idVendaLabel = new JLabel("Id Venda:");
        idVendaLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        idVendaLabel.setBounds(10, 59, 87, 40);

        idVendaField = new JTextField();
        idVendaField.setFont(new Font("Arial", Font.PLAIN, 12));
        idVendaField.setHorizontalAlignment(SwingConstants.CENTER);
        idVendaField.setBounds(107, 66, 267, 30);

        deleteButton = new JButton("DELETAR");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idVendaText = idVendaField.getText().trim();
                if (idVendaText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Digite o Id_Venda a ser deletado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int idVenda = Integer.parseInt(idVendaText);
                    apagarVenda(idVenda);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "O Id_Venda deve ser um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        deleteButton.setFont(new Font("Arial", Font.BOLD, 14));
        deleteButton.setBounds(226, 145, 109, 55);
        getContentPane().setLayout(null);

        getContentPane().add(idVendaLabel);
        getContentPane().add(idVendaField);
        getContentPane().add(deleteButton);

        lblNewLabel = new JLabel("Deseja deletar venda:");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        lblNewLabel.setBounds(81, 11, 213, 21);
        getContentPane().add(lblNewLabel);

        JButton cancelButton = new JButton("CANCELAR");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaVenda venda = new TelaVenda();
                venda.setVisible(true);
                venda.setLocationRelativeTo(null);
                dispose();
            }
        });
        cancelButton.setFont(new Font("Arial", Font.BOLD, 14));
        cancelButton.setBounds(40, 145, 109, 55);
        getContentPane().add(cancelButton);

        setLocationRelativeTo(null); // Centralize the frame
        setVisible(true);
    }

    // Método para deletar a venda usando a lógica da classe VendaDAO
    private void apagarVenda(int idVenda) {
        vendaDAO.apagarVenda(idVenda);
        clearFields();
    }

    private void clearFields() {
        idVendaField.setText("");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaDeletarVenda::new);
    }
}
