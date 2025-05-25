package com.unindra.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unindra.entity.Student;
import com.unindra.model.RegisterRequest;
import com.unindra.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private PasswordService passwordService;
    
    public String add(RegisterRequest request) {
        
        String errorMessage = validationService.validate(request);

        if (errorMessage != null) {
            return errorMessage;
        }

        if (isUsernameExist(request.getUsername())) {
            return "Username sudah digunakan";
        }

        if (!passwordService.isPasswordEquals(request.getPassword(), request.getConfirmPassword())) {
            return "Password tidak sama";
        }

        String hashedPassword = passwordService.generateHashPw(request.getPassword());
        String birthPlace = String.join(", ",request.getDistrict(), request.getCity(), request.getProvience());

        Integer year = Integer.parseInt(request.getYearBirth());
        Integer month = request.getMonthBirth() + 1;
        Integer date = Integer.parseInt(request.getDateBirth());

        LocalDate localDate = LocalDate.of(year, month, date);

        Student student = new Student();
        student.setName(request.getFullName());
        student.setUsername(request.getUsername());
        student.setPassword(hashedPassword);
        student.setEmail(request.getEmail());
        student.setPhoneNumber(request.getPhoneNumber());
        student.setBirthDate(localDate);
        student.setBirthPlace(birthPlace);

        studentRepository.save(student);

        return null;
    }

    public boolean isUsernameExist(String username) {
        return studentRepository.existsByUsername(username);
    }
}
