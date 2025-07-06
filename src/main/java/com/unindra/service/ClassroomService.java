package com.unindra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unindra.entity.Classroom;
import com.unindra.entity.Department;
import com.unindra.repository.ClassroomRepository;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    public Classroom add(Department department, String classroom) {

        Classroom c = new Classroom();
        c.setDepartment(department);
        c.setName(classroom);

        classroomRepository.save(c);

        return c;

    }

    public void update(Classroom classroom) {
        classroomRepository.save(classroom);
    }

    public List<Classroom> findClassrooms() {

        return classroomRepository.findAll();

    }

    public Classroom findById(Integer id) {

        return classroomRepository.findById(id).orElse(null);
    }

    public List<String> findDistinctClassroomByDepartment(String departmentName) {
        return classroomRepository.findDistinctClassroomNamesByDepartment(departmentName);
    }

    public Classroom findByDepartmentAndName(Department department, String classroom) {

        return classroomRepository.findByDepartmentAndName(department, classroom);
    }

    public Classroom save(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public List<String> findDistinctClassroomName() {
        return classroomRepository.findDistinctClassroomNames();
    }

    public List<Classroom> findByDepartment(Department department) {

        return classroomRepository.findByDepartment(department);
    }

    public List<Classroom> findAllByName(String section) {

        return classroomRepository.findAllByName(section);
    }

    public List<String> getDistinctClassroom() {
        return classroomRepository.findDistinctClassroomNames();
    }

    public void deleteById(Integer id) {
        classroomRepository.deleteById(id);
    }

}
