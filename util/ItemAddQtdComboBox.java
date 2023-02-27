package util;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ItemAddQtdComboBox extends ItemComboBoxFormulario {

	private static final long serialVersionUID = 4818871826581127672L;
	private JLabel lblQtde;
	private JTextField txfQtde;
	private JButton btnAddQtde;

	public ItemAddQtdComboBox(String lblNome) {
		super(lblNome);
		addNovosComponentes();
	}
	
	public void addNovosComponentes() {
		lblQtde = new JLabel();
		lblQtde.setText("Qtde");
		
		txfQtde = new JTextField();
		txfQtde.setColumns(5);
		
		btnAddQtde = new JButton();
		btnAddQtde.setText("Add");
		
		add(lblQtde);
		add(txfQtde);
		add(btnAddQtde);
	}

	public JLabel getLblQtde() {
		return lblQtde;
	}

	public JTextField getTxfQtde() {
		return txfQtde;
	}

	public JButton getBtnAddQtde() {
		return btnAddQtde;
	}
	
}
