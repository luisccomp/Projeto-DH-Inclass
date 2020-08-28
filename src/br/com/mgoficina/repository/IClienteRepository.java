package br.com.mgoficina.repository;

import java.util.List;
import java.util.Optional;

import br.com.mgoficina.model.Cliente;

public interface IClienteRepository extends IRepository<Cliente, Long> {

	List<Cliente> findByNome(String nome);
	Optional<Cliente> findByCpf(String cpf);
	
}
