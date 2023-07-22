package br.com.amora.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.amora.biblioteca.controle.Livro;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    public void salvarLivro(Livro livro) {
        String sql = "INSERT INTO livro (titulo, autor, editora, genero_literario, idioma, valor) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getEditora());
            stmt.setString(4, livro.getGeneroLiterario());
            stmt.setString(5, livro.getIdioma());
            stmt.setFloat(6, livro.getValor());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastro do livro: " + livro.getTitulo()+ " realizado com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o livro", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
	    public void atualizarLivro(Livro livro) {
	        String sql = "UPDATE livro SET titulo = ?, autor = ?, editora=?, genero_literario = ?, " +
	                "idioma = ?, valor = ? WHERE Id_Livro = ?";

	        try (Connection conn = DatabaseConnection.getConnection();
	                PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, livro.getTitulo());
	            stmt.setString(2, livro.getAutor());
	            stmt.setString(3, livro.getEditora());
	            stmt.setString(4, livro.getGeneroLiterario());
	            stmt.setString(5, livro.getIdioma());
	            stmt.setFloat(6, livro.getValor());
	            stmt.setLong(7, livro.getId_Livro());

	            stmt.executeUpdate();
	            
	            JOptionPane.showMessageDialog(null, "Atualização do cadastro de: " + livro.getTitulo()+ " realizado com sucesso!");
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(null, "Erro ao atualizar cadastro.", "Erro", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    public void deletarLivro(int idLivro) {
	        String sql = "DELETE FROM livro WHERE Id_Livro = ?";

	        try (Connection conn = DatabaseConnection.getConnection();
	                PreparedStatement stmt = conn.prepareStatement(sql)) { 
	            stmt.setInt(1, idLivro);

	            stmt.executeUpdate();
	            JOptionPane.showMessageDialog(null, "A remoção do livro: " + idLivro + " realizado com sucesso!");
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(null, "Livro não encontrado no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	    
	    public static List<Livro> listarLivros() {
			List<Livro> livros = new ArrayList<>();
			String sql = "SELECT * FROM livro";

			try (Connection conn = DatabaseConnection.getConnection();
					PreparedStatement stmt = conn.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int idLivro = rs.getInt("Id_Livro");
					String titulo = rs.getString("titulo");
					String autor = rs.getString("autor");
					String editora = rs.getString("editora");
					String genero = rs.getString("genero_literario");
					String idioma = rs.getString("idioma");
					float valor = rs.getFloat("valor");

					Livro livro = new Livro();
					livro.setId_Livro(idLivro);
					livro.setTitulo(titulo);
					livro.setAutor(autor);
					livro.setEditora(editora);
					livro.setGeneroLiterario(genero);
					livro.setIdioma(idioma);
					livro.setValor(valor);

					livros.add(livro);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao buscar os livros.", "Erro", JOptionPane.ERROR_MESSAGE);
			}

			return livros;
		}
	}
	
