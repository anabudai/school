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
@Table(name = "AUDIT_LOG")
public class AuditLog {
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "auditSequence", sequenceName = "SEQUENCE_AUDIT_LOG")
	@GeneratedValue(generator = "auditSequence", strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "action")
	private String action;
	@Column(name = "detail")
	private String detail;
	@Column(name = "creation_date")
	@Type(type = "com.ana.datasource.config.customtypes.LocalDateUserType")
	private LocalDate createdDate;
	@Column(name = "entity_id")
	private long entityId;
	@Column(name = "entity_name")
	private String entityName;

	public AuditLog(String action, String detail, LocalDate createdDate,
			long entityId, String entityName) {
		super();
		this.action = action;
		this.detail = detail;
		this.createdDate = createdDate;
		this.entityId = entityId;
		this.entityName = entityName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public long getEntityId() {
		return entityId;
	}

	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
}
