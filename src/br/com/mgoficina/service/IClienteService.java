package br.com.mgoficina.service;

import java.util.List;

import br.com.mgoficina.exception.DataIntegrityException;
import br.com.mgoficina.model.Cliente;

public interface IClienteService {

	public Cliente create(Cliente cliente) throws DataIntegrityException;
	public Cliente findClienteById(Long id);
	public Cliente findClienteByNome(String nome);
	public List<Cliente> findAll();
	public boolean updateCliente(Cliente cliente);
	public boolean deleteCliente(Long id);
	
}