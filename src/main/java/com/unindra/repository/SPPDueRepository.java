package com.unindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unindra.entity.SPPDue;
import com.unindra.entity.Student;

@Repository
public interface SPPDueRepository extends JpaRepository<SPPDue, Integer>{

    long countByStudentAndPaidFalse(Student student);

    List<SPPDue> findByStudentAndPaidFalse(Student student);

    
    
}
