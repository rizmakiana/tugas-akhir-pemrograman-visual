package com.unindra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unindra.entity.Classroom;
import com.unindra.entity.Course;
import com.unindra.entity.Department;
import com.unindra.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public void add(Course course) {
        repository.save(course);
    }

    public List<Course> findAll() {
        return repository.findAll();
    }

    public boolean isCourseExist(String courseName, Department department, Classroom classroom) {
        return repository.existsByNameAndDepartmentAndClassroom(courseName, department, classroom);
    }

    public String generateId() {
        String baseId = "CRS"; // Bisa diasumsikan sebagai kode sekolah, tahun angkatan, dsb.
        long count = repository.count();
        String generatedId = String.format("%04d", count);

        return baseId + generatedId;
    }

    public Optional<Course> findById(Integer id) {
        return repository.findById(id);
    }

    public void update(Course course) {
        repository.save(course);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}
