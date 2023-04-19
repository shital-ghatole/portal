package com.employee.effort.tracking.portal.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.effort.tracking.portal.entity.ProjectEffortEntity;

@Repository
public interface ProjectEffortRepository extends JpaRepository<ProjectEffortEntity, Integer> {

	@Modifying
	@Query(value = "select * from project_effort where start_date=? and end_date=?", nativeQuery = true)
	List<ProjectEffortEntity> findProject(String startDate, String endDate);

	@Modifying
	@Query(value = "select p.* from project_effort p inner join project s on s.project_id=p.project_id where (s.project_startdate BETWEEN :startDate AND :endDate)OR(s.project_enddate BETWEEN :startDate AND :endDate)", nativeQuery = true)
	List<ProjectEffortEntity> findProjectByDate(Date startDate, Date endDate);

}
