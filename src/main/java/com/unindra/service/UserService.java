package com.unindra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unindra.entity.Student;
import com.unindra.entity.Teacher;
import com.unindra.model.RegisterRequest;
import com.unindra.model.RegisterUserRequest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private final StudentService studentService;

    @Autowired
    private final TeacherService teacherService;

    @Autowired
    private final StaffService staffService;

    public String addStudent(RegisterRequest request) {
        return studentService.add(request);
    }

    public String addUser(String role, RegisterUserRequest request) {

        String errorMessage;

        switch (role) {
            case "teacher":
                errorMessage = teacherService.add(request);
                break;
            case "student":
                errorMessage = studentService.add(request);
                break;
            default:
                errorMessage = null;
                break;
        }

        return errorMessage;
    }

    public Student findStudentByUsername(String username) {
        Optional<Student> studentByUsername = studentService.findStudentByUsername(username);

        return studentByUsername.get();
    }

    public List<Student> getAllStudent() {
        return studentService.getAll();
    }

    public String editUser(String role, RegisterUserRequest request) {
        String errorMessage;

        switch (role) {
            case "teacher":
                errorMessage = teacherService.edit(request);
                break;
            case "student":
                errorMessage = studentService.edit(request);
                break;
            default:
                errorMessage = null;
                break;
        }

        return errorMessage;
    }

    public void deleteUserById(String role, String id) {
        switch (role) {
            case "teacher":
                teacherService.deleteById(id);
                break;
            case "student":
                studentService.deleteById(id);
                break;
            default:
                break;
        }
    }

    public List<Student> searchStundets(String keyword) {
        return studentService.searchStudents(keyword);
    }

    public List<Teacher> searchTeachers(String keyword) {
        return teacherService.searchTeachers(keyword);
    }

    public List<Teacher> getAllTeacher() {
        return teacherService.getAll();
    }

    public Teacher findTeacherByUsername(String username) {
        
        Optional<Teacher> teacherOptional = teacherService.findTeacherByUsername(username);
        
        return teacherOptional.get();
    }
}
