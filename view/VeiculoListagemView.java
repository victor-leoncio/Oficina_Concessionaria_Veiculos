package view;

import javax.swing.table.DefaultTableModel;

import controller.MainController;
import model.IVeiculo;

public class VeiculoListagemView extends AbstractListagemFiltroView {

	private static final long serialVersionUID = -1891897322448675992L;

	public VeiculoListagemView() {
		super();
		this.getLblTituloTopo().setText("< LISTAR VEICULO >");
		setTitle("Listar Veiculo");
		listarDados();
	}

	@Override
	public void listarDados() {
		getTxtInformacao().setText(MainController.getVeiculoController().infoTodosVeiculos());
		gerarTabela();
	}

	@Override
	public void removerItem() {
		MainController.getVeiculoController().removarVeiculos((String) getTblInformacao()
				.getValueAt(getTblInformacao()
				.getSelectedRow(), 1));
		
		listarDados();
	}

	@Override
	public void editarItem() {
		EditarVeiculoView editar = new EditarVeiculoView((String) getTblInformacao()
				.getValueAt(getTblInformacao()
				.getSelectedRow(), 1));
		
		editar.setVisible(true);
	}
	
	public void gerarTabela() {
		DefaultTableModel modelo = new DefaultTableModel();
		int cnt = 0;
		
		modelo.addColumn("Nº");
		modelo.addColumn("Placa");
		modelo.addColumn("Modelo");
		modelo.addColumn("Cor");
		modelo.addColumn("Ano");
		modelo.addColumn("Proprietario");
		
		for (IVeiculo veiculo : MainController.getVeiculoController().getListaVeiculos()) {
			modelo.addRow(new Object[]{++cnt, veiculo.getPlaca(), veiculo.getModelo(), 
					veiculo.getCor(), veiculo.getAno(), veiculo.getProprietario().getCpf()});
		}
		
		getTblInformacao().setModel(modelo);
	}

}
