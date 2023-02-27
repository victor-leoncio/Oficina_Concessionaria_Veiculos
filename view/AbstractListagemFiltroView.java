package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class AbstractListagemFiltroView extends AbstractListagemView {

	private static final long serialVersionUID = -2392014798820620182L;
	private JPanel pnlFiltro = new JPanel();
	private JComboBox<Object> cbbFiltro = new JComboBox<>();
	private JButton btnListar = new JButton("Listar");
	private JLabel lblFiltro = new JLabel("Filtro");
	
	public AbstractListagemFiltroView() {
		super();
		addFiltro();
	}
	
	public void addFiltro() {
		getPnlFiltro().setLayout(new BorderLayout(40, 0));
		getPnlFiltro().add(getLblFiltro(), BorderLayout.WEST);
		getPnlFiltro().add(getCbbFiltro(), BorderLayout.CENTER);
		getPnlFiltro().add(getBtnListar(), BorderLayout.EAST);

		getPnlInformacoes().add(getPnlFiltro(), BorderLayout.NORTH);
	}
	
	public JPanel getPnlFiltro() {
		return pnlFiltro;
	}

	public JComboBox<Object> getCbbFiltro() {
		return cbbFiltro;
	}

	public JButton getBtnListar() {
		return btnListar;
	}

	public JLabel getLblFiltro() {
		return lblFiltro;
	}
	
}
