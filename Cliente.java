package br.com.amora.biblioteca.pessoa;

public class Cliente extends Pessoa {
	
	private long Id_Cliente;
	private String tipoPessoa;
	private String cnpj_cpf;
	
	public long getId_Cliente() {
		return Id_Cliente;
	}
	public void setId_Cliente(long id) {
		Id_Cliente = id;
	}
	
	public String getCnpj_cpf() {
		return cnpj_cpf;
	}
	public void setCnpj_cpf(String cadastro_pessoa) {
		this.cnpj_cpf = cadastro_pessoa;
	}
	
	public String getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
}
