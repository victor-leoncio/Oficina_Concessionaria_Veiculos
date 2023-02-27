package controller;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import model.IFuncionario;
import model.IVeiculo;
import model.ItemOS;
import model.OrdemServico;

public class OrdemServicoController implements Serializable {
	
	private static final long serialVersionUID = -5192394703247081013L;
	private Map<String, OrdemServico> ordemServicos;

	public OrdemServicoController() {
		ordemServicos = new TreeMap<>();
	}
	
	public void addOS(String descricao, String placa, int KmAtual, int matricula) {
		IVeiculo veiculo = MainController.getVeiculoController().getVeiculo(placa);
		IFuncionario funcionario = MainController.getPessoaController().getFuncionario(matricula);
		OrdemServico os = new OrdemServico(KmAtual, funcionario, veiculo);
		os.setDescricao(descricao);
		ordemServicos.put(os.getId(), os);
		veiculo.addServico(os);
	}
	
	public OrdemServico getOS(String id) {
		return ordemServicos.get(id);
	}
	
	public Collection<OrdemServico> getListaOS() {
		return ordemServicos.values();
	}
	
	public Set<String> getListaIdOs() {
		return ordemServicos.keySet();
	}
	
	public String infoOS(OrdemServico os) {
		return os.listarOS().toString();
	}
	
	public String infoTodosOs() {
		StringBuilder sb = new StringBuilder();
		
		for (OrdemServico os : getListaOS()) {
			sb.append(os.listarOS());
		}
		
		return sb.toString();
	}
	
	public String infoItensOS(String id) {
		StringBuilder sb = new StringBuilder();
		
		for (ItemOS item : getOS(id).getItens()) {
			sb.append(item.listarItem());
		}
		
		return sb.toString();
	}
	
	public void removerOS(String id) {
		ordemServicos.remove(id);
	}

}
