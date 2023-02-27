package view;

import java.util.Date;

import javax.swing.DefaultComboBoxModel;

import controller.MainController;
import model.ETipoPagamento;
import util.ItemComboBoxFormulario;
import util.ItemTextFormulario;

public class PagamentoOSView extends AbstractFormularioView {

	private static final long serialVersionUID = -7125603347704316040L;
	private ItemComboBoxFormulario itemIdOS;
	private ItemComboBoxFormulario itemTipoPagamento;
	private ItemTextFormulario itemPrecoOS;

	public PagamentoOSView() {
		super();
		this.getLblTituloTopo().setText("< Pagamento OS >");
		this.setTitle("Pagamento OS");
		this.addItensFormulario();
		itemIdOS.getCbbCampo().addActionListener(e -> carregarValor());
	}

	@Override
	public void armazenarFormulario() {
		String campoID = (String) getItemIdOS().getCbbCampo().getSelectedItem();
		ETipoPagamento campoPagamento = (ETipoPagamento) getItemTipoPagamento().getCbbCampo().getSelectedItem();
		double campoPrecp = Double.parseDouble(getItemPrecoOS().getTxfCampo().getText());
		
		MainController.getOrdemServicoController().getOS(campoID)
			.addPagamento(campoPagamento, new Date(), campoPrecp);
	}

	@Override
	public void addItensFormulario() {
		itemIdOS = new ItemComboBoxFormulario("ID da OS");
		itemTipoPagamento = new ItemComboBoxFormulario("Forma de Pagamento");
		itemPrecoOS = new ItemTextFormulario("Preco Final");
		
		for (String id : MainController.getOrdemServicoController().getListaIdOs()) {
			if(MainController.getOrdemServicoController().getOS(id).getPagamento() == null) {
				itemIdOS.getCbbCampo().addItem(id);
			}
		}
		
		itemTipoPagamento.getCbbCampo().setModel(new DefaultComboBoxModel<Object>(ETipoPagamento.values()));
		
		itemPrecoOS.getTxfCampo().setEditable(false);
		itemPrecoOS.getTxfCampo().setText(String.valueOf( MainController.getOrdemServicoController()
				.getOS((String) getItemIdOS().getCbbCampo().getSelectedItem()).getTotalOS()));
		
		getPnlFormulario().add(itemIdOS);
		getPnlFormulario().add(itemTipoPagamento);
		getPnlFormulario().add(itemPrecoOS);
	}

	@Override
	public void limparFormulario() {
		
	}

	public void carregarValor() {
		getItemPrecoOS().getTxfCampo().setText(String.valueOf( MainController.getOrdemServicoController()
				.getOS((String) getItemIdOS().getCbbCampo().getSelectedItem()).getTotalOS()));
	}
	
	public ItemComboBoxFormulario getItemIdOS() {
		return itemIdOS;
	}

	public ItemComboBoxFormulario getItemTipoPagamento() {
		return itemTipoPagamento;
	}

	public ItemTextFormulario getItemPrecoOS() {
		return itemPrecoOS;
	}

}