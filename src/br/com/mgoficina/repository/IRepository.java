package br.com.mgoficina.repository;

import java.util.List;
import java.util.Optional;

import br.com.mgoficina.exception.DataIntegrityException;

public interface IRepository<T, ID> {
	
	T save(T t) throws DataIntegrityException;
	List<T> findAll();
	Optional<T> findById(ID id);
	boolean update(T t);
	boolean delete(T t);
	
}
