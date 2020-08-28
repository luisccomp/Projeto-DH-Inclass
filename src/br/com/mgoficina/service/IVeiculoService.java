package br.com.mgoficina.service;

import br.com.mgoficina.exception.ObjectNotFoundException;
import br.com.mgoficina.model.Veiculo;

public interface IVeiculoService extends IService<Veiculo, Long> {

	Veiculo findByPlaca(String placa) throws ObjectNotFoundException;
	
}
