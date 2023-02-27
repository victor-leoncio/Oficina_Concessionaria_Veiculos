package view;

import controller.MainController;
import util.ItemTextFormulario;

public class FuncionarioFormularioView extends AbstractFormularioView {

	private static final long serialVersionUID = 5871334975864963111L;

	private ItemTextFormulario itemFuncionarioCpf;
	private ItemTextFormulario itemFuncionarioNome;
	private ItemTextFormulario itemFuncionarioTelefone;
	private ItemTextFormulario itemFuncionarioEmail;
	private ItemTextFormulario itemFuncionarioMatricula;
	
	public FuncionarioFormularioView() {
		super();
		this.getLblTituloTopo().setText("< ADICIONAR FUNCIONARIO >");
		setTitle("Adicionar Funcionario");
		addItensFormulario();
	}

	@Override
	public void addItensFormulario() {
		itemFuncionarioCpf = new ItemTextFormulario("CPF do Funcionario");
		itemFuncionarioNome = new ItemTextFormulario("Nome do Funcionario");
		itemFuncionarioTelefone = new ItemTextFormulario("Tel. do Funcionario");
		itemFuncionarioEmail = new ItemTextFormulario("Email do Funcionario");
		itemFuncionarioMatricula = new ItemTextFormulario("Matricula do Funcionario");
		
		this.getPnlFormulario().add(itemFuncionarioCpf);
		this.getPnlFormulario().add(itemFuncionarioNome);
		this.getPnlFormulario().add(itemFuncionarioTelefone);
		this.getPnlFormulario().add(itemFuncionarioEmail);
		this.getPnlFormulario().add(itemFuncionarioMatricula);
	}

	@Override
	public void limparFormulario() {
		itemFuncionarioCpf.getTxfCampo().setText("");
		itemFuncionarioNome.getTxfCampo().setText("");
		itemFuncionarioTelefone.getTxfCampo().setText("");
		itemFuncionarioEmail.getTxfCampo().setText("");
		itemFuncionarioMatricula.getTxfCampo().setText("");
	}

	@Override
	public void armazenarFormulario() {
		long campoCpf = Long.parseLong(getItemFuncionarioCpf().getTxfCampo().getText());
		String campoNome = getItemFuncionarioNome().getTxfCampo().getText();
		long campoTel = Long.parseLong(getItemFuncionarioTelefone().getTxfCampo().getText());
		String campoEmail = getItemFuncionarioEmail().getTxfCampo().getText();
		int campoMatricula = Integer.parseInt(getItemFuncionarioMatricula().getTxfCampo().getText());

		MainController.getPessoaController()
				.addFuncionario(campoCpf, campoNome, campoTel, campoEmail, campoMatricula);
		
		limparFormulario();
	}

	public ItemTextFormulario getItemFuncionarioCpf() {
		return itemFuncionarioCpf;
	}

	public ItemTextFormulario getItemFuncionarioNome() {
		return itemFuncionarioNome;
	}

	public ItemTextFormulario getItemFuncionarioTelefone() {
		return itemFuncionarioTelefone;
	}

	public ItemTextFormulario getItemFuncionarioEmail() {
		return itemFuncionarioEmail;
	}

	public ItemTextFormulario getItemFuncionarioMatricula() {
		return itemFuncionarioMatricula;
	}

}
