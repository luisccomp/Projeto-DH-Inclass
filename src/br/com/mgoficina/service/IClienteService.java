package br.com.mgoficina.service;

import java.util.List;

import br.com.mgoficina.exception.ObjectNotFoundException;
import br.com.mgoficina.model.Cliente;

public interface IClienteService extends IService<Cliente, Long> {
	
	List<Cliente> findByNome(String nome);
	Cliente findByCpf(String cpf) throws ObjectNotFoundException;
	
}