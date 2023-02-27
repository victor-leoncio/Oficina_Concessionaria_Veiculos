package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.MainController;

public abstract class AbstractFormularioView extends JFrame implements InterfaceTelaView {

	private static final long serialVersionUID = -3877110708300742763L;
	private JPanel pnlPrincipal;
	private JLabel lblTituloTopo;
	private JPanel pnlFormulario;
	private JPanel pnlOpcoes;
	private JButton btnAdd;
	private JButton btnLimpar;
	private JButton btnSair;

	public AbstractFormularioView() {
		inicializarComponentes();
	}
	
	@Override
	public void inicializarComponentes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		
		pnlPrincipal = new JPanel();
		pnlPrincipal.setBorder(new EmptyBorder(10, 5, 5, 5));
		pnlPrincipal.setLayout(new BorderLayout(0, 0));
		setContentPane(pnlPrincipal);
		
		lblTituloTopo = new JLabel("< Titulo da Operacao >");
		lblTituloTopo.setBackground(Color.WHITE);
		lblTituloTopo.setHorizontalAlignment(SwingConstants.CENTER);
		
		pnlFormulario = new JPanel();
		pnlFormulario.setBorder(new EmptyBorder(50, 20, 20, 20));
		pnlFormulario.setLayout(new BoxLayout(pnlFormulario, BoxLayout.Y_AXIS));
		
		pnlOpcoes = new JPanel();
		btnAdd = new JButton("Adicionar");
		btnLimpar = new JButton("Limpar");
		btnSair = new JButton("Cancelar");
		
		pnlPrincipal.add(pnlOpcoes, BorderLayout.SOUTH);
		pnlPrincipal.add(lblTituloTopo, BorderLayout.NORTH);
		pnlPrincipal.add(pnlFormulario, BorderLayout.CENTER);
		pnlOpcoes.add(btnAdd);
		pnlOpcoes.add(btnLimpar);
		pnlOpcoes.add(btnSair);
		
		btnListeners();
	}
	
	@Override
	public void btnListeners() {
		btnAdd.addActionListener(e -> cadastrarItem());
		btnLimpar.addActionListener(e -> limparFormulario());
		btnSair.addActionListener(e -> fecharJanela());
	}
	
	@Override
	public void fecharJanela() {
	    this.setVisible(false);;
	}
	
	public void cadastrarItem() {
		this.armazenarFormulario();
		MainController.save();
	}
	
	public abstract void armazenarFormulario();
	
	public abstract void addItensFormulario();
	
	public abstract void limparFormulario();

	public JPanel getPnlPrincipal() {
		return pnlPrincipal;
	}

	public JLabel getLblTituloTopo() {
		return lblTituloTopo;
	}

	public JPanel getPnlFormulario() {
		return pnlFormulario;
	}

	public JPanel getPnlOpcoes() {
		return pnlOpcoes;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}
	
}
