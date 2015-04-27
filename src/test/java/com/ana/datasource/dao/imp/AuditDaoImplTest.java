package com.ana.datasource.dao.imp;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ana.datasource.dao.AuditDao;
import com.ana.datasource.model.AuditLog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-test-context.xml" })
@Transactional
public class AuditDaoImplTest {
	@Autowired
	private AuditDao auditDao;

	@Test
	public void save() {
		AuditLog schoolYear = new AuditLog("Save", "Details abou operation",
				LocalDate.now(), 1, "SchoolYear");

		auditDao.saveOrUpdate(schoolYear);
	}
}
