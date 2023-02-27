package view;

import controller.MainController;
import util.ItemTextFormulario;

public class CategoriaFormularioView extends AbstractFormularioView {

	private static final long serialVersionUID = -2870562617967751236L;
	private ItemTextFormulario itemCategoriaNome;

	public CategoriaFormularioView() {
		super();
		this.getLblTituloTopo().setText("< ADICIONAR CATEGORIA >");
		setTitle("Adicionar Categoria");
		addItensFormulario();
	}

	@Override
	public void addItensFormulario() {
		itemCategoriaNome = new ItemTextFormulario("Nome da Categoria");
		this.getPnlFormulario().add(itemCategoriaNome);
	}

	@Override
	public void armazenarFormulario() {
		String campoNome = getItemCategoriaNome().getTxfCampo().getText();
		MainController.getCatalogoControler().addCategoria(campoNome);
		limparFormulario();
	}
	
	@Override
	public void limparFormulario() {
		this.itemCategoriaNome.getTxfCampo().setText("");
	}

	public ItemTextFormulario getItemCategoriaNome() {
		return itemCategoriaNome;
	}

}