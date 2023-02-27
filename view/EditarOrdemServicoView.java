package view;

import controller.MainController;
import util.ItemTextFormulario;

public class EditarOrdemServicoView extends OrdemServicoFormularioView {

	private static final long serialVersionUID = -7569812339844478668L;
	private ItemTextFormulario itemOSId;

	public EditarOrdemServicoView(String id) {
		super();
		getBtnAdd().setText("Atualizar");
		this.getLblTituloTopo().setText("< EDITAR ORDEM DE SERVICO >");
		setTitle("Editar Ordem de Servico");
		
		itemOSId = new ItemTextFormulario("ID da OS");
		getPnlFormulario().add(itemOSId);
		
		preencherFormulario(id);
	}

	public void preencherFormulario(String id) {
		getItemOSId().getTxfCampo().setEditable(false);
		getItemOSId().getTxfCampo()
			.setText(MainController.getOrdemServicoController()
			.getOS(id).getId());
		
		getItemOSDescricao().getTxfCampo()
			.setText(MainController.getOrdemServicoController()
			.getOS(id).getDescricao());
		
		getItemOSKmAtual().getTxfCampo()
			.setText(String.valueOf(MainController.getOrdemServicoController()
			.getOS(id).getKmAtual()));

		getItemOSVeiculo().getCbbCampo().setEnabled(false);
		getItemOSVeiculo().getCbbCampo().removeAllItems();
		getItemOSVeiculo().getCbbCampo()
			.addItem(MainController.getOrdemServicoController()
			.getOS(id).getVeiculo().getPlaca());
		
		getItemOSFuncionario().getCbbCampo().removeAllItems();
		getItemOSFuncionario().getCbbCampo().setEnabled(false);
		getItemOSFuncionario().getCbbCampo()
			.addItem(MainController.getOrdemServicoController().getOS(id).getConsultor().getCpf());
	}
	
	@Override
	public void armazenarFormulario() {
		String campoDescricao = getItemOSDescricao().getTxfCampo().getText();
		String campoID = getItemOSId().getTxfCampo().getText();
		int campoKmAtual = Integer.parseInt(getItemOSKmAtual().getTxfCampo().getText());
		
		MainController.getOrdemServicoController().getOS(campoID).setDescricao(campoDescricao);
		MainController.getOrdemServicoController().getOS(campoID).setKmAtual(campoKmAtual);
		
		limparFormulario();
	}

	public ItemTextFormulario getItemOSId() {
		return itemOSId;
	}

}
