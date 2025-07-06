package com.unindra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unindra.entity.Section;
import com.unindra.entity.Student;

import com.unindra.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void registerStudent(Student student) {

        studentRepository.save(student);

    }

    public void edit(Student student) {

        studentRepository.save(student);

    }

    public Optional<Student> findById(Integer id) {
        return studentRepository.findById(id);
    }

    public boolean isUsernameExist(String username) {

        return studentRepository.existsByUsername(username);

    }

    @Transactional
    public List<Student> findAll() {

        return studentRepository.findAll();

    }
    

    public Optional<Student> findStudentByUsername(String username) {

        return studentRepository.findByUsername(username);

    }

    public List<Student> searchStudents(String keyword) {

        if (keyword == null || keyword.trim().isEmpty()) {
            return studentRepository.findAll(); // kembalikan semua kalau kosong
        }
        return studentRepository.searchAllFields(keyword.trim());

    }

    public void deleteById(Integer id) {

        studentRepository.deleteById(id);

    }

    public String generateId() {

        String baseId = "20254350";
        long count = studentRepository.count();
        String generatedId = String.format("%04d", count);

        return baseId + generatedId;

    }

    public Optional<Student> findStudentById(Integer id) {

        return studentRepository.findById(id);

    }

    public int countBySection(Section section) {

        return studentRepository.countBySection(section);

    }

    public List<Student> findByDepartmentName(String departmentName) {
        return studentRepository.findByDepartment_Name(departmentName);
    }

    public List<Student> findByClassroomName(String classroomName) {
        return studentRepository.findByClassroom_Name(classroomName);
    }

    public List<Student> findBySectionName(String sectionName) {
        return studentRepository.findBySection_Name(sectionName);
    }

    public List<Student> findByDepartmentAndClassroom(String departmentName, String classroomName) {
        return studentRepository.findByDepartment_NameAndClassroom_Name(departmentName, classroomName);
    }

    public List<Student> findByDepartmentClassroomSection(String departmentName, String classroomName,
            String sectionName) {
        return studentRepository.findByDepartment_NameAndClassroom_NameAndSection_Name(departmentName, classroomName,
                sectionName);
    }

    public List<Student> findByClassroomAndSection(String classroomName, String sectionName) {
        return studentRepository.findByClassroom_NameAndSection_Name(classroomName, sectionName);
    }

}
