package com.employee.effort.tracking.portal.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.effort.tracking.portal.entity.UserEntity;
import com.employee.effort.tracking.portal.entity.UserLogin;
import com.employee.effort.tracking.portal.service.LoginService;
import com.employee.effort.tracking.portal.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class UserController {

	@Autowired
	private LoginService logins;

	@Autowired
	private UserService userservice;

	@GetMapping("/users")
	public List<UserEntity> getEmployees() {
		return this.userservice.getAllEmployees();
	}

	@PostMapping("/users")
	public ResponseEntity<UserEntity> addEmployee(@RequestBody UserEntity user) {

		try {
			user = this.userservice.addEmployee(user);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@PostMapping("/loggedin")
	public String userLogin(@RequestBody UserLogin login) {
		return logins.userLogin(login);
	}

	@PostMapping("/login")
	public ResponseEntity<UserEntity> loginEmployee(@RequestBody UserEntity user) {
		try {
			user = this.userservice.loginEmployee(user);

			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(user);
		}

	}

}
