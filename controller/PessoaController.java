package controller;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import model.Cliente;
import model.Funcionario;
import model.ICliente;
import model.IFuncionario;
import model.IPessoa;

public class PessoaController implements Serializable{

	private static final long serialVersionUID = 8220123106476225353L;
	private Map<Long, IPessoa> clientes;
	private Map<Integer, IPessoa> funcionarios;	
	
	public PessoaController() {
		clientes = new TreeMap<>();
		funcionarios = new TreeMap<>();
	}
	
	public void addCliente(Long cpf, String nome, Long tel, String email, Boolean premium) {
		Cliente cliente = new Cliente(cpf, nome, tel);
		cliente.setEmail(email);
		cliente.setPlatinum(premium);
		
		clientes.put(cliente.getCpf(), cliente);
	}
	
	public void addFuncionario(Long cpf, String nome, Long tel, String email, int matricula) {
		Funcionario funcionario = new  Funcionario(cpf, nome, tel, matricula);
		funcionario.setEmail(email);
		
		funcionarios.put(funcionario.getMatricula(), funcionario);
	}
	
	public ICliente getCliente(Long cpf) {
		return (ICliente) clientes.get(cpf);
	}
	
	public IFuncionario getFuncionario(int matricula) {
		return (IFuncionario) funcionarios.get(matricula);
	}
	
	public Set<Long> getListaCpfClientes() {
		return clientes.keySet();
	}
	
	public Set<Integer> getListaMatriculaFuncionario() {
		return funcionarios.keySet();
	}
	
	public Collection<IPessoa> getListaClientes() {
		return clientes.values();
	}

	public Collection<IPessoa> getListaFuncionarios() {
		return funcionarios.values();
	}
	
	public String infoCliente(IPessoa cliente) {
		return String.format("[CPF = %d]\nNome = %s\nTelefone = %d\nEmail = %s\nPlatinum = %s\n\n",
				cliente.getCpf(), cliente.getNome(), cliente.getTelefone(), cliente.getEmail(),
				((Cliente)cliente).isPlatinum());
	}
	
	public String infoTodosClientes() {
		StringBuilder sb = new StringBuilder();
		
		for (IPessoa cliente : getListaClientes()) {
			sb.append(infoCliente(cliente));
		}
		
		return sb.toString();
	}
	
	public String infoFuncionario(IPessoa funcionario) {
		return String.format("[MATRICULA = %s]\nCpf = %d\nNome = %s\nTelefone = %d\nEmail = %s\n\n",
				   ((Funcionario)funcionario).getMatricula(), funcionario.getCpf(), funcionario.getNome(), 
				   funcionario.getTelefone(), funcionario.getEmail());
	}
	
	public String infoTodosFuncionarios() {
		StringBuilder sb = new StringBuilder();
		
		for (IPessoa funcionario : getListaFuncionarios()) {
			sb.append(infoFuncionario(funcionario));
		}
		
		return sb.toString();
	}
	
	public void removerCliente(Long cpf) {
		clientes.remove(cpf);
	}
	
	public void removerFuncionario(int matricula) {
		funcionarios.remove(matricula);
	}

}
