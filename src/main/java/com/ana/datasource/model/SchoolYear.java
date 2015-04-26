package com.ana.datasource.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="SCHOOL_YEAR")
public class SchoolYear {
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "schoolSequence", sequenceName = "SEQUENCE_SCHOOL_YEAR")
	@GeneratedValue(generator = "schoolSequence", strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(name = "start_date")
	@Type(type="com.ana.datasource.config.customtypes.LocalDateUserType")
	private LocalDate startDate;
	@Type(type="com.ana.datasource.config.customtypes.LocalDateUserType")
	@Column(name = "end_date")
	private LocalDate endDate;
	@Column(name = "description")
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
