package view;

import controller.MainController;

public class EditarItemView extends ItemFormularioView {

	private static final long serialVersionUID = 5682304145159294903L;

	public EditarItemView(Long codigo) {
		getBtnAdd().setText("Atualizar");
		this.getLblTituloTopo().setText("< EDITAR ITEM >");
		setTitle("Editar Item");
		preencherFormulario(codigo);
	}

	public void preencherFormulario(Long codigo) {
		getItemCodigo().getTxfCampo().setEditable(false);
		getItemCodigo().getTxfCampo()
			.setText(String.valueOf(MainController
			.getCatalogoControler().getItem(codigo).getCodigo()));
		
		getItemDescricao().getTxfCampo()
		.setText(MainController
		.getCatalogoControler().getItem(codigo).getDescricao());
		
		getItemPreco().getTxfCampo()
		.setText(String.valueOf(MainController
		.getCatalogoControler().getItem(codigo).getPreco()));
		
		getItemTipo().getCbbCampo().removeAllItems();
		getItemTipo().getCbbCampo().addItem(MainController
				.getCatalogoControler().getItem(codigo).getTipo());
		getItemTipo().getCbbCampo().setEnabled(false);
	}
	
	@Override
	public void limparFormulario() {
		getItemDescricao().getTxfCampo().setText("");
		getItemPreco().getTxfCampo().setText("");
	}
}
