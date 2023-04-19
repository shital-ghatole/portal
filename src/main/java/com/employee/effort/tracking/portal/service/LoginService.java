package com.employee.effort.tracking.portal.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.effort.tracking.portal.entity.UserEntity;
import com.employee.effort.tracking.portal.entity.UserLogin;
import com.employee.effort.tracking.portal.repository.UserRepo;

@Service
public class LoginService {

	@Autowired
	private UserRepo userrepo;

	public String userLogin(UserLogin login) {
		ArrayList<UserEntity> list = (ArrayList<UserEntity>) userrepo.findAll();
		int count = 0;

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getusername().equals(login.getusername())
					&& list.get(i).getPassword().equals(login.getPassword())) {
				count++;
			}
		}

		if (count == 1) {
			return "logged in";
		} else {
			return "wrong credentials";
		}
	}

}
