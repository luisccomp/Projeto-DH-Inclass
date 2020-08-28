package br.com.mgoficina.repository;

import java.util.Optional;

import br.com.mgoficina.model.Veiculo;

public interface IVeiculoRepository extends IRepository<Veiculo, Long> {
	
	Optional<Veiculo> findByPlaca(String placa);

}
