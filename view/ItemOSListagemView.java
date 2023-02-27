package view;

import javax.swing.table.DefaultTableModel;

import controller.MainController;
import model.ItemOS;

public class ItemOSListagemView extends AbstractListagemFiltroView {

	private static final long serialVersionUID = 4222076127523479477L;

	public ItemOSListagemView() {
		super();
		getLblTituloTopo().setText("< LISTAR ITEM DA ORDEM DE SERVICO >");
		setTitle("Listar Item da Ordem de Servico");
		
		//getBtnEditar().setEnabled(false);
		
		getBtnAdicionar().addActionListener(e -> new ItemOSFormularioView(
				(String) getCbbFiltro().getSelectedItem()).setVisible(true));
		
		getCbbFiltro().addActionListener(e -> gerarTabela());
		
		gerarComboBox();
		listarDados();
	} 

	@Override
	public void listarDados() {
		getTxtInformacao().setText(MainController.getOrdemServicoController()
			.infoItensOS((String) getCbbFiltro().getSelectedItem()));
		gerarTabela();
	}

	@Override
	public void removerItem() {
		MainController.getOrdemServicoController().getOS((String) getCbbFiltro()
			.getSelectedItem()).removeItem(getTblInformacao().getSelectedRow());
		
		listarDados();
	}

	@Override
	public void editarItem() {
		if (MainController.getOrdemServicoController()
				.getOS((String) getCbbFiltro().getSelectedItem())
				.getPagamento() != null) {
			
			System.out.println("Sim!");
			
		} else {
			System.out.println("Não!");
		}
	}
	
	public void gerarComboBox() {
		for (String id : MainController.getOrdemServicoController().getListaIdOs()) {
			getCbbFiltro().addItem(id);
		}
	}
	
	public void gerarTabela() {
		DefaultTableModel modelo = new DefaultTableModel();
		String id = (String) getCbbFiltro().getSelectedItem();
		int cnt = 0;
		
		modelo.addColumn("Nº");
		modelo.addColumn("Codigo");
		modelo.addColumn("Tipo");
		modelo.addColumn("Qtde");
		modelo.addColumn("Preco Unidade");
		modelo.addColumn("Preco Total");
		
		for (ItemOS item : MainController.getOrdemServicoController().getOS(id).getItens()) {
			modelo.addRow(new Object[]{++cnt, item.getItem().getCodigo(), item.getItem().getTipo(), 
					item.getQtde(), item.getPreco(), item.getTotalItem()});
		}
		
		getTblInformacao().setModel(modelo);
	}

}
