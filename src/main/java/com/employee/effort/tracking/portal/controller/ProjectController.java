package com.employee.effort.tracking.portal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employee.effort.tracking.portal.entity.ProjectEntity;
import com.employee.effort.tracking.portal.service.ProjectService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ProjectController {
	@Autowired
	private ProjectService proservice;

	@GetMapping("/projects")
	public List<ProjectEntity> getProjects() {
		return this.proservice.getAllProjects();
	}

	@PostMapping("/projects")
	public ResponseEntity<ProjectEntity> addProject(@RequestBody ProjectEntity pro) {

		try {
			pro = this.proservice.addProject(pro);

			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return null;

	}

	@GetMapping("/employee/{projectid}")
	public ResponseEntity<ProjectEntity> getProject(@PathVariable("projectid") long projectId) {

		ProjectEntity pro = proservice.getProjectById(projectId);
		if (pro == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(pro));
	}

}
