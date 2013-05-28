package com.momoca.model;

public class Usuario {

	private Long id;
	private String nome;
	private String senha;
	
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}



	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
