package view;

import controller.MainController;
import util.ItemComboBoxFormulario;
import util.ItemTextFormulario;

public class ItemOSFormularioView extends AbstractFormularioView {

	private static final long serialVersionUID = 1781225813760358301L;
	private ItemTextFormulario itemIdOS;
	private ItemComboBoxFormulario itemCodigoOS;
	private ItemTextFormulario itemQtdeOS;
	
	public ItemOSFormularioView(String id) {
		super();
		this.getLblTituloTopo().setText("< ADICIONAR ITEM NA ORDEM DE SERVICO >");
		setTitle("Adicionar Item na Ordem de Servico");
		
		itemIdOS = new ItemTextFormulario("ID da OS");
		itemIdOS.getTxfCampo().setText(id);
		itemIdOS.getTxfCampo().setEditable(false);

		getPnlFormulario().add(itemIdOS);
		this.addItensFormulario();
	}

	@Override
	public void armazenarFormulario() {
		String campoID = getItemIdOS().getTxfCampo().getText();
		Long campoCodigo = (Long) getItemCodigoOS().getCbbCampo().getSelectedItem();
		int campoQtde = Integer.valueOf(getItemQtdeOS().getTxfCampo().getText());

		MainController.getOrdemServicoController().getOS(campoID)
			.addItem(MainController.getCatalogoControler().getItem(campoCodigo), campoQtde);
		
		limparFormulario();
	}

	@Override
	public void addItensFormulario() {
		itemCodigoOS = new ItemComboBoxFormulario("Item");
		itemQtdeOS = new ItemTextFormulario("Qtde");
		
		
		for (long item : MainController.getCatalogoControler().getListaCodigoItens()) {
			itemCodigoOS.getCbbCampo().addItem(item);
		}
		
		getPnlFormulario().add(itemCodigoOS);
		getPnlFormulario().add(itemQtdeOS);
	}
	
	@Override
	public void limparFormulario() {
		getItemQtdeOS().getTxfCampo().setText("");
	}

	public ItemComboBoxFormulario getItemCodigoOS() {
		return itemCodigoOS;
	}

	public ItemTextFormulario getItemQtdeOS() {
		return itemQtdeOS;
	}

	public ItemTextFormulario getItemIdOS() {
		return itemIdOS;
	}
	
}
