package com.employee.effort.tracking.portal.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.effort.tracking.portal.entity.ProjectEntity;
import com.employee.effort.tracking.portal.repository.ProjectRepo;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepo prorepo;

	public List<ProjectEntity> getAllProjects() {

		return this.prorepo.findAll();
	}

	public ProjectEntity getProjectById(long projectid) {

		return this.getProjectById(projectid);

	}

	public ProjectEntity addProject(ProjectEntity pro) {

		return this.prorepo.save(pro);
	}

}
