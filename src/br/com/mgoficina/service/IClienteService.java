package br.com.mgoficina.service;

import java.util.List;

import br.com.mgoficina.model.Cliente;

public interface IClienteService {


	public Cliente create(Cliente cliente);
	public Cliente findClienteById(long id);
	public Cliente findClienteByNome(String nome);
	public List<Cliente> findAll();
	public boolean updateCliente(Cliente cliente);
	public boolean deleteCliente(long id);
	
}