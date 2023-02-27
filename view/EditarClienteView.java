package view;

import controller.MainController;

public class EditarClienteView extends ClienteFormularioView {

	private static final long serialVersionUID = 5267142287663305002L;

	public EditarClienteView(Long cpf) {
		getBtnAdd().setText("Atualizar");
		this.getLblTituloTopo().setText("< EDITAR CLIENTE >");
		setTitle("Editar Cliente");
		preencherFormulario(cpf);
	}

	public void preencherFormulario(Long cpf) {
		getItemClienteCpf().getTxfCampo().setEditable(false);
		getItemClienteCpf().getTxfCampo()
			.setText(String.valueOf(MainController.getPessoaController()
			.getCliente(cpf).getCpf()));
		
		getItemClienteNome().getTxfCampo()
		.setText(MainController.getPessoaController()
		.getCliente(cpf).getNome());
		
		getItemClienteTelefone().getTxfCampo()
		.setText(String.valueOf(MainController.getPessoaController()
		.getCliente(cpf).getTelefone()));
		
		getItemClienteEmail().getTxfCampo()
		.setText(MainController.getPessoaController()
		.getCliente(cpf).getEmail());
	}
	
	@Override
	public void limparFormulario() {
		getItemClienteNome().getTxfCampo().setText("");
		getItemClienteTelefone().getTxfCampo().setText("");
		getItemClienteEmail().getTxfCampo().setText("");
	}
}
