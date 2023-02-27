package controller;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import model.Categoria;
import model.ETipoItem;
import model.IItem;
import model.Item;

public class CatalogoController implements Serializable{

	private static final long serialVersionUID = 5328919611273653058L;
	private Map<String, Categoria> categorias;
	private Map<Long, IItem> itens;

	public CatalogoController() {
		categorias = new TreeMap<>();
		itens = new TreeMap<>();
	}
	
	public void addCategoria(String nome) {
		categorias.put(nome, new Categoria(nome));
	}
	
	public void addItem(String nomeCategoria, long codigo, ETipoItem tipo, String descricao, double preco) {

		Categoria categoria = categorias.get(nomeCategoria);

		Item item = new Item(tipo, codigo, descricao);
		item.setPreco(preco);

		itens.put(item.getCodigo(), item);

		if (categoria != null) {
			categoria.addItem(item);
		}
	}
	
	public IItem getItem(Long codigo) {
		return itens.get(codigo);
	}
	
	public Set<String> getListaNomeCategorias() {
		return categorias.keySet();
	}
	
	public Set<Long> getListaCodigoItens() {
		return  itens.keySet();
	}
	
	public Collection<Categoria> getListaCategorias() {
		return this.categorias.values();
	}
	
	public Collection<IItem> getListaItens() {
		return this.itens.values();
	}
	
	public List<IItem> getListaItens(String categoria) {
		return categorias.get(categoria).getItens();
	}
	
	public String infoCategoria(Categoria cat) {
		return String.format("%s\n", cat.getNome());
	}
	
	public String infoTodasCategorias() {
		StringBuilder sb = new StringBuilder();
		
		for (Categoria dado : getListaCategorias()) {
			sb.append(infoCategoria(dado));
		}
		
		return sb.toString();
	}
	
	public String infoItem(IItem item) {
		return String.format("[CODIGO = %d]\nTipo = %s\nDescricao = %s\nPreco = %.2f\n\n",
				item.getCodigo(), item.getTipo(), item.getDescricao(), item.getPreco());
	}
	
	public String infoTodosItens() {
		StringBuilder sb = new StringBuilder();
		
		for (IItem dado : getListaItens()) {
			sb.append(infoItem(dado));
		}
		
		return sb.toString();
	}
	
	public String infoFiltroCategoria(String nome) {
		return categorias.get(nome).listarItens().toString(); 
	}
	
	public void removerCategoria(String nome) {
		categorias.remove(nome);
	}
	
	public void removerItem(Long codigo) {
		itens.remove(codigo);
	}

}
