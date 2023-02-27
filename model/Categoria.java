package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Categoria implements Serializable{
	
	private static final long serialVersionUID = -7808512252524486232L;
	private final String nome;
	private List<IItem> itens = new ArrayList<>();
	
	public Categoria(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void addItem(IItem item) {
		itens.add(item);
	}
	
	public void removeItem(IItem item) {
		itens.remove(item);
	}
	
	public List<IItem> getItens() {
		return this.itens;
	}

	public StringBuilder listarItens() {
		StringBuilder sb = new StringBuilder();
		
		for (IItem item : itens) {
			sb.append("Tipo: " + item.getTipo());
			sb.append("\nCodigo: " + item.getCodigo());
			sb.append("\nDescricao: " + item.getDescricao());
			sb.append("\nPreco: " + item.getPreco());
		}
		
		return sb;
	}
	
}