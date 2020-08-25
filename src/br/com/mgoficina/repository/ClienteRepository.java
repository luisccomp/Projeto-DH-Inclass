package br.com.mgoficina.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import br.com.mgoficina.exception.ObjectNotFoundException;
import br.com.mgoficina.model.Cliente;

public class ClienteRepository {

	private static Long IDs = 0L;
	
	private List<Cliente> clientes;

	public ClienteRepository() {
		super();
		// TODO Auto-generated constructor stub
		clientes = new ArrayList<>();
	}
	
	public Cliente create(Cliente cliente) {
		cliente.setId(++ IDs);
		
		clientes.add(cliente);
		
		return cliente;
	}
	
	public Cliente findClienteById(Long id) throws ObjectNotFoundException {
		Optional<Cliente> cliente = clientes.stream()
				.filter(c -> c.getId().equals(id))
				.findFirst();
		
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado"));
	}
	
	public Cliente findClienteByNome(String nome) throws ObjectNotFoundException {
		Optional<Cliente> cliente = clientes.stream()
				.filter(c -> c.getNome().equals(nome))
				.findAny();
		
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado"));
	}
	
	public boolean updateCliente(Cliente cliente) {
		Optional<Cliente> optional = clientes.stream()
				.filter(c -> c.getId().equals(cliente.getId()))
				.findAny();
		
		if (optional.isPresent()) {
			clientes.remove(optional.get());
			clientes.add(optional.get());
		}
		
		return optional.isPresent();
	}
	
	public boolean deleteCliente(Cliente cliente) {
		return clientes.remove(cliente);
	}
	
	public List<Cliente> listarClientes() {
		return Collections.unmodifiableList(clientes);
	}
	
}
