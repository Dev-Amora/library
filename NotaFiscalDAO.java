package br.com.amora.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import br.com.amora.biblioteca.controle.NotaFiscal;

public class NotaFiscaisDAO {

	public static List<NotaFiscal> obterNotasFiscais() {
        List<NotaFiscal> notasFiscais = new ArrayList<>();
        String sql = "SELECT * FROM nota_fiscais";

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
				
                NotaFiscal notaFiscal = new NotaFiscal();
                notaFiscal.setIdVenda(rs.getInt("Id_Venda"));
                notaFiscal.setDataVenda(rs.getString("data_venda"));
                notaFiscal.setVendedor(rs.getString("vendedor"));
                notaFiscal.setNomeCliente(rs.getString("nome_cliente"));
                notaFiscal.setTipoCliente(rs.getString("tipo_cliente"));
                notaFiscal.setCnpjCpf(rs.getString("cnpj_cpf"));
                notaFiscal.setId_Livro(idLivro);
                notaFiscal.setTitulo(titulo);
                notaFiscal.setAutor(autor);
                notaFiscal.setEditora(editora);
                notaFiscal.setGeneroLiterario(genero);
                notaFiscal.setIdioma(idioma);
                notaFiscal.setValor(valor);
                
                notasFiscais.add(notaFiscal);
            }

        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Erro ao buscar os notas fiscais.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return notasFiscais;
    }
}
