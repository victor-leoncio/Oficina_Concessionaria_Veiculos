package model;

import java.io.Serializable;

public class Cliente extends Pessoa implements ICliente, Serializable {

	private static final long serialVersionUID = -8552018982790359695L;
	public boolean platinum;

	public Cliente(long cpf, String nome, long telefone) {
		super(cpf, nome, telefone);
		platinum = false;
	}

	@Override
	public boolean isPlatinum() {
		return this.platinum;
	}

	public void setPlatinum(boolean platinum) {
		this.platinum = platinum;
	}
	
}