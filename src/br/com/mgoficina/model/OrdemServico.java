package br.com.mgoficina.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class OrdemServico {
	
	private Long id;
	private Set<Funcionario> funcionarios = new HashSet<>();
	private Cliente cliente;
	private Set<ServicoOrdemServico> servicos = new HashSet<>();
	public Long getId() {
		return id;
	}
	
	public OrdemServico() {
	}
	public OrdemServico(Long id) {
		this.id = id;
	}



	public double getValorTotal() {
		double valorTotal = 0;
		
		Iterator<ServicoOrdemServico> iterator = servicos.iterator();
		
		while(iterator.hasNext()) {
			ServicoOrdemServico servico = iterator.next();
			valorTotal += servico.getValor()*servico.getQuantidade();
		}
		
		return valorTotal;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public OrdemServico addServico(ServicoOrdemServico servico) {
	
		this.servicos.add(servico);
		
		return this;
	}
	public Set<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(Set<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Set<ServicoOrdemServico> getServicos() {
		return servicos;
	}
	public void setServicos(Set<ServicoOrdemServico> servicos) {
		this.servicos = servicos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemServico other = (OrdemServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
