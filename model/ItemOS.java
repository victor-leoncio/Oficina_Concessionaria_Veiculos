package model;

import java.io.Serializable;

public class ItemOS implements Serializable{
	
	private static final long serialVersionUID = 4792500588344645650L;
	private int qtde;
	private double preco;
	private final IItem item;
	
	public ItemOS(IItem item, int qtde, double preco) {
		this.qtde = qtde;
		this.preco = preco;
		this.item = item;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public IItem getItem() {
		return item;
	}
	
	public double getTotalItem() {
		return getQtde() * getPreco();
	}
	
	public String listarItem() {
		StringBuilder sb = new StringBuilder();
		sb.append("Tipo: " + getItem().getTipo());
		sb.append("\nCodigo: " + getItem().getCodigo());
		sb.append("\nDescricao: " + getItem().getDescricao());
		sb.append(String.format("\nPreco: %.2f ", getPreco()));
		sb.append("\nQtde: " + getQtde());
		sb.append(String.format("\nPreco Total: %.2f\n\n", getTotalItem()));
		return sb.toString();
	}
	
}