package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.MainController;

public abstract class AbstractListagemView extends JFrame implements InterfaceTelaView {

	private static final long serialVersionUID = 6434441096603404828L;
	private JPanel pnlPrincipal;
	private JLabel lblTituloTopo;
	private JPanel pnlInformacoes;
	private JTabbedPane tbpPainel;
	private JPanel pnlOpcaoTabela;
	private JPanel pnlInternoOpcaoTabela;
	private JButton btnRemover;
	private JButton btnEditar;
	private JPanel tabInformacao;
	private JTextArea txtInformacao;
	private JPanel pnlOpcoes;
	private JButton btnAtualizarDados;
	private JButton btnSair;
	private JScrollPane sclTexto;
	private JPanel pnlTabela;
	private JScrollPane sclTabela;
	private JTable tblInformacao;
	private JButton btnAdicionar;

	public AbstractListagemView() {
		inicializarComponentes();
	}
	
	@Override
	public void inicializarComponentes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		pnlPrincipal = new JPanel();
		pnlPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		pnlPrincipal.setLayout(new BorderLayout(0, 0));
		setContentPane(pnlPrincipal);
		
		lblTituloTopo = new JLabel("< Titulo da Operacao >");
		lblTituloTopo.setHorizontalAlignment(SwingConstants.CENTER);
		
		pnlInformacoes = new JPanel();
		pnlInformacoes.setBorder(new EmptyBorder(50, 0, 0, 0));
		pnlInformacoes.setLayout(new BorderLayout(0, 20));
		
		tbpPainel = new JTabbedPane(JTabbedPane.TOP);
		
		tabInformacao = new JPanel();
		tabInformacao.setLayout(new BorderLayout(0, 0));
		
		txtInformacao = new JTextArea();
		txtInformacao.setEditable(false);
		
		pnlOpcoes = new JPanel();
		pnlOpcoes.setBorder(new EmptyBorder(10, 0, 0, 0));
			
		btnAtualizarDados = new JButton("Atualizar Dados");
		btnSair = new JButton("Sair");
		
		sclTexto = new JScrollPane(txtInformacao);
		
		pnlInformacoes.add(tbpPainel, BorderLayout.CENTER);
		
		pnlTabela = new JPanel();
		tbpPainel.addTab("Formato Tabela", null, pnlTabela, null);
		pnlTabela.setLayout(new BorderLayout(0, 0));
		tblInformacao = new JTable();
		tblInformacao.getTableHeader().setReorderingAllowed(false);
		tblInformacao.setDefaultEditor(Object.class, null);
		//tblInformacao.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		sclTabela = new JScrollPane(tblInformacao);
		pnlTabela.add(sclTabela);
		
		pnlOpcaoTabela = new JPanel();
		pnlTabela.add(pnlOpcaoTabela, BorderLayout.EAST);
		pnlOpcaoTabela.setLayout(new BorderLayout(0, 0));
		
		pnlInternoOpcaoTabela = new JPanel();
		pnlInternoOpcaoTabela.setLayout(new GridLayout(0, 1, 0, 5));
		
		btnRemover = new JButton("Remover -");
		btnEditar = new JButton("Editar");
		pnlOpcaoTabela.add(pnlInternoOpcaoTabela, BorderLayout.NORTH);
		pnlInternoOpcaoTabela.add(btnRemover);
		pnlInternoOpcaoTabela.add(btnEditar);
		
		btnAdicionar = new JButton("Adicionar +");
		pnlOpcaoTabela.add(btnAdicionar, BorderLayout.SOUTH);
		tbpPainel.addTab("Formato Texto", null, tabInformacao, null);
		tabInformacao.add(sclTexto, BorderLayout.CENTER);
		
		pnlOpcoes.add(btnAtualizarDados);
		pnlOpcoes.add(btnSair);
		pnlPrincipal.add(lblTituloTopo, BorderLayout.NORTH);
		pnlPrincipal.add(pnlInformacoes, BorderLayout.CENTER);
		pnlPrincipal.add(pnlOpcoes, BorderLayout.SOUTH);

		btnListeners();
	}
	
	@Override
	public void btnListeners() {
		getBtnAtualizarDados().addActionListener(e -> listarDados());
		getBtnSair().addActionListener(e -> fecharJanela());
		getBtnRemover().addActionListener(e -> aplicarRemocao());
		getBtnEditar().addActionListener(e -> aplicarAlteracao());
	}
	
	@Override
	public void fecharJanela() {
		this.setVisible(false);
	}
	
	public abstract void listarDados();
	
	public abstract void removerItem();
	
	public abstract void editarItem();
	
	public void aplicarRemocao() {
		removerItem();
		MainController.save();
	}
	
	public void aplicarAlteracao() {
		editarItem();
		MainController.save();
	}
	
	public JLabel getLblTituloTopo() {
		return lblTituloTopo;
	}

	public void setLblTituloTopo(String lblTituloTopo) {
		this.lblTituloTopo.setText(lblTituloTopo);
	}

	public JTextArea getTxtInformacao() {
		return txtInformacao;
	}

	public void setTxtInformacao(String txtInformacao) {
		this.txtInformacao.setText(txtInformacao);
	}

	public JPanel getPnlPrincipal() {
		return pnlPrincipal;
	}

	public JPanel getPnlInformacoes() {
		return pnlInformacoes;
	}

	public JTabbedPane getTbpPainel() {
		return tbpPainel;
	}

	public JPanel getPnlOpcaoTabela() {
		return pnlOpcaoTabela;
	}

	public JPanel getPnlInternoOpcaoTabela() {
		return pnlInternoOpcaoTabela;
	}

	public JPanel getTabTexto() {
		return tabInformacao;
	}

	public JPanel getPnlOpcoes() {
		return pnlOpcoes;
	}

	public JButton getBtnRemover() {
		return btnRemover;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public JButton getBtnAdicionar() {
		return btnAdicionar;
	}

	public JButton getBtnAtualizarDados() {
		return btnAtualizarDados;
	}

	public JButton getBtnSair() {
		return btnSair;
	}
	
	public JPanel getTabInformacao() {
		return tabInformacao;
	}

	public JScrollPane getSclTexto() {
		return sclTexto;
	}

	public JPanel getPnlTabela() {
		return pnlTabela;
	}

	public JScrollPane getSclTabela() {
		return sclTabela;
	}

	public JTable getTblInformacao() {
		return tblInformacao;
	}
	
}