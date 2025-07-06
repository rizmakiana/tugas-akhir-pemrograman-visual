package com.unindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unindra.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
    
    boolean existsByName(String name);

    Department findByName(String department);

    List<Department> findAllByName(String department);
}
