package view;

import controller.MainController;

public class EditarVeiculoView extends VeiculoFormularioView {

	private static final long serialVersionUID = -4946327579701075009L;

	public EditarVeiculoView(String placa) {
		getBtnAdd().setText("Atualizar");
		this.getLblTituloTopo().setText("< EDITAR VEICULO >");
		setTitle("Editar Veiculo");
		preencherFormulario(placa);
	}
	
	public void preencherFormulario(String placa) {
		getItemVeiculoPlaca().getTxfCampo().setEditable(false);
		getItemVeiculoPlaca().getTxfCampo()
			.setText(MainController.getVeiculoController()
			.getVeiculo(placa).getPlaca());
		
		getItemVeiculoModelo().getTxfCampo()
		.setText(MainController.getVeiculoController()
		.getVeiculo(placa).getModelo());
		
		getItemVeiculoCor().getTxfCampo()
		.setText(MainController.getVeiculoController()
		.getVeiculo(placa).getCor());
		
		getItemVeiculoAno().getTxfCampo()
		.setText(String.valueOf(MainController.getVeiculoController()
		.getVeiculo(placa).getAno()));
	}
	
	@Override
	public void limparFormulario() {
		getItemVeiculoModelo().getTxfCampo().setText("");
		getItemVeiculoAno().getTxfCampo().setText("");
	}

}
