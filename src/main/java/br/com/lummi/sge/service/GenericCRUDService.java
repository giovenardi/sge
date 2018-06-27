package br.com.lummi.sge.service;

import java.util.List;

import br.com.lummi.sge.daos.GenericDao;
import br.com.lummi.sge.models.Entidade;

public abstract class GenericCRUDService<T extends Entidade> {

	public List<T> all() {
		return getDao().findAll();
	}

	public List<T> all(String orderColumn) {
		return getDao().findAll(orderColumn);
	}

	public T getById(Integer id) {
		return getDao().getById(id);
	}

	public T create(T entity) {
		return getDao().save(entity);
	}

	public T update(T entity) {
		return getDao().update(entity);
	}

	public void delete(T entity) {
		getDao().delete(entity);
	}

	public abstract GenericDao<T> getDao();

}