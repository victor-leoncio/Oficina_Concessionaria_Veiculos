package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdemServico implements Serializable {
	
	private static final long serialVersionUID = -7092641509406122489L;
	private final String id;
	private final Date data;
	private String descricao;
	private int kmAtual;
	private final ICliente cliente;
	private IFuncionario consultor;
	private IVeiculo veiculo;
	private Pagamento pagamento;
	private List<ItemOS> itens;
	
	public OrdemServico(int kmAtual, IFuncionario funcionario, IVeiculo veiculo) {
		id = java.util.UUID.randomUUID().toString();
		this.data = new Date();
		this.kmAtual = kmAtual;
		this.consultor = funcionario;
		this.veiculo = veiculo;
		this.cliente = this.veiculo.getProprietario();
		this.itens = new ArrayList<>();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getKmAtual() {
		return kmAtual;
	}

	public void setKmAtual(int kmAtual) {
		this.kmAtual = kmAtual;
	}

	public ICliente getCliente() {
		return cliente;
	}

	public IFuncionario getConsultor() {
		return consultor;
	}

	public void setConsultor(IFuncionario consultor) {
		this.consultor = consultor;
	}

	public IVeiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(IVeiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public String getId() {
		return id;
	}

	public Date getData() {
		return data;
	}
	
	public void addItem(IItem item, int qtde) {
		itens.add(new ItemOS(item, qtde, item.getPreco()));
	}
	
	public void addItem(IItem item, int qtde, double preco) {
		itens.add(new ItemOS(item, qtde, preco));
	}
	
	public void removeItem(int index) {
		itens.remove(index);
	}
	
	public void addPagamento(ETipoPagamento forma, Date data, double valor) {
		pagamento = new Pagamento(forma, data, valor);
	}
	
	public double getTotalServicos() {
		double total = 0;
		
		for (ItemOS itemOS : itens) {
			if(itemOS.getItem().getTipo() == ETipoItem.SERVICO) {
				total += itemOS.getTotalItem();
			}
		}
		
		return total;
	}
	
	public double getTotalPecas() {
		double total = 0;
		
		for (ItemOS itemOS : itens) {
			if(itemOS.getItem().getTipo() == ETipoItem.PECA) {
				total += itemOS.getTotalItem();
			}
		}
		
		return total;
	}
	
	public double getTotalOS() {
		if(getCliente().isPlatinum()) {
			return getTotalPecas();
		} else {
			return getTotalServicos() + getTotalPecas();
		}
	}

	public StringBuilder listarOS() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[ID =  " + getId() + "]");
		sb.append("\nData: " + getData());
		sb.append("\nNome Cliente: " + getCliente().getNome());
		sb.append("\nTel. Cliente: " + getCliente().getTelefone());
		sb.append("\nPlatinum: " + getCliente().isPlatinum());
		sb.append("\nModelo Veiculo: " + getVeiculo().getModelo());
		sb.append("\nPlaca Veiculo: " + getVeiculo().getPlaca());
		sb.append("\nConsultor: " + getConsultor().getCpf());
		sb.append("\nDescricao: " + getDescricao());
		sb.append("\nKmAtual: " + getKmAtual());
		sb.append(String.format("\nValor Total: %.2f", getTotalPecas() + getTotalServicos()));
		sb.append(String.format("\nValor Final: %.2f\n\n", getTotalOS()));
		
		return sb;
	}

	public List<ItemOS> getItens() {
		return itens;
	}
	
}
