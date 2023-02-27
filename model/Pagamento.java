package model;

import java.io.Serializable;
import java.util.Date;

public class Pagamento implements Serializable {
	
	private static final long serialVersionUID = -9116258160438196640L;
	private final ETipoPagamento tipo;
	private final Date data;
	private final Double valor;
	
	public Pagamento(ETipoPagamento tipo, Date data, Double valor) {
		this.tipo = tipo;
		this.data = data;
		this.valor = valor;
	}

	public ETipoPagamento getTipo() {
		return tipo;
	}

	public Date getData() {
		return data;
	}

	public Double getValor() {
		return valor;
	}
	
}
