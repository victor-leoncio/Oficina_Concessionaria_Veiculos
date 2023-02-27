package model;

import java.io.Serializable;

public class Item implements IItem, Serializable {

	private static final long serialVersionUID = -5250225641790773500L;
	private final ETipoItem tipo;
	private final long codigo;
	private final String descricao;
	private double preco;
	
	public Item(ETipoItem tipo, long codigo, String descricao) {
		this.tipo = tipo;
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Item(ETipoItem tipo, long codigo, String descricao, double preco) {
		this.tipo = tipo;
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
	}

	@Override
	public ETipoItem getTipo() {
		return this.tipo;
	}

	@Override
	public long getCodigo() {
		return this.codigo;
	}

	@Override
	public String getDescricao() {
		return this.descricao;
	}

	@Override
	public double getPreco() {
		return this.preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}