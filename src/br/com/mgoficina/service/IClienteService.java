package br.com.mgoficina.service;

import java.util.Set;

import br.com.mgoficina.model.Cliente;

public interface IClienteService extends IService<Cliente> {

	public Cliente findByNome(String nome);
	public Set<Cliente> findIdadeMaior(int idade);
	
}