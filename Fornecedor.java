package br.com.amora.biblioteca.pessoa;

public class Fornecedor {
	
	private long id_Fornecedor;
	private String nome;
	private String tipo;
	private String cnpj_cpf;
	private String contato;
	private String endereco;
	private String ProdutosOuServiço;
	private String PrazoDeEntrega;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCnpj_cpf() {
		return cnpj_cpf;
	}
	public void setCnpj_cpf(String cnpj_cpf) {
		this.cnpj_cpf = cnpj_cpf;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereço(String endereço) {
		this.endereco = endereço;
	}
	public String getProdutosOuServiço() {
		return ProdutosOuServiço;
	}
	public void setProdutosOuServiço(String produtosOuServiço) {
		ProdutosOuServiço = produtosOuServiço;
	}
	public String getPrazoDeEntrega() {
		return PrazoDeEntrega;
	}
	public void setPrazoDeEntrega(String prazoDeEntrega) {
		PrazoDeEntrega = prazoDeEntrega;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public long getId_Fornecedor() {
		return id_Fornecedor;
	}
	public void setId_Fornecedor(long id_Fornecedor) {
		this.id_Fornecedor = id_Fornecedor;
	}
	
}
