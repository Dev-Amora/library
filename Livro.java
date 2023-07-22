package br.com.amora.biblioteca.controle;

public class Livro {
	private long Id_Livro;
	private String titulo;
	private String autor;
	private String Editora;
	private String generoLiterario;
	private String Idioma;
	private Float valor;
	
	public long getId_Livro() {
		return Id_Livro;
	}
	public void setId_Livro(long id_Livro) {
		Id_Livro = id_Livro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return Editora;
	}
	public void setEditora(String editora) {
		Editora = editora;
	}
	public String getGeneroLiterario() {
		return generoLiterario;
	}
	public void setGeneroLiterario(String generoLiterario) {
		this.generoLiterario = generoLiterario;
	}
	public String getIdioma() {
		return Idioma;
	}
	public void setIdioma(String idioma) {
		Idioma = idioma;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	
}
