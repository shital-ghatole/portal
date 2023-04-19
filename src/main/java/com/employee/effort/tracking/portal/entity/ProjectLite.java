package com.employee.effort.tracking.portal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "project")
public class ProjectLite {
	@Id
	@Column(name = "project_id")
	private long projectid;

	@Column(name = "project_name")
	private String projectname;
}
