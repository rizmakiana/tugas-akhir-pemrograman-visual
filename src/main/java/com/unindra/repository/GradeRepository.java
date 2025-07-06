package com.unindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unindra.entity.Grade;
import com.unindra.entity.TeachingAssignment;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long>{

    List<Grade> findByTeachingAssignment(TeachingAssignment assignment);

    
}
