package com.ana.datasource.dao;

import java.util.List;

public interface GenericDao<T> {

	public void saveOrUpdate(T entity);

	public List<T> findAll();
}
