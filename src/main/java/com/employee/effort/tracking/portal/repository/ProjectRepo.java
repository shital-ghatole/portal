package com.employee.effort.tracking.portal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.employee.effort.tracking.portal.entity.ProjectEntity;
import com.employee.effort.tracking.portal.entity.UserEntity;

@Repository
public interface ProjectRepo extends JpaRepository<ProjectEntity, Integer> {

	@Query("FROM UserEntity WHERE employeeid = :user")
	public List<UserEntity> getEmployees();

	/*
	 * @Query("select p.project_id, p.project_name from project") public
	 * List<Object[]> getProjectIdAndName();
	 */

	/*
	 * @Query(value = "SELECT project_name FROM project", nativeQuery = true)
	 * getting null values List<ProjectMini> findAllProjectsMini();
	 */



}
