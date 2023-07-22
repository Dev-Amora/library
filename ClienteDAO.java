package br.com.amora.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import br.com.amora.biblioteca.pessoa.Cliente;

public class ClienteDAO{
	
	public void saveCliente(Cliente cliente) {
        String sql = "INSERT INTO biblioteca.cliente ( nome, email, telefone, genero, tipo, cnpj_cpf, CEP, endereco, numero, cidade, estado) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
        	stmt.setString(1, cliente.getNome());
        	stmt.setString(2, cliente.getEmail());
        	stmt.setString(3, cliente.getTelefone());
        	stmt.setString(4, cliente.getGenero());
            stmt.setString(5, cliente.getTipoPessoa());
            stmt.setString(6, cliente.getCnpj_cpf());
            stmt.setString(7, cliente.getCEP());
            stmt.setString(8, cliente.getEndereco());
            stmt.setString(9, cliente.getNumero());
            stmt.setString(10, cliente.getCidade());
            stmt.setString(11, cliente.getEstado());


            stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cadastro do livro: " + cliente.getNome()+ " realizado com sucesso!");
			            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o cliente", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
        
        
        public void updateCliente(Cliente cliente) {
        	String sql = "UPDATE biblioteca.cliente SET nome = ?, email = ?, telefone = ?, genero = ?, tipo=?, cnpj_cpf=?, " +
                    "CEP = ?, endereco = ?, numero = ?, cidade = ?, estado = ? WHERE Id_Cliente = ?";

            try (Connection conn = DatabaseConnection.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(sql)) {
            	stmt.setString(1, cliente.getNome());
            	stmt.setString(2, cliente.getEmail());
            	stmt.setString(3, cliente.getTelefone());
            	stmt.setString(4, cliente.getGenero());
                stmt.setString(5, cliente.getTipoPessoa());
                stmt.setString(6, cliente.getCnpj_cpf());
                stmt.setString(7, cliente.getCEP());
                stmt.setString(8, cliente.getEndereco());
                stmt.setString(9, cliente.getNumero());
                stmt.setString(10, cliente.getCidade());
                stmt.setString(11, cliente.getEstado());
                stmt.setLong(12, cliente.getId_Cliente());

                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Atualização do cadastro de " + cliente.getNome()+ " realizado com sucesso!");
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(null, "Erro ao atualizar cadastr.", "Erro", JOptionPane.ERROR_MESSAGE);
	        }
	    }
        
        public void deleteCliente(int idCliente) {
        	String sql = "DELETE FROM biblioteca.cliente WHERE Id_Cliente = ?";

            try (Connection conn = DatabaseConnection.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(sql)) {
  
                
                 stmt.setInt(1, idCliente);

                 int linhasAfetadas = stmt.executeUpdate();

                 if (linhasAfetadas > 0) {
                	 JOptionPane.showMessageDialog(null,"Cliente com Id_Cliente " + idCliente + " foi deletado com sucesso!","Erro", JOptionPane.ERROR_MESSAGE);
                 } else {
                	 JOptionPane.showMessageDialog(null,"Cliente com Id_Cliente " + idCliente + " não foi encontrado no banco de dados.","Erro", JOptionPane.ERROR_MESSAGE);
                 }
             } catch (SQLException e) {
            	 JOptionPane.showMessageDialog(null,"Erro ao tentar deletar o cliente: ", "Erro", JOptionPane.ERROR_MESSAGE);
             }
         }
     }
