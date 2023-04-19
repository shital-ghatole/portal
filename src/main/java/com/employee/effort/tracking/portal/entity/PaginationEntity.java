package com.employee.effort.tracking.portal.entity;

import java.util.List;

public class PaginationEntity {
private long total;
private List<ProjectEffortEntity> data;

public PaginationEntity(List<ProjectEffortEntity> data,long total) {
	super();
	this.total=total;
	this.data=data;
	
}
public long getTotal() {
	return total;
}
public void setTotal(long total) {
	this.total = total;
}
public List<ProjectEffortEntity> getData() {
	return data;
}
public void setData(List<ProjectEffortEntity> data) {
	this.data = data;
}

}
