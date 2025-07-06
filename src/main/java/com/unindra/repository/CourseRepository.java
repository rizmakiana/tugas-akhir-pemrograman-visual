package com.unindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unindra.entity.Classroom;
import com.unindra.entity.Course;
import com.unindra.entity.Department;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	@Query("SELECT COUNT(c) > 0 FROM Course c " +
			"WHERE c.name = :courseName " +
			"AND c.department = :department " +
			"AND c.classroom = :classroom")
	boolean existsByNameAndDepartmentAndClassroom(
			@Param("courseName") String courseName,
			@Param("department") Department department,
			@Param("classroom") Classroom classroom);

	List<Course> findByDepartment(Department department);

	List<Course> findByClassroom(Classroom classroom);

	List<Course> findByDepartmentAndClassroom(Department department, Classroom classroom);

}
