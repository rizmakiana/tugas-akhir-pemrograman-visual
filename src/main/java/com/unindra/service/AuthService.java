package com.unindra.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unindra.entity.Staff;
import com.unindra.entity.Student;
import com.unindra.entity.Teacher;
import com.unindra.model.request.LoginRequest;
import com.unindra.repository.StaffRepository;
import com.unindra.repository.StudentRepository;
import com.unindra.repository.TeacherRepository;

@Service
public class AuthService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StaffRepository staffRepository;
    
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private PasswordService passwordService;

    public String loginStudent(LoginRequest request) {
        
        String errorMessage = validationService.validate(request);

        if (errorMessage != null) {
            return errorMessage;
        }

        Optional<Student> optionalStudent  = studentRepository.findByUsername(request.getUsername());

        if (optionalStudent.isEmpty()) {
            return "Username atau password salah";
        }

        Student student = optionalStudent.get();

        if (!passwordService.isPasswordValid(request.getPassword(), student.getPassword())) {
            return "Username atau password salah";
        }

        return null;
    }

    public String loginStaff(LoginRequest request) {
        
        String errorMessage = validationService.validate(request);

        if (errorMessage != null) {
            return errorMessage;
        }

        Optional<Staff> optionalStaff  = staffRepository.findByUsername(request.getUsername());

        if (optionalStaff.isEmpty()) {
            return "Username atau password salah";
        }

        Staff staff = optionalStaff.get();

        if (!passwordService.isPasswordValid(request.getPassword(), staff.getPassword())) {
            return "Username atau password salah";
        }

        return null;
    }

    public String loginTeacher(LoginRequest request) {
        
        String errorMessage = validationService.validate(request);

        if (errorMessage != null) {
            return errorMessage;
        }

        Optional<Teacher> optionalTeacher  = teacherRepository.findByUsername(request.getUsername());

        if (optionalTeacher.isEmpty()) {
            return "Username atau password salah";
        }

        Teacher teacher = optionalTeacher.get();

        if (!passwordService.isPasswordValid(request.getPassword(), teacher.getPassword())) {
            return "Username atau password salah";
        }

        return null;
    }

    

}
