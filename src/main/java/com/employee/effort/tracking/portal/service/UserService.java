package com.employee.effort.tracking.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.effort.tracking.portal.entity.UserEntity;
import com.employee.effort.tracking.portal.exception.MessageException;
import com.employee.effort.tracking.portal.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userrepo;

	public List<UserEntity> getAllEmployees() {

		return this.userrepo.findAll();
	}

	public UserEntity addEmployee(UserEntity user) {

		return this.userrepo.save(user);
	}

	public UserEntity viewEmployee(int employeeid) {
		return this.userrepo.findByemployeeid(employeeid);
	}

	public UserEntity loginEmployee(UserEntity user) throws MessageException {

		UserEntity loggedUser = this.userrepo.findByUsername(user.getusername());
		if (loggedUser.getPassword().equals(user.getPassword())) {

			return loggedUser;
		} else {
			throw new MessageException("Invalid Login");

		}

	}

}
