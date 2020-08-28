package br.com.mgoficina.service.impl;

import java.util.List;
import java.util.Optional;

import br.com.mgoficina.exception.DataIntegrityException;
import br.com.mgoficina.exception.ObjectNotFoundException;
import br.com.mgoficina.model.Cliente;
import br.com.mgoficina.repository.IClienteRepository;
import br.com.mgoficina.service.IClienteService;

public class IClienteServiceImpl implements IClienteService {

	private IClienteRepository repository;

	public IClienteServiceImpl(IClienteRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Cliente> findAll() {
		return repository.findAll();
	}

	@Override
	public Cliente findById(Long id) throws ObjectNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado."));
	}

	@Override
	public Cliente create(Cliente t) throws DataIntegrityException {
		return repository.save(t);
	}

	@Override
	public boolean update(Cliente t) {
		Optional<Cliente> optional = repository.findById(t.getId());
		
		if (optional.isEmpty()) {
			return false;
		}
		
		return repository.update(t);
	}

	@Override
	public boolean delete(Cliente t) {		
		return repository.delete(t);
	}

	@Override
	public List<Cliente> findByNome(String nome) {
		return repository.findByNome(nome);
	}

	@Override
	public Cliente findByCpf(String cpf) throws ObjectNotFoundException {
		// TODO Auto-generated method stub
		return repository.findByCpf(cpf)
				.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado."));
	}
	
}
