package com.employee.effort.tracking.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.employee.effort.tracking.portal.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

	UserEntity findByemployeeid(int employeeid);

	UserEntity findByUsername(String username);

	@Query(value = "SELECT user_name FROM user_entity", nativeQuery = true)
	List<String> getuserName();

}
