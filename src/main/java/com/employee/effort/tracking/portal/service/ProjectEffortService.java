package com.employee.effort.tracking.portal.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.effort.tracking.portal.entity.ProjectEffortEntity;
import com.employee.effort.tracking.portal.exception.MessageException;
import com.employee.effort.tracking.portal.repository.ProjectEffortRepository;

@Service
public class ProjectEffortService {

	@Autowired
	private ProjectEffortRepository projectefrepo;

	public List<ProjectEffortEntity> getAllProjectEfforts() {

		return this.projectefrepo.findAll();
	}

	public ProjectEffortEntity addProjectEffort(ProjectEffortEntity proef) {

		return this.projectefrepo.save(proef);
	}

	public ProjectEffortEntity getById(int id) {
		return projectefrepo.findById(id).get();
	}

	public ProjectEffortEntity update(ProjectEffortEntity projecteffort) throws MessageException {
		ProjectEffortEntity exist = this.projectefrepo.findById(projecteffort.getProject_id()).get();
		if (exist.getProject_name() == null) {
			throw new MessageException("Invalid project effort id");
		} else {

			return this.projectefrepo.save(projecteffort);
		}
	}

	public String delete(int id) {
		projectefrepo.deleteById(id);
		return "id deleted successfully";

	}

}
