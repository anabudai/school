package com.ana.datasource.dao.imp;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ana.datasource.dao.SchoolYearDao;
import com.ana.datasource.model.SchoolYear;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-test-context.xml" })
@Transactional
public class SchoolDaoImplTest {
	@Autowired
	private SchoolYearDao schoolYearDao;

	@Test
	public void save() {
		SchoolYear schoolYear = new SchoolYear();
		schoolYear.setDescription("School Year 2014-2015");
		schoolYear.setStartDate(LocalDate.of(2014, 9, 15));
		schoolYear.setEndDate(LocalDate.of(2015, 6, 15));

		schoolYearDao.saveOrUpdate(schoolYear);
	}
}
