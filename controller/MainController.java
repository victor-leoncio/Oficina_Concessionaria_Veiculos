package controller;

import java.io.Serializable;

import persistence.Serializacao;

public class MainController implements Serializable {

	private static final long serialVersionUID = -25595180939938054L;
	private static MainController instancia;
	private PessoaController pessoaController;
	private VeiculoController veiculoController;
	private CatalogoController catalogoControler;
	private OrdemServicoController ordemServicoController;
	
	public MainController() {
		pessoaController = new PessoaController();
		veiculoController = new VeiculoController();
		catalogoControler = new CatalogoController();
		ordemServicoController = new OrdemServicoController();
	}

	public static MainController getInstancia() {
		return instancia;
	}

	public static PessoaController getPessoaController() {
		return getInstancia().pessoaController;
	}

	public static VeiculoController getVeiculoController() {
		return getInstancia().veiculoController;
	}

	public static CatalogoController getCatalogoControler() {
		return getInstancia().catalogoControler;
	}

	public static OrdemServicoController getOrdemServicoController() {
		return getInstancia().ordemServicoController;
	}
	
	public static void load() {
		instancia = Serializacao.readFile();

		if (instancia == null) {
			instancia = new MainController();
		}
	}

	public static void save() {
		Serializacao.writeFile(instancia);
	}
	
}
