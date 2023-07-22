package br.com.amora.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.amora.biblioteca.controle.Venda;

public class VendaDAO {
	
	
	public void inserirVenda(Venda venda) {
	    String sql = "INSERT INTO biblioteca.venda (data_venda, vendedor, Id_Cliente, Id_Livro) VALUES (CURRENT_TIMESTAMP, ?, ?, ?)";

	    try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, venda.getNomeVendedor());
	        stmt.setInt(2, venda.getId_Cliente());
	        stmt.setInt(3, venda.getId_Livro());
	        
	        stmt.executeUpdate();
	        JOptionPane.showMessageDialog(null, "Venda número: " + venda.getId_Venda()+  "do item " + venda.getId_Livro()+ "\n "
	        		+ "Realizada com sucesso");
	        

	    } catch (SQLException e) {
	    	JOptionPane.showMessageDialog(null, "Erro ao registrar Venda.", "Erro", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	
	public void atualizarVenda(Venda venda) {
	    String sql = "UPDATE biblioteca.venda SET vendedor = ?, Id_Cliente = ?, Id_Livro = ? WHERE Id_Venda = ?";

	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, venda.getNomeVendedor());
	        stmt.setInt(2, venda.getId_Cliente());
	        stmt.setInt(3, venda.getId_Livro());
	        stmt.setInt(4, venda.getId_Venda());

	        int linhasAfetadas = stmt.executeUpdate();

	        if (linhasAfetadas > 0) {
	            JOptionPane.showMessageDialog(null, "Venda: " + venda.getId_Venda() + " realizada por vendedor: " + venda.getNomeVendedor() + " foi atualizado com sucesso");
	        } else {
	            JOptionPane.showMessageDialog(null, "Nenhuma venda foi atualizada. Verifique o ID da venda.", "Erro", JOptionPane.ERROR_MESSAGE);
	        }

	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Erro ao atualizar venda: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	    }
	}

	
	public void apagarVenda(int idVenda) {
		
		String sql = "DELETE FROM biblioteca.venda WHERE id_Venda = ?";
		
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){
        	
            stmt.setInt(1, idVenda);
            stmt.executeUpdate();
         
           	 JOptionPane.showMessageDialog(null,"Venda:  " + idVenda + " foi deletado com sucesso!");
            
        } catch (SQLException e) {
       	 JOptionPane.showMessageDialog(null,"Erro ao tentar deletar o venda: ", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
	
		
	}
