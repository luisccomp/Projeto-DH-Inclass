package br.com.mgoficina.repository.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.mgoficina.exception.DataIntegrityException;
import br.com.mgoficina.model.Cliente;
import br.com.mgoficina.repository.IClienteRepository;

public class IClienteRepositoryImpl implements IClienteRepository {

	private static Long currentId = 1L;
	
	private List<Cliente> clientes;

	public IClienteRepositoryImpl() {
		super();
		clientes = new ArrayList<>();
	}

	@Override
	public Cliente save(Cliente t) throws DataIntegrityException {
		if (t.getId() != null) {
			throw new DataIntegrityException("O ID do cliente deve ser nulo.");
		}
		
		t.setId(currentId ++);
		
		clientes.add(t);
		
		return t;
	}

	@Override
	public List<Cliente> findAll() {
		return Collections.unmodifiableList(clientes);
	}

	@Override
	public Optional<Cliente> findById(Long id) {
		return clientes.stream()
				.filter(c -> c.getId().equals(id))
				.findAny();
	}

	@Override
	public boolean update(Cliente t) {
		Optional<Cliente> cliente = findById(t.getId());
		
		if (cliente.isEmpty()) {
			return false;
		}
		
		clientes.remove(cliente.get());
		clientes.add(t);
		
		return true;
	}

	@Override
	public boolean delete(Cliente t) {
		return clientes.remove(t);
	}

	@Override
	public List<Cliente> findByNome(String nome) {
		// TODO Auto-generated method stub
		return Collections.unmodifiableList(clientes.stream()
				.filter(cliente -> cliente.getNome().contains(nome))
				.collect(Collectors.toList()));
	}
	
	@Override
	public Optional<Cliente> findByCpf(String cpf) {
		return clientes.stream()
				.filter(c -> c.getCpf().equals(cpf))
				.findAny();
	}
	
}
