package com.unindra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unindra.entity.TeachingAssignment;
import com.unindra.repository.TeachingAssignmentRepository;

@Service
public class TeachingAssignmentService {

    @Autowired
    private TeachingAssignmentRepository repository;

    public List<TeachingAssignment> findAll() {
        return repository.findAll();
    }

    public void addCourseForTeacher(TeachingAssignment assign) {
        repository.save(assign);
    }

    @Transactional
    public TeachingAssignment findByTeacherAndCourseAndSection(Integer teacherId, String departmentName, String classroomName, String sectionName, String courseName){
        return repository.findByTeacherAndCourseAndSection(teacherId, departmentName, classroomName, sectionName, courseName);
    }

    @Transactional
    public TeachingAssignment findAssignmentWithStudents(Integer teacherId, String departmentName, String classroomName, String sectionName, String courseName) {
        return repository.findAssignmentWithStudents(teacherId, departmentName, classroomName, sectionName, courseName);
    }

    public List<TeachingAssignment> findBySectionId(Integer id) {
        return repository.findBySectionId(id);
    }

    
}
