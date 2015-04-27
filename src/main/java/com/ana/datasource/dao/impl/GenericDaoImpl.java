package com.ana.datasource.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ana.datasource.dao.GenericDao;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {
	@Autowired
	protected SessionFactory sessionFactory;
	protected Class<?> persistentClass;

	{
		ParameterizedType type = ((ParameterizedType) getClass()
				.getGenericSuperclass());
		persistentClass = ((Class<?>) type.getActualTypeArguments()[0]);
	}

	public void saveOrUpdate(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(entity);
	};

	@Override
	@SuppressWarnings({ "unchecked" })
	public List<T> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(persistentClass).list();
	}
}
