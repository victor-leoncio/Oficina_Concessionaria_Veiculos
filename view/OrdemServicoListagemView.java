package view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import controller.MainController;
import model.OrdemServico;

public class OrdemServicoListagemView extends AbstractListagemFiltroView {

	private static final long serialVersionUID = -1056469220556665964L;

	public OrdemServicoListagemView() {
		super();
		this.getLblTituloTopo().setText("< LISTAR ORDEM DE SERVICO >");
		setTitle("Listar Ordem de Servico");
		getCbbFiltro().setModel(new DefaultComboBoxModel<Object>(
				new String[] {"Todos", "Abertos", "Fechados"}));;
		listarDados();
	}

	@Override
	public void listarDados() {
		getTxtInformacao().setText(MainController.getOrdemServicoController().infoTodosOs());
		gerarTabela();
	}

	@Override
	public void removerItem() {
		MainController.getOrdemServicoController()
			.removerOS((String) getTblInformacao()
			.getValueAt(getTblInformacao().getSelectedRow(), 1));
		
		listarDados();
	}

	@Override
	public void editarItem() {
		EditarOrdemServicoView editar = new EditarOrdemServicoView((String) getTblInformacao()
				.getValueAt(getTblInformacao()
				.getSelectedRow(), 1));
		
		editar.setVisible(true);
	}
	
	public void gerarTabela() {
		DefaultTableModel modelo = new DefaultTableModel();
		int cnt = 0;
		
		modelo.addColumn("Nº");
		modelo.addColumn("ID");
		modelo.addColumn("Data");
		modelo.addColumn("Descricao");
		modelo.addColumn("Km Atual");
		modelo.addColumn("Cliente");
		modelo.addColumn("Veiculo");
		modelo.addColumn("Consultor");
		modelo.addColumn("Valor Total");
		modelo.addColumn("Valor Final");
		
		for (OrdemServico os : MainController.getOrdemServicoController().getListaOS()) {
			modelo.addRow(new Object[]{++cnt, os.getId(), os.getData(), os.getDescricao(), 
					os.getKmAtual(), os.getCliente().getCpf(), os.getVeiculo().getPlaca(),
					os.getConsultor().getCpf(), os.getTotalPecas() + os.getTotalServicos(),
					os.getTotalOS()});
		}
		
		getTblInformacao().setModel(modelo);
	}
}
