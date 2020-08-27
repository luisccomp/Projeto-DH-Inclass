package br.com.mgoficina.service;

import java.util.List;
import java.util.Set;

import br.com.mgoficina.model.Cliente;
import br.com.mgoficina.model.OrdemServico;

public interface IClienteService extends IService<Cliente> {

	public Cliente findByNome(String nome);
	public Set<Cliente> findIdadeMaior(int idade);
	
}