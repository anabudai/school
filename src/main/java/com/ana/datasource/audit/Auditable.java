package com.ana.datasource.audit;

public interface Auditable {
	public Long getLogId();

	public String getLogDetail();
}
