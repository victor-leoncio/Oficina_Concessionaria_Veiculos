package view;

import controller.MainController;

public class EditarFuncionarioView extends FuncionarioFormularioView {

	private static final long serialVersionUID = -7622067967143761934L;

	public EditarFuncionarioView(int matricula) {
		getBtnAdd().setText("Atualizar");
		this.getLblTituloTopo().setText("< EDITAR FUNCIONARIO >");
		setTitle("Editar Funcionario");
		preencherFormulario(matricula);
	}

	public void preencherFormulario(int matricula) {
		getItemFuncionarioCpf().getTxfCampo().setEditable(false);
		getItemFuncionarioCpf().getTxfCampo()
			.setText(String.valueOf(MainController.getPessoaController()
			.getFuncionario(matricula).getCpf()));
		
		getItemFuncionarioNome().getTxfCampo()
		.setText(MainController.getPessoaController()
		.getFuncionario(matricula).getNome());
		
		getItemFuncionarioTelefone().getTxfCampo()
		.setText(String.valueOf(MainController.getPessoaController()
		.getFuncionario(matricula).getTelefone()));
		
		getItemFuncionarioEmail().getTxfCampo()
		.setText(MainController.getPessoaController()
		.getFuncionario(matricula).getEmail());
		
		getItemFuncionarioMatricula().getTxfCampo().setEditable(false);
		getItemFuncionarioMatricula().getTxfCampo()
		.setText(String.valueOf(MainController.getPessoaController()
		.getFuncionario(matricula).getMatricula()));
	}
	
	@Override
	public void limparFormulario() {
		getItemFuncionarioNome().getTxfCampo().setText("");
		getItemFuncionarioTelefone().getTxfCampo().setText("");
		getItemFuncionarioEmail().getTxfCampo().setText("");
	}
	
}
