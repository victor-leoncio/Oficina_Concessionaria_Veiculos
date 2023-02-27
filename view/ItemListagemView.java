package view;

import javax.swing.table.DefaultTableModel;

import controller.MainController;
import model.IItem;

public class ItemListagemView extends AbstractListagemFiltroView {

	private static final long serialVersionUID = 6274703640625446208L;

	public ItemListagemView() {
		super();
		this.getLblTituloTopo().setText("< LISTAR ITEM >");
		setTitle("Listar Item");
		listarDados();
	}

	@Override
	public void listarDados() {
		getTxtInformacao().setText(MainController.getCatalogoControler().infoTodosItens());
		gerarTabela();
	}

	@Override
	public void removerItem() {
		MainController.getCatalogoControler()
			.removerItem((Long) getTblInformacao()
			.getValueAt(getTblInformacao().getSelectedRow(), 1));
		
		listarDados();
	}

	@Override
	public void editarItem() {
		EditarItemView editar = new EditarItemView((Long) getTblInformacao()
				.getValueAt(getTblInformacao()
				.getSelectedRow(), 1));
		
		editar.setVisible(true);
	}

	public void gerarTabela() {
		DefaultTableModel modelo = new DefaultTableModel();
		int cnt = 0;
		
		modelo.addColumn("Nº");
		modelo.addColumn("Codigo");
		modelo.addColumn("Tipo");
		modelo.addColumn("Descricao");
		modelo.addColumn("Preco");
		
		for (IItem item : MainController.getCatalogoControler().getListaItens()) {
			modelo.addRow(new Object[]{++cnt, item.getCodigo(), item.getTipo(), 
					item.getDescricao(), item.getPreco()});
		}
		
		getTblInformacao().setModel(modelo);
	}
	
}
