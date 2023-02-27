package view;

import javax.swing.table.DefaultTableModel;

import controller.MainController;
import model.ICliente;
import model.IPessoa;

public class ClienteListagemView extends AbstractListagemView {

	private static final long serialVersionUID = 3797915731779941305L;

	public ClienteListagemView() {
		super();
		this.getLblTituloTopo().setText("< LISTAR CLIENTE >");
		setTitle("Listar Cliente");
		listarDados();
	}

	@Override
	public void listarDados() {
		getTxtInformacao().setText(MainController.getPessoaController().infoTodosClientes());
		gerarTabela();
	}

	@Override
	public void removerItem() {
		MainController.getPessoaController()
			.removerCliente((Long) getTblInformacao()
			.getValueAt(getTblInformacao().getSelectedRow(), 1));
		
		listarDados();
	}

	@Override
	public void editarItem() {
		EditarClienteView editar = new EditarClienteView((Long) getTblInformacao()
				.getValueAt(getTblInformacao().getSelectedRow(), 1));
		
		editar.setVisible(true);
		
		listarDados();;
	}
	
	public void gerarTabela() {
		DefaultTableModel modelo = new DefaultTableModel();
		int cnt = 0;
		
		modelo.addColumn("Nº");
		modelo.addColumn("CPF");
		modelo.addColumn("Nome");
		modelo.addColumn("Telefone");
		modelo.addColumn("Email");
		modelo.addColumn("Premium");
		
		for (IPessoa cliente : MainController.getPessoaController().getListaClientes()) {
			modelo.addRow(new Object[]{++cnt, cliente.getCpf(), cliente.getNome(), 
					cliente.getTelefone(), cliente.getEmail(), ((ICliente)cliente).isPlatinum()});
		}
		
		getTblInformacao().setModel(modelo);
	}

}
