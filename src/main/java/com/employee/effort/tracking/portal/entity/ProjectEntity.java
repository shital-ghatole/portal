package com.employee.effort.tracking.portal.entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "project")
public class ProjectEntity {

	@Id

	@Column(name = "project_id")
	private long projectid;

	@Column(name = "project_name")
	private String projectname;

	@Column(name = "project_startdate")
	private Date projectstartdate;

	@Column(name = "project_enddate")
	private Date projectenddate;

	@Column(name = "sow")
	private String sow;

	public ProjectEntity() {
		super();

	}

	public ProjectEntity(long projectid, String projectname, Date projectstartdate, Date projectenddate, String sow) {
		super();
		this.projectid = projectid;
		this.projectname = projectname;
		this.projectstartdate = projectstartdate;
		this.projectenddate = projectenddate;
		this.sow = sow;

	}

	public long getprojectid() {
		return projectid;
	}

	public void setprojectid(long projectid) {
		this.projectid = projectid;
	}

	public String getprojectname() {
		return projectname;
	}

	public void setprojectname(String projectname) {
		this.projectname = projectname;
	}

	public Date getprojectstartdate() {
		return projectstartdate;
	}

	public void setprojectstartdate(Date projectstartdate) {
		this.projectstartdate = projectstartdate;
	}

	public Date getprojectenddate() {
		return projectenddate;
	}

	public void setprojectenddate(Date projectenddate) {
		this.projectenddate = projectenddate;
	}

	public String getSow() {
		return sow;
	}

	public void setSow(String sow) {
		this.sow = sow;
	}

	@Override
	public String toString() {
		return "ProjectEntity [projectid=" + projectid + ", projectname=" + projectname + ", projectstartdate="
				+ projectstartdate + ", projectenddate=" + projectenddate + ", sow=" + sow + "]";
	}

}
