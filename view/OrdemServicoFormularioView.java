package view;

import controller.MainController;
import util.ItemComboBoxFormulario;
import util.ItemTextFormulario;

public class OrdemServicoFormularioView extends AbstractFormularioView {

	private static final long serialVersionUID = 7342769086491795604L;
	private ItemTextFormulario itemOSDescricao;
	private ItemComboBoxFormulario itemOSVeiculo;
	private ItemTextFormulario itemOSKmAtual;
	private ItemComboBoxFormulario itemOSFuncionario;
	
	public OrdemServicoFormularioView() {
		super();
		this.getLblTituloTopo().setText("< ADICIONAR ORDEM DE SERVICO >");
		setTitle("Adicionar Ordem de Servico");
		addItensFormulario();
	}

	@Override
	public void addItensFormulario() {
		itemOSDescricao = new ItemTextFormulario("Descricao da OS");
		itemOSVeiculo = new ItemComboBoxFormulario("Veiculo da OS");
		itemOSKmAtual = new ItemTextFormulario("Km Atual do Veiculo");
		itemOSFuncionario = new ItemComboBoxFormulario("Funcionario");
		
		for (String placa : MainController.getVeiculoController().getListaPlacasVeiculos()) {
			getItemOSVeiculo().getCbbCampo().addItem(placa);
		}
		
		for (int matricula : MainController.getPessoaController().getListaMatriculaFuncionario()) {
			getItemOSFuncionario().getCbbCampo().addItem(matricula);
		}
		
		this.getPnlFormulario().add(itemOSDescricao);
		this.getPnlFormulario().add(itemOSVeiculo);
		this.getPnlFormulario().add(itemOSKmAtual);
		this.getPnlFormulario().add(itemOSFuncionario);
	}

	@Override
	public void armazenarFormulario() {
		String campoDescricao = getItemOSDescricao().getTxfCampo().getText();
		String campoPlaca = (String) getItemOSVeiculo().getCbbCampo().getSelectedItem();
		int campoKmAtual = Integer.parseInt(getItemOSKmAtual().getTxfCampo().getText());
		int campoMatricula =  (int) getItemOSFuncionario().getCbbCampo().getSelectedItem();
		
		MainController.getOrdemServicoController()
			.addOS(campoDescricao, campoPlaca, campoKmAtual, campoMatricula);
		
		limparFormulario();
	}
	
	@Override
	public void limparFormulario() {
		itemOSDescricao.getTxfCampo().setText("");
		itemOSKmAtual.getTxfCampo().setText("");
	}

	public ItemTextFormulario getItemOSDescricao() {
		return itemOSDescricao;
	}

	public ItemComboBoxFormulario getItemOSVeiculo() {
		return itemOSVeiculo;
	}

	public ItemTextFormulario getItemOSKmAtual() {
		return itemOSKmAtual;
	}

	public ItemComboBoxFormulario getItemOSFuncionario() {
		return itemOSFuncionario;
	}

}
