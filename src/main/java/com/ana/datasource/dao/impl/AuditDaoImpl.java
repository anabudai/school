package com.ana.datasource.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.ana.datasource.dao.AuditDao;
import com.ana.datasource.model.AuditLog;

@Component
public class AuditDaoImpl extends GenericDaoImpl<AuditLog> implements AuditDao {
	@Override
	public void saveOrUpdate(AuditLog entity) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(entity);
		session.flush();
	}
}
