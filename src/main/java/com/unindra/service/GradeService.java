package com.unindra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unindra.entity.Grade;
import com.unindra.entity.Student;
import com.unindra.entity.TeachingAssignment;
import com.unindra.repository.GradeRepository;

@Service
public class GradeService {

    @Autowired
    private GradeRepository repository;

    public List<Grade> findByTeachingAssignment(TeachingAssignment assignment) {
        return repository.findByTeachingAssignment(assignment);
    }

    public void save(Grade grade) {
        repository.save(grade);
    }

    public void saveAll(List<Grade> grades) {
        repository.saveAll(grades);
    }

    public boolean existsByStudentAndTeachingAssignment(Student student, TeachingAssignment assignment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsByStudentAndTeachingAssignment'");
    }

    public void delete(Grade grade) {
        repository.delete(grade);
    }



}
