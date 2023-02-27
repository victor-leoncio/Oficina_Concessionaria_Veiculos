package model;

import java.io.Serializable;

public class Pessoa implements IPessoa, Serializable {

	private static final long serialVersionUID = 4327654212833961540L;
	private final long cpf;
	private String nome;
	private long telefone;
	private String email;

	public Pessoa(long cpf, String nome, long telefone) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
	}

	@Override
	public long getCpf() {
		return this.cpf;
	}

	@Override
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public long getTelefone() {
		return this.telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	@Override
	public String getEmail() {
		return this.email;
	}

	// TODO implementar EmailException
	public void setEmail(String email) {
		this.email = email;
	}
	
}
