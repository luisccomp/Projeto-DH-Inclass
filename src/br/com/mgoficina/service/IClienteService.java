package br.com.mgoficina.service;

import java.util.List;

import br.com.mgoficina.model.Cliente;

public interface IClienteService {

	public Cliente create(Cliente model);
	public Cliente findById(Long indice);
	public List<Cliente> findAll();
	public boolean update(Cliente model);
	public boolean delete(Long indice);
	public Cliente findClienteByNome(String nome);

	
}