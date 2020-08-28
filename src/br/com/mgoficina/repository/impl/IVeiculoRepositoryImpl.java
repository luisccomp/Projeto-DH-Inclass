package br.com.mgoficina.repository.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import br.com.mgoficina.exception.DataIntegrityException;
import br.com.mgoficina.model.Veiculo;
import br.com.mgoficina.repository.IVeiculoRepository;

public class IVeiculoRepositoryImpl implements IVeiculoRepository {

	private static long currentId = 1L;
	
	private List<Veiculo> veiculos;
	
	public IVeiculoRepositoryImpl() {
		super();
		// TODO Auto-generated constructor stub
		veiculos = new ArrayList<>();
	}

	@Override
	public Veiculo save(Veiculo t) throws DataIntegrityException {
		// TODO Auto-generated method stub
		if (t.getId() != null) {
			throw new DataIntegrityException("o ID do veiculo deve ser nulo.");
		}
		
		t.setId(currentId ++);
		veiculos.add(t);
		
		return t;
	}

	@Override
	public List<Veiculo> findAll() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableList(veiculos);
	}

	@Override
	public Optional<Veiculo> findById(Long id) {
		// TODO Auto-generated method stub
		return veiculos.stream()
				.filter(v -> v.getId().equals(id))
				.findAny();
	}

	@Override
	public boolean update(Veiculo t) {
		// TODO Auto-generated method stub
		Optional<Veiculo> veiculo = findById(t.getId());
		
		if (veiculo.isEmpty()) {
			return false;
		}
		
		veiculos.remove(veiculo.get());
		veiculos.add(t);
		
		return true;
	}

	@Override
	public boolean delete(Veiculo t) {
		// TODO Auto-generated method stub
		return veiculos.remove(t);
	}

	@Override
	public Optional<Veiculo> findByPlaca(String placa) {
		// TODO Auto-generated method stub
		return veiculos.stream()
				.filter(v -> v.getPlaca().equals(placa))
				.findAny();
	}

}
