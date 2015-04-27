package com.ana.datasource.audit;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ana.datasource.dao.AuditDao;
import com.ana.datasource.model.AuditLog;

@Component
public class AuditInterceptor extends EmptyInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8173060099803571334L;

	@Autowired
	private AuditDao auditDao;

	private Set inserts = new HashSet();
	private Set updates = new HashSet();
	private Set deletes = new HashSet();

	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) throws CallbackException {

		if (entity instanceof Auditable) {
			inserts.add(entity);
		}
		return false;

	}

	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) throws CallbackException {

		if (entity instanceof Auditable) {
			updates.add(entity);
		}
		return false;

	}

	public void onDelete(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {

		if (entity instanceof Auditable) {
			deletes.add(entity);
		}
	}

	// called before commit into database
	public void preFlush(Iterator iterator) {
	}

	// called after committed into database
	public void postFlush(Iterator iterator) {

		try {

			for (Iterator it = inserts.iterator(); it.hasNext();) {
				Auditable entity = (Auditable) it.next();
				AuditLog auditRecord = new AuditLog("Saved",
						entity.getLogDetail(), LocalDate.now(),
						entity.getLogId(), entity.getClass().toString());
				auditDao.saveOrUpdate(auditRecord);
			}

			for (Iterator it = updates.iterator(); it.hasNext();) {
				Auditable entity = (Auditable) it.next();
				System.out.println("postFlush - update");
				AuditLog auditRecord = new AuditLog("Updated",
						entity.getLogDetail(), LocalDate.now(),
						entity.getLogId(), entity.getClass().toString());
				auditDao.saveOrUpdate(auditRecord);
			}

			for (Iterator it = deletes.iterator(); it.hasNext();) {
				Auditable entity = (Auditable) it.next();
				System.out.println("postFlush - delete");
				AuditLog auditRecord = new AuditLog("Deleted",
						entity.getLogDetail(), LocalDate.now(),
						entity.getLogId(), entity.getClass().toString());
				auditDao.saveOrUpdate(auditRecord);
			}

		} finally {
			inserts.clear();
			updates.clear();
			deletes.clear();
		}
	}
}
