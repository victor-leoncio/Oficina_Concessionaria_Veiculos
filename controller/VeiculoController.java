package controller;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import model.IVeiculo;
import model.Modelo;
import model.OrdemServico;
import model.Veiculo;

public class VeiculoController implements Serializable {

	private static final long serialVersionUID = -5271015926939915064L;
	private Map<String, IVeiculo> veiculos;
	private Map<String, Modelo> modelos;
	
	public VeiculoController() {
		veiculos = new TreeMap<>();
	}
	
	public void addVeiculo(String placa, String modelo, int ano, String cor, Long cpfProprietario) {
		IVeiculo veiculo = new Veiculo(placa, ano, cor, new Modelo(modelo));
		((Veiculo)veiculo).setProprietario(MainController.getPessoaController().getCliente(cpfProprietario));
		veiculos.put(veiculo.getPlaca(), veiculo);
	}
	
	public void addModelo(String nome) {
		Modelo modelo = new Modelo(nome);
		modelos.put(nome, modelo);
	}
	
	public Set<String> getListaPlacasVeiculos() {
		return veiculos.keySet();
	}
	
	public IVeiculo getVeiculo(String placa) {
		return veiculos.get(placa);
	}
	
	public Collection<IVeiculo> getListaVeiculos() {
		return veiculos.values();
	} 
	
	public Collection<OrdemServico> getListaOS() {
		return  MainController.getOrdemServicoController().getListaOS();
	}

	public List<OrdemServico> getListaOS(String id) {
		return ((Veiculo) (veiculos.get(id))).getServicos();
	}
	
	public String infoVeiculo(IVeiculo veiculo) {
		return String.format("[PLACA = %s]\nModelo = %s\nCor = %s\nAno = %d\nProprietario = %d\n\n",
				veiculo.getPlaca(), veiculo.getModelo(), veiculo.getCor(), veiculo.getAno(), 
				veiculo.getProprietario().getCpf());
	}
	
	public String infoTodosVeiculos() {
		StringBuilder sb = new StringBuilder();
		
		for (IVeiculo veiculo : getListaVeiculos()) {
			sb.append(infoVeiculo(veiculo));
		}
		
		return sb.toString();
	}
	
	public void removarVeiculos(String placa) {
		veiculos.remove(placa);
	}
}
