package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Veiculo implements IVeiculo, Serializable{

	private static final long serialVersionUID = -2886364838690250765L;
	private final String placa;
	private final int ano;
	private String cor;
	private Modelo modelo;
	private ICliente proprietario;
	private List<OrdemServico> servicos = new ArrayList<>();

	public Veiculo(String placa, int ano, String cor, Modelo modelo) {
		this.placa = placa;
		this.ano = ano;
		this.cor = cor;
		this.modelo = modelo;
	}

	@Override
	public String getPlaca() {
		return placa;
	}

	@Override
	public String getModelo() {
		return modelo.getNome();
	}

	@Override
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public int getAno() {
		return ano;
	}

	@Override
	public ICliente getProprietario() {
		return proprietario;
	}

	public void setProprietario(ICliente proprietario) {
		this.proprietario = proprietario;
	}

	@Override
	public void addServico(OrdemServico os) {
		servicos.add(os);
	}

	public List<OrdemServico> getServicos() {
		return servicos;
	}

}
