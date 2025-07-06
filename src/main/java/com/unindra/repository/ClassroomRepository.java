package com.unindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unindra.entity.Classroom;
import com.unindra.entity.Department;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer>{

    Classroom findByDepartmentAndName(Department department, String classroom);
    
    @Query("SELECT DISTINCT c.name FROM Classroom c")
    List<String> findDistinctClassroomNames();

    List<Classroom> findByDepartment(Department department);

    List<Classroom> findAllByName(String section);

    @Query("SELECT DISTINCT c.name FROM Classroom c WHERE c.department.name = :departmentName")
    List<String> findDistinctClassroomNamesByDepartment(@Param("departmentName") String departmentName);

}
