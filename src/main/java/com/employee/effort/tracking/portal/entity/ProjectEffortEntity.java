package com.employee.effort.tracking.portal.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "project_effort")
public class ProjectEffortEntity {
	@Id

	@Column(name = "id")
	private int id;

	@Column(name = "project_id")
	private int project_id;

	@Column(name = "date")
	private Date date;

	@Column(name = "project_name")
	private String project_name;

	@Column(name = "availability")
	private String availability;

	@Column(name = "task_category")
	private String task_category;

	@Column(name = "sub_task_category")
	private String sub_task_category;

	@Column(name = "task_description")
	private String task_description;

	@Column(name = "effort")
	private String effort;

	@Column(name = "leave_type")
	private String leave_type;

	public ProjectEffortEntity() {
		super();
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getTask_category() {
		return task_category;
	}

	public void setTask_category(String task_category) {
		this.task_category = task_category;
	}

	public String getSub_task_category() {
		return sub_task_category;
	}

	public void setSub_task_category(String sub_task_category) {
		this.sub_task_category = sub_task_category;
	}

	public String getTask_description() {
		return task_description;
	}

	public void setTask_description(String task_description) {
		this.task_description = task_description;
	}

	public String getEffort() {
		return effort;
	}

	public void setEffort(String effort) {
		this.effort = effort;
	}

	public String getLeave_type() {
		return leave_type;
	}

	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}

	public ProjectEffortEntity(int project_id, Date date, String project_name, String availability,
			String task_category, String sub_task_category, String task_description, String effort, String leave_type) {
		super();
		this.project_id = project_id;
		this.date = date;
		this.project_name = project_name;
		this.availability = availability;
		this.task_category = task_category;
		this.sub_task_category = sub_task_category;
		this.task_description = task_description;
		this.effort = effort;
		this.leave_type = leave_type;

	}

	@Override
	public String toString() {
		return "ProjectEffortEntity [ project_id=" + project_id + ", date=" + date + ", project_name=" + project_name
				+ ", availability=" + availability + ", task_category=" + task_category + ", sub_task_category="
				+ sub_task_category + ", task_description=" + task_description + ", effort=" + effort + ", leave_type="
				+ leave_type + "]";
	}

}
