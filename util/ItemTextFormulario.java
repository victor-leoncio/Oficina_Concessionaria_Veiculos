package util;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class ItemTextFormulario extends JPanel {
	private static final long serialVersionUID = 5190135442524919255L;
	private FlowLayout flowLayout;
	private JLabel lblNome;
	private JTextField txfCampo;

	public ItemTextFormulario(String lblNome) {
		this.lblNome = new JLabel(lblNome);
		txfCampo = new JTextField();
		
	    flowLayout = (FlowLayout) getLayout();
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		txfCampo.setColumns(22);
		
		add(this.lblNome);
		add(this.txfCampo);
	}

	public FlowLayout getFlowLayout() {
		return flowLayout;
	}

	public JLabel getLblNome() {
		return lblNome;
	}

	public void setLblNome(String nome) {
		this.lblNome.setText(nome);
	}

	public JTextField getTxfCampo() {
		return txfCampo;
	}
	
}
