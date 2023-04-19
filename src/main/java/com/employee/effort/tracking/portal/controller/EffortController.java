package com.employee.effort.tracking.portal.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.effort.tracking.portal.entity.ProjectEffortEntity;
import com.employee.effort.tracking.portal.exception.MessageException;
import com.employee.effort.tracking.portal.repository.ProjectEffortRepository;
import com.employee.effort.tracking.portal.service.ProjectEffortService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class EffortController {

	@Autowired
	private ProjectEffortService proefservice;

	@Autowired
	private ProjectEffortRepository empRepo;

	@GetMapping("/projectefforts")
	public List<ProjectEffortEntity> getProjectEfforts() {
		return this.proefservice.getAllProjectEfforts();
	}

	@GetMapping("/projecteffortdata/{id}")
	private ProjectEffortEntity getId(@PathVariable("id") int id) {
		return proefservice.getById(id);
	}

	@PostMapping("/projectefforts")
	public ResponseEntity<ProjectEffortEntity> addProjectEffort(@RequestBody ProjectEffortEntity prof) {

		try {
			prof = this.proefservice.addProjectEffort(prof);
			System.out.println(prof);
			return ResponseEntity.status(HttpStatus.CREATED).body(prof);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(prof);

	}

	@PutMapping("/saveprojectefforts/{id}")
	public ProjectEffortEntity update(@RequestBody ProjectEffortEntity projecteffort) throws MessageException {

		return this.proefservice.update(projecteffort);

	}

	@DeleteMapping("/deleteprojectefforts/{id}")
	public String deleteProjecteffort(@PathVariable("id") int id) {
		this.proefservice.delete(id);
		return "id deleted successfully";

	}

	@GetMapping("/employeeefforts")
	public List<ProjectEffortEntity> getAllEmployee() {
		List<ProjectEffortEntity> employee = empRepo.findAll();
		DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
		employee.stream().filter(project -> Objects.nonNull(project.getDate()))
				.map(project -> outputFormatter.format(project.getDate()))
				.forEach(project -> System.out.println(project));
		return employee;
	}

	@GetMapping("/searchprojectefforts/{startDate}/{endDate}")
	public ResponseEntity<List<ProjectEffortEntity>> getProjectBetweenDate(
			@PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
		List<ProjectEffortEntity> ProjectData = empRepo.findProjectByDate(startDate, endDate);
		return (null != ProjectData) ? ResponseEntity.ok().body(ProjectData)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

}
