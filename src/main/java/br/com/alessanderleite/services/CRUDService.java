package br.com.alessanderleite.services;

import java.io.IOException;

public interface CRUDService<T, ID> {

	Iterable<T> listAll();
	
	T getById(ID id) throws IOException;
	
	T save(T entity);
	
	void delete(ID id) throws IOException;
	
	T update(T entity) throws IOException;
}
