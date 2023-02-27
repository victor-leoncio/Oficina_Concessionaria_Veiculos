package view;

import javax.swing.table.DefaultTableModel;

import controller.MainController;

public class CategoriaListagemView extends AbstractListagemFiltroView {

	private static final long serialVersionUID = -8677666736075210553L;

	public CategoriaListagemView() {
		super();
		this.getLblTituloTopo().setText("< LISTAR CATEGORIA >");
		setTitle("Listar Categoria");
		getBtnEditar().setEnabled(false);
		listarDados();
	}

	@Override
	public void listarDados() {
		getTxtInformacao().setText(MainController.getCatalogoControler().infoTodasCategorias());
		gerarTabela();
	}

	@Override
	public void removerItem() {
		MainController.getCatalogoControler()
			.removerCategoria((String) getTblInformacao().getValueAt(getTblInformacao().getSelectedRow(), 1));
		listarDados();
	}

	@Override
	public void editarItem() {
		listarDados();
	}
	
	public void gerarTabela() {
		DefaultTableModel modelo = new DefaultTableModel();
		int cnt = 0;
		
		modelo.addColumn("Nº");
		modelo.addColumn("Nome");
		
		for (String nome : MainController.getCatalogoControler().getListaNomeCategorias()) {
			modelo.addRow(new Object[]{++cnt, nome});
		}
		
		getTblInformacao().setModel(modelo);
	}

}
