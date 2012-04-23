package br.com.depot.model;

public class Produto {
	
	private Long id;
	private String titulo;
	private String descricao;
	
	public Produto () {
	}
	
	public Produto (Long id) {
		this.id = id;
	}
	
	public Produto comId(Long id) {
		this.id = id;
		return this;
	}
	
	public Produto comTitulo(String titulo) {
		this.titulo = titulo;
		return this;
	}
	
	public Produto comDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public String toString() {
		return super.toString() + "-id:" + id + "-titulo:" + titulo + "-descricao:" + descricao;
	}
	
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}
