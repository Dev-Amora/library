package br.com.amora.biblioteca.controle;

public class Venda {

	private int id_Venda;
	private String nomeVendedor;
	private int id_Cliente;
	private int id_Livro;
	
	public int getId_Venda() {
		return id_Venda;
	}
	public void setId_Venda(int id_Venda) {
		this.id_Venda = id_Venda;
	}
	public String getNomeVendedor() {
		return nomeVendedor;
	}
	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}
	public int getId_Cliente() {
		return id_Cliente;
	}
	public void setId_Cliente(int id_Cliente) {
		this.id_Cliente = id_Cliente;
	}
	public int getId_Livro() {
		return id_Livro;
	}
	public void setId_Livro(int id_Livro) {
		this.id_Livro = id_Livro;
	}
	
}
