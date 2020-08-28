package br.com.mgoficina.service;

import java.util.List;

import br.com.mgoficina.exception.DataIntegrityException;
import br.com.mgoficina.exception.ObjectNotFoundException;

public interface IService<T, ID> {

	List<T> findAll();
	T findById(ID id) throws ObjectNotFoundException;
	T create(T t) throws DataIntegrityException;	
	boolean update(T t);
	boolean delete(T t);

}
