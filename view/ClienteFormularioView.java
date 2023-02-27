package view;

import javax.swing.DefaultComboBoxModel;

import controller.MainController;
import util.ItemComboBoxFormulario;
import util.ItemTextFormulario;

public class ClienteFormularioView extends AbstractFormularioView {

	private static final long serialVersionUID = -8898207079288729836L;
	private ItemTextFormulario itemClienteCpf;
	private ItemTextFormulario itemClienteNome;
	private ItemTextFormulario itemClienteTelefone;
	private ItemTextFormulario itemClienteEmail;
	private ItemComboBoxFormulario itemClientePremium;
	
	public ClienteFormularioView() {
		super();
		this.getLblTituloTopo().setText("< ADICIONAR CLIENTE >");
		setTitle("Adicionar Cliente");
		this.addItensFormulario();
	}

	@Override
	public void addItensFormulario() {
		itemClienteCpf = new ItemTextFormulario("CPF do Cliente");
		itemClienteNome = new ItemTextFormulario("Nome do Cliente");
		itemClienteTelefone = new ItemTextFormulario("Tel. do Cliente");
		itemClienteEmail = new ItemTextFormulario("Email do Cliente");
		itemClientePremium = new ItemComboBoxFormulario("Platinum");
		itemClientePremium.getCbbCampo().setModel(
				new DefaultComboBoxModel<Object>(new String[] {"False", "True"}));
	
		this.getPnlFormulario().add(itemClienteCpf);
		this.getPnlFormulario().add(itemClienteNome);
		this.getPnlFormulario().add(itemClienteTelefone);
		this.getPnlFormulario().add(itemClienteEmail);
		this.getPnlFormulario().add(itemClienteCpf);
		this.getPnlFormulario().add(itemClientePremium);
	}

	@Override
	public void armazenarFormulario() {
		long campoCpf = Long.parseLong(getItemClienteCpf().getTxfCampo().getText());
		String campoNome = getItemClienteNome().getTxfCampo().getText();
		long campoTel = Long.parseLong(getItemClienteTelefone().getTxfCampo().getText());
		String campoEmail = getItemClienteEmail().getTxfCampo().getText();
		Boolean campoPremium = Boolean.parseBoolean(
				(String) getItemClientePremium().getCbbCampo().getSelectedItem());
		
		
		MainController.getPessoaController()
				.addCliente(campoCpf, campoNome, campoTel, campoEmail, campoPremium);
		
		limparFormulario();
	}
	
	@Override
	public void limparFormulario() {
		itemClienteCpf.getTxfCampo().setText("");
		itemClienteNome.getTxfCampo().setText("");
		itemClienteTelefone.getTxfCampo().setText("");
		itemClienteEmail.getTxfCampo().setText("");
	}

	public ItemTextFormulario getItemClienteCpf() {
		return itemClienteCpf;
	}

	public ItemTextFormulario getItemClienteNome() {
		return itemClienteNome;
	}

	public ItemTextFormulario getItemClienteTelefone() {
		return itemClienteTelefone;
	}

	public ItemTextFormulario getItemClienteEmail() {
		return itemClienteEmail;
	}

	public ItemComboBoxFormulario getItemClientePremium() {
		return itemClientePremium;
	}
	
}
