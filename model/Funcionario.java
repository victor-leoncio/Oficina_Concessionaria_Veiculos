package model;

import java.io.Serializable;

public class Funcionario extends Pessoa implements IFuncionario, Serializable {

	private static final long serialVersionUID = 3177828322309797277L;
	private final int matricula;
	
	public Funcionario(long cpf, String nome, long telefone, int matricula) {
		super(cpf, nome, telefone);
		this.matricula = matricula;
	}

	@Override
	public int getMatricula() {
		return this.matricula;
	}
	
}
