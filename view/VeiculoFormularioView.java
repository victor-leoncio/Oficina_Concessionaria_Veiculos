package view;

import controller.MainController;
import util.ItemComboBoxFormulario;
import util.ItemTextFormulario;

public class VeiculoFormularioView extends AbstractFormularioView {

	private static final long serialVersionUID = -4926132921539129095L;
	private ItemTextFormulario itemVeiculoPlaca;
	private ItemTextFormulario itemVeiculoModelo;
	private ItemTextFormulario itemVeiculoAno;
	private ItemTextFormulario itemVeiculoCor;
	private ItemComboBoxFormulario itemVeiculoProprietario;

	public VeiculoFormularioView() {
		super();
		this.getLblTituloTopo().setText("< ADICIONAR VEICULO >");
		setTitle("Adicionar Veiculo");
		addItensFormulario();
	}

	@Override
	public void addItensFormulario() {
		itemVeiculoPlaca = new ItemTextFormulario("Placa do Veiculo");
		itemVeiculoModelo = new ItemTextFormulario("Modelo do Veiculo");
		itemVeiculoAno = new ItemTextFormulario("Ano do Veiculo");
		itemVeiculoCor = new ItemTextFormulario("Cor do Veiculo");
		itemVeiculoProprietario = new ItemComboBoxFormulario("Proprietario do Veiculo");
		
		for (Long item : MainController.getPessoaController().getListaCpfClientes()) {
			getItemVeiculoProprietario().getCbbCampo().addItem(item);
		}
		
		this.getPnlFormulario().add(itemVeiculoPlaca);
		this.getPnlFormulario().add(itemVeiculoModelo);
		this.getPnlFormulario().add(itemVeiculoAno);
		this.getPnlFormulario().add(itemVeiculoCor);
		this.getPnlFormulario().add(itemVeiculoProprietario);
	}
	
	@Override
	public void armazenarFormulario() {
		String campoPlaca = getItemVeiculoPlaca().getTxfCampo().getText();
		String campoModelo = getItemVeiculoModelo().getTxfCampo().getText();
		int campoAno = Integer.parseInt(getItemVeiculoAno().getTxfCampo().getText());
		String campoCor = getItemVeiculoCor().getTxfCampo().getText();
		Long campoProprietario = (Long) getItemVeiculoProprietario().getCbbCampo().getSelectedItem();
		
		MainController.getVeiculoController().
				addVeiculo(campoPlaca, campoModelo, campoAno, campoCor, campoProprietario);
		
		limparFormulario();
	}

	@Override
	public void limparFormulario() {
		itemVeiculoPlaca.getTxfCampo().setText("");
		itemVeiculoModelo.getTxfCampo().setText("");
		itemVeiculoAno.getTxfCampo().setText("");
		itemVeiculoCor.getTxfCampo().setText("");
	}

	public ItemTextFormulario getItemVeiculoPlaca() {
		return itemVeiculoPlaca;
	}

	public ItemTextFormulario getItemVeiculoModelo() {
		return itemVeiculoModelo;
	}

	public ItemTextFormulario getItemVeiculoAno() {
		return itemVeiculoAno;
	}

	public ItemTextFormulario getItemVeiculoCor() {
		return itemVeiculoCor;
	}

	public ItemComboBoxFormulario getItemVeiculoProprietario() {
		return itemVeiculoProprietario;
	}

}
