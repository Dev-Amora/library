package br.com.amora.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.amora.biblioteca.pessoa.Fornecedor;

public class FornecedorDAO {
	
    public void salvarFornecedor(Fornecedor fornecedor) {
        String sql = "INSERT INTO biblioteca.fornecedor (nome, tipo, cnpj_cpf, contato, endereco, produtos_servico, prazo_entrega) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getTipo());
            stmt.setString(3, fornecedor.getCnpj_cpf());
            stmt.setString(4, fornecedor.getContato());
            stmt.setString(5, fornecedor.getEndereco());
            stmt.setString(6, fornecedor.getProdutosOuServiço());
            stmt.setString(7, fornecedor.getPrazoDeEntrega());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro do fornecedor: " + fornecedor.getNome() + " realizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar fornecedor", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

	    public void atualizarFornecedor(Fornecedor fornecedor) {
	        String sql = "UPDATE fornecedor SET nome = ?, contato = ?, endereco = ?, " +
	                "produtos_servico = ?, prazo_entrega = ? WHERE  = ?";

	        try (Connection conn = DatabaseConnection.getConnection();
	                PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, fornecedor.getNome());
	            stmt.setString(2, fornecedor.getContato());
	            stmt.setString(3, fornecedor.getEndereco());
	            stmt.setString(4, fornecedor.getProdutosOuServiço());
	            stmt.setString(5, fornecedor.getPrazoDeEntrega());
	            stmt.setString(6, fornecedor.getCnpj_cpf());
	            

	            stmt.executeUpdate();
	            
	            JOptionPane.showMessageDialog(null, "Atualização do cadastro de: " + fornecedor.getNome() + " realizado com sucesso!");
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(null, "Erro ao atualizar cadastro.", "Erro", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    public void deletarFornecedor(int idFornecedor) {
	        String sql = "DELETE FROM fornecedor WHERE id_Fornecedor = ?";

	        try (Connection conn = DatabaseConnection.getConnection();
	                PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setLong(1, idFornecedor);

	            stmt.executeUpdate();
	            JOptionPane.showMessageDialog(null, "A remoção do fornecedor: " + idFornecedor + " realizado com sucesso!");
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(null, "Fornecedor não encontrado no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
	        }
	    }
}
