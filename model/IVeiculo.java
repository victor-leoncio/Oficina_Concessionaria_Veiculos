package model;

public interface IVeiculo {

	public String getPlaca();
	
	public String getModelo();
	
	public String getCor();

	public int getAno();
	
	public ICliente getProprietario();
	
	public void addServico(OrdemServico os);
	
}
