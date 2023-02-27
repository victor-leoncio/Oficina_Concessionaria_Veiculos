package util;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ItemComboBoxFormulario extends JPanel {

	private static final long serialVersionUID = -8466692961075875667L;
	JLabel lblNome;
	JComboBox<Object> cbbCampo;
	
	public ItemComboBoxFormulario(String lblNome) {
		setBorder(null);
		
		this.lblNome = new JLabel(lblNome);
		this.cbbCampo = new JComboBox<>();
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		
		add(this.lblNome);
		add(cbbCampo);
	}

	public JLabel getLblNome() {
		return lblNome;
	}

	public void setLblNome(String lblNome) {
		this.lblNome.setText(lblNome);
	}

	public JComboBox<Object> getCbbCampo() {
		return cbbCampo;
	}
	
}
