package view;

import javax.swing.table.DefaultTableModel;

import controller.MainController;
import model.IFuncionario;
import model.IPessoa;

public class FuncionarioListagemView extends AbstractListagemView {

	private static final long serialVersionUID = -3656027609796006822L;

	public FuncionarioListagemView() {
		super();
		this.getLblTituloTopo().setText("< LISTAR FUNCIONARIO >");
		setTitle("Listar Funcionario");
		listarDados();
	}

	@Override
	public void listarDados() {
		getTxtInformacao().setText(MainController.getPessoaController().infoTodosFuncionarios());
		gerarTabela();
	}

	@Override
	public void removerItem() {
		MainController.getPessoaController()
			.removerFuncionario((int) getTblInformacao()
			.getValueAt(getTblInformacao().getSelectedRow(), 1));
		
		listarDados();
	}

	@Override
	public void editarItem() {
		EditarFuncionarioView editar = new EditarFuncionarioView((int) getTblInformacao()
				.getValueAt(getTblInformacao().getSelectedRow(), 1));
		
		editar.setVisible(true);
	}

	public void gerarTabela() {
		DefaultTableModel modelo = new DefaultTableModel();
		int cnt = 0;
		
		modelo.addColumn("Nº");
		modelo.addColumn("Matricula");
		modelo.addColumn("CPF");
		modelo.addColumn("Nome");
		modelo.addColumn("Telefone");
		modelo.addColumn("Email");
		
		for (IPessoa funcionario : MainController.getPessoaController().getListaFuncionarios()) {
			modelo.addRow(new Object[]{++cnt, ((IFuncionario)funcionario).getMatricula(),
					funcionario.getCpf(), funcionario.getNome(), 
					funcionario.getTelefone(), funcionario.getEmail()});
		}
		
		getTblInformacao().setModel(modelo);
	}
}
