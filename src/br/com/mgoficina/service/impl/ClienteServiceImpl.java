package br.com.mgoficina.service.impl;

import java.util.List;

import br.com.mgoficina.exception.ObjectNotFoundException;
import br.com.mgoficina.model.Cliente;
import br.com.mgoficina.repository.ClienteRepository;
import br.com.mgoficina.service.IClienteService;

public class ClienteServiceImpl implements IClienteService{

	private ClienteRepository clienteRepository;

	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		super();
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente create(Cliente cliente) {
		return clienteRepository.create(cliente);
	}
	
	public Cliente findClienteById(Long id) throws ObjectNotFoundException {
		return clienteRepository.findClienteById(id);
	}
	
	public Cliente findClienteByNome(String nome) throws ObjectNotFoundException {
		return clienteRepository.findClienteByNome(nome);
	}
	
	public List<Cliente> findAll() {
		return clienteRepository.listarClientes();
	}
	
	public boolean updateCliente(Cliente cliente) {
		return clienteRepository.updateCliente(cliente);
	}
	
	public boolean deleteCliente(Long id) throws ObjectNotFoundException {
		Cliente cliente = clienteRepository.findClienteById(id);
		
		return clienteRepository.deleteCliente(cliente);
	}
	
}
