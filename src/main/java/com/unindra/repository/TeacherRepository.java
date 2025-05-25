package com.unindra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unindra.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String>{
 
    boolean existsByUsername(String username);

    Optional<Teacher> findByUsername(String username);
}
