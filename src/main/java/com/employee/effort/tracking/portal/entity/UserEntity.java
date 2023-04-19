package com.employee.effort.tracking.portal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_entity")
public class UserEntity {

	@Id

	@Column(name = "employeeid")
	private int employeeid;
	@Column(name = "user_name")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "email_id")
	private String emailid;
	@Column(name = "role")
	private String role;

	public UserEntity() {
		super();

	}

	public UserEntity(int employeeid, String username, String password, String emailid, String role) {
		super();
		this.employeeid = employeeid;
		this.username = username;
		this.password = password;
		this.emailid = emailid;
		this.role = role;
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserEntity [employeeid=" + employeeid + ", username=" + username + ", password=" + password
				+ ", emailid=" + emailid + ", role=" + role + "]";
	}

}
