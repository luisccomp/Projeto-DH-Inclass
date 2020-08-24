package br.com.mgoficina.service;

import java.util.List;

import br.com.mgoficina.model.Cliente;

public interface BaseService<MODEL, ID> {
	
	public MODEL create(MODEL model);
	public MODEL findById(ID indice);
	public List<MODEL> findAll();
	public boolean update(MODEL model);
	public boolean delete(ID indice);

}
