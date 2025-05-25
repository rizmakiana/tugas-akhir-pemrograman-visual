package com.unindra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unindra.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>{

    boolean existsByUsername(String username);

    Optional<Student> findByUsername(String username);
}
