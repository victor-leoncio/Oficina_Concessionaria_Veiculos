package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controller.MainController;

public class MenuView extends JFrame implements InterfaceTelaView {

	private static final long serialVersionUID = 517294119658988912L;
	private JPanel pnlPrincipal;
	private JButton btnAdicionarCliente;
	private JButton btnListarCliente;
	private JButton btnAdicionarFuncionario;
	private JButton btnListarFuncionario;
	private JButton btnAdicionarVeiculo;
	private JButton btnListarVeiculo;
	private JButton btnAdicionarCategoria;
	private JButton btnListarCategoria;
	private JButton btnAdicionarItem;
	private JButton btnListarItem;
	private JButton btnAdicionarOS;
	private JButton btnListarOS;
	private JButton btnAddItensOS;
	private JButton btnSair;
	private JButton btnFinalizarOs;

	public MenuView() {
		inicializarComponentes();
	}

	@Override
	public void inicializarComponentes() {
		// Configurando o painel principal
		setTitle("Oficina da Concessionaria de Veiculos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);

		pnlPrincipal = new JPanel();
		pnlPrincipal.setBorder(new EmptyBorder(10, 40, 10, 40));
		setContentPane(pnlPrincipal);
		pnlPrincipal.setLayout(new BorderLayout(0, 50));

		JLabel lblOperacao = new JLabel("< OPERACOES >");
		lblOperacao.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel pnlOperacoes = new JPanel();
		pnlOperacoes.setBorder(null);
		pnlOperacoes.setLayout(new GridLayout(2, 3, 20, 20));

		JPanel panel = new JPanel();
		btnSair = new JButton("Sair");
		panel.add(btnSair);

		pnlPrincipal.add(pnlOperacoes);
		pnlPrincipal.add(lblOperacao, BorderLayout.NORTH);
		pnlPrincipal.add(panel, BorderLayout.SOUTH);

		// Painel do Cliente
		JPanel pnlCliente = new JPanel();
		JLabel lblCliente = new JLabel("CLIENTE");
		btnAdicionarCliente = new JButton("Adicionar Novo CLiente");
		btnListarCliente = new JButton("Listar Clientes Cadastrados");

		pnlCliente.setBackground(Color.LIGHT_GRAY);
		pnlCliente.setBorder(new EmptyBorder(25, 25, 25, 25));
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		btnAdicionarCliente.setBackground(UIManager.getColor("Button.darkShadow"));
		pnlCliente.setLayout(new GridLayout(0, 1, 0, 0));

		pnlCliente.add(lblCliente);
		pnlCliente.add(btnAdicionarCliente);
		pnlCliente.add(btnListarCliente);

		// Painel do Funcionario
		JPanel pnlFuncionario = new JPanel();

		JLabel lblFuncionario = new JLabel("FUNCIONARIO");
		btnAdicionarFuncionario = new JButton("Adicionar Novo Funcionario");
		btnListarFuncionario = new JButton("Listar Funcionarios Cadastrados");

		pnlFuncionario.setBorder(new EmptyBorder(25, 25, 25, 25));
		pnlFuncionario.setBackground(Color.LIGHT_GRAY);
		pnlFuncionario.setLayout(new GridLayout(0, 1, 0, 0));
		lblFuncionario.setHorizontalAlignment(SwingConstants.CENTER);

		pnlFuncionario.add(lblFuncionario);
		pnlFuncionario.add(btnAdicionarFuncionario);
		pnlFuncionario.add(btnListarFuncionario);

		// Painel do Veiculo
		JPanel pnlVeiculo = new JPanel();

		JLabel lblVeiculo = new JLabel("VEICULO");
		btnAdicionarVeiculo = new JButton("Adicionar Novo Veiculo");
		btnListarVeiculo = new JButton("Listar Veiculos Cadastrados");

		pnlVeiculo.setBorder(new EmptyBorder(25, 25, 25, 25));
		pnlVeiculo.setBackground(Color.LIGHT_GRAY);
		pnlVeiculo.setLayout(new GridLayout(0, 1, 0, 0));
		lblVeiculo.setHorizontalAlignment(SwingConstants.CENTER);

		pnlVeiculo.add(lblVeiculo);
		pnlVeiculo.add(btnAdicionarVeiculo);
		pnlVeiculo.add(btnListarVeiculo);

		// Painel da Categoria
		JPanel pnlCategoria = new JPanel();

		JLabel lblCategoria = new JLabel("CATEGORIA");
		btnAdicionarCategoria = new JButton("Adicionar Nova Categoria");
		btnListarCategoria = new JButton("Listar Categorias Cadastradas");

		pnlCategoria.setBorder(new EmptyBorder(25, 25, 25, 25));
		pnlCategoria.setBackground(Color.LIGHT_GRAY);
		pnlCategoria.setLayout(new GridLayout(0, 1, 0, 0));
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);

		pnlCategoria.add(lblCategoria);
		pnlCategoria.add(btnAdicionarCategoria);
		pnlCategoria.add(btnListarCategoria);

		// Painel do Item
		JPanel pnlItem = new JPanel();
		JLabel lblItem = new JLabel("ITEM");
		btnAdicionarItem = new JButton("Adicionar Novo Item");
		btnListarItem = new JButton("Listar Itens Cadastrados");

		pnlItem.setBorder(new EmptyBorder(25, 25, 25, 25));
		pnlItem.setBackground(Color.LIGHT_GRAY);
		pnlItem.setLayout(new GridLayout(0, 1, 0, 0));
		lblItem.setHorizontalAlignment(SwingConstants.CENTER);

		pnlItem.add(lblItem);
		pnlItem.add(btnAdicionarItem);
		pnlItem.add(btnListarItem);

		// Painel do OS
		JPanel pnlOS = new JPanel();
		JLabel lblOS = new JLabel("ORDEM DE SERVICOS");
		btnAdicionarOS = new JButton("Adicionar Novo OS");
		btnListarOS = new JButton("Listar OS Cadastrados");
		btnAddItensOS = new JButton("Adicionar Itens ao OS");

		pnlOS.setBorder(new EmptyBorder(25, 25, 25, 25));
		pnlOS.setBackground(Color.LIGHT_GRAY);
		pnlOS.setLayout(new GridLayout(0, 1, 0, 0));
		lblOS.setHorizontalAlignment(SwingConstants.CENTER);

		pnlOS.add(lblOS);
		pnlOS.add(btnAdicionarOS);
		pnlOS.add(btnListarOS);
		pnlOS.add(btnAddItensOS);

		// Adicionando no painel operacao
		pnlOperacoes.add(pnlCliente);
		pnlOperacoes.add(pnlFuncionario);
		pnlOperacoes.add(pnlVeiculo);
		pnlOperacoes.add(pnlCategoria);
		pnlOperacoes.add(pnlItem);
		pnlOperacoes.add(pnlOS);
		
		btnFinalizarOs = new JButton("Finalizar OS");
		pnlOS.add(btnFinalizarOs);

		btnListeners();
	}

	@Override
	public void btnListeners() {
		getBtnAdicionarCliente().addActionListener(e -> actionCallView(new ClienteFormularioView()));
		getBtnListarCliente().addActionListener(e -> actionCallView(new ClienteListagemView()));
		getBtnAdicionarFuncionario().addActionListener(e -> actionCallView(new FuncionarioFormularioView()));
		getBtnListarFuncionario().addActionListener(e -> actionCallView(new FuncionarioListagemView()));
		getBtnAdicionarVeiculo().addActionListener(e -> actionCallView(new VeiculoFormularioView()));
		getBtnListarVeiculo().addActionListener(e -> actionCallView(new VeiculoListagemView()));
		getBtnAdicionarCategoria().addActionListener(e -> actionCallView(new CategoriaFormularioView()));
		getBtnListarCategoria().addActionListener(e -> actionCallView(new CategoriaListagemView()));
		getBtnAdicionarItem().addActionListener(e -> actionCallView(new ItemFormularioView()));
		getBtnListarItem().addActionListener(e -> actionCallView(new ItemListagemView()));
		getBtnAdicionarOS().addActionListener(e -> actionCallView(new OrdemServicoFormularioView()));
		getBtnListarOS().addActionListener(e -> actionCallView(new OrdemServicoListagemView()));
		getBtnAddItensOS().addActionListener(e -> actionCallView(new ItemOSListagemView()));
		getBtnFinalizarOs().addActionListener(e -> actionCallView(new PagamentoOSView()));
		getBtnSair().addActionListener(e -> fecharJanela());
	}

	@Override
	public void fecharJanela() {
		MainController.save();
		System.exit(0);
	}

	private void actionCallView(JFrame view) {
		view.setVisible(true);
	}

	public JPanel getPnlPrincipal() {
		return pnlPrincipal;
	}

	public JButton getBtnAdicionarCliente() {
		return btnAdicionarCliente;
	}

	public JButton getBtnListarCliente() {
		return btnListarCliente;
	}

	public JButton getBtnAdicionarFuncionario() {
		return btnAdicionarFuncionario;
	}

	public JButton getBtnListarFuncionario() {
		return btnListarFuncionario;
	}

	public JButton getBtnAdicionarVeiculo() {
		return btnAdicionarVeiculo;
	}

	public JButton getBtnListarVeiculo() {
		return btnListarVeiculo;
	}

	public JButton getBtnAdicionarCategoria() {
		return btnAdicionarCategoria;
	}

	public JButton getBtnListarCategoria() {
		return btnListarCategoria;
	}

	public JButton getBtnAdicionarItem() {
		return btnAdicionarItem;
	}

	public JButton getBtnListarItem() {
		return btnListarItem;
	}

	public JButton getBtnAdicionarOS() {
		return btnAdicionarOS;
	}

	public JButton getBtnListarOS() {
		return btnListarOS;
	}

	public JButton getBtnAddItensOS() {
		return btnAddItensOS;
	}

	public JButton getBtnFinalizarOs() {
		return btnFinalizarOs;
	}

	public JButton getBtnSair() {
		return btnSair;
	}
}
