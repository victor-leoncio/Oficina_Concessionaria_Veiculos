package view;

import controller.MainController;
import util.ItemTextFormulario;

public class ModeloFormularioView extends AbstractFormularioView {

	private static final long serialVersionUID = -2515486953543165856L;
	private ItemTextFormulario itemModeloNome;

	public ModeloFormularioView() {
		super();
		this.getLblTituloTopo().setText("< ADICIONAR MODELO >");
		setTitle("Adicionar Modelo");
		addItensFormulario();
	}

	@Override
	public void armazenarFormulario() {
		String campoNome = getItemModeloNome().getTxfCampo().getText();
		MainController.getVeiculoController().addModelo(campoNome);
		limparFormulario();
	}

	@Override
	public void addItensFormulario() {
		itemModeloNome = new ItemTextFormulario("Nome da Categoria");
		this.getPnlFormulario().add(itemModeloNome);
	}

	@Override
	public void limparFormulario() {
		this.itemModeloNome.getTxfCampo().setText("");
	}

	public ItemTextFormulario getItemModeloNome() {
		return itemModeloNome;
	}
	
}
