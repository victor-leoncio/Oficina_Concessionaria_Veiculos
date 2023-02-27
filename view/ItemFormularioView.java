package view;

import javax.swing.DefaultComboBoxModel;

import controller.MainController;
import model.ETipoItem;
import util.ItemComboBoxFormulario;
import util.ItemTextFormulario;

public class ItemFormularioView extends AbstractFormularioView {

	private static final long serialVersionUID = -8707254472341023757L;
	private ItemComboBoxFormulario itemTipo;
	private ItemTextFormulario itemCodigo;
	private ItemTextFormulario itemDescricao;
	private ItemTextFormulario itemPreco;
	private ItemComboBoxFormulario itemCategoria;
	
	public ItemFormularioView() {
		super();
		this.getLblTituloTopo().setText("< ADICIONAR ITEM >");
		setTitle("Adicionar Item");
		addItensFormulario();
	}

	@Override
	public void addItensFormulario() {
		itemTipo = new ItemComboBoxFormulario("Tipo do Item");
		itemCodigo = new ItemTextFormulario("Codigo do Item");
		itemDescricao = new ItemTextFormulario("Descricao do Item");
		itemPreco = new ItemTextFormulario("Preco do Item");
		itemCategoria = new ItemComboBoxFormulario("Categoria do Item");
		
		itemTipo.getCbbCampo().setModel(new DefaultComboBoxModel<Object>(ETipoItem.values()));
		
		for (String item : MainController.getCatalogoControler().getListaNomeCategorias()) {
			getItemCategoria().getCbbCampo().addItem(item);
		}
		
		this.getPnlFormulario().add(itemTipo);
		this.getPnlFormulario().add(itemCodigo);
		this.getPnlFormulario().add(itemDescricao);
		this.getPnlFormulario().add(itemPreco);
		this.getPnlFormulario().add(itemCategoria);
	}

	@Override
	public void armazenarFormulario() {
		ETipoItem campoTipo = (ETipoItem) getItemTipo().getCbbCampo().getSelectedItem();
		Long campoCodigo = Long.parseLong(getItemCodigo().getTxfCampo().getText());
		String campoDescricao = getItemDescricao().getTxfCampo().getText();
		double campoPreco = Double.parseDouble(getItemPreco().getTxfCampo().getText());	
		String campoCategoria = (String) getItemCategoria().getCbbCampo().getSelectedItem();
		
		MainController.getCatalogoControler()
				.addItem(campoCategoria, campoCodigo, campoTipo, campoDescricao, campoPreco);
		
		limparFormulario();
	}
	
	@Override
	public void limparFormulario() {
		itemCodigo.getTxfCampo().setText("");
		itemDescricao.getTxfCampo().setText("");
		itemPreco.getTxfCampo().setText("");
	}

	public ItemComboBoxFormulario getItemTipo() {
		return itemTipo;
	}

	public ItemTextFormulario getItemCodigo() {
		return itemCodigo;
	}

	public ItemTextFormulario getItemDescricao() {
		return itemDescricao;
	}

	public ItemTextFormulario getItemPreco() {
		return itemPreco;
	}

	public ItemComboBoxFormulario getItemCategoria() {
		return itemCategoria;
	}
	
}
