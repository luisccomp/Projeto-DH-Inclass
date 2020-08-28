package br.com.mgoficina.service.impl;

import java.util.List;

import br.com.mgoficina.exception.DataIntegrityException;
import br.com.mgoficina.exception.ObjectNotFoundException;
import br.com.mgoficina.model.Veiculo;
import br.com.mgoficina.repository.IVeiculoRepository;
import br.com.mgoficina.service.IVeiculoService;

public class IVeiculoServiceImpl implements IVeiculoService {
	
	private IVeiculoRepository repository;
	
	public IVeiculoServiceImpl(IVeiculoRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Veiculo> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Veiculo findById(Long id) throws ObjectNotFoundException {
		// TODO Auto-generated method stub
		return repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Veiculo não encontrado."));
	}

	@Override
	public Veiculo create(Veiculo t) throws DataIntegrityException {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public boolean update(Veiculo t) {
		// TODO Auto-generated method stub
		return repository.update(t);
	}

	@Override
	public boolean delete(Veiculo t) {
		// TODO Auto-generated method stub
		return repository.delete(t);
	}

	@Override
	public Veiculo findByPlaca(String placa) throws ObjectNotFoundException {
		// TODO Auto-generated method stub
		return repository.findByPlaca(placa)
				.orElseThrow(() -> new ObjectNotFoundException("Veiculo não encontrado."));
	}

}
