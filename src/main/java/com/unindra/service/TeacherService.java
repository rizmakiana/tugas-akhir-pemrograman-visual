package com.unindra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unindra.entity.Teacher;
import com.unindra.repository.TeacherRepository;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public void registerTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public boolean isUsernameExist(String username) {
        return teacherRepository.existsByUsername(username);
    }

    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    public List<Teacher> searchTeachers(String keyword) {

        if (keyword == null || keyword.trim().isEmpty()) {
            return teacherRepository.findAll(); // kembalikan semua kalau kosong
        }
        return teacherRepository.searchAllFields(keyword.trim());

    }

    public void deleteById(Integer id) {
        teacherRepository.deleteById(id);
    }

    public Optional<Teacher> findById(Integer id) {
        return teacherRepository.findById(id);
    }

    public Optional<Teacher> findByUsername(String username) {
        return teacherRepository.findByUsername(username);
    }
    

}

/*
 * String errorMessage = validationService.validate(request);

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

        Teacher teacher = new Teacher();
        teacher.setName(request.getFullName());
        teacher.setUsername(request.getUsername());
        teacher.setPassword(hashedPassword);
        teacher.setEmail(request.getEmail());
        teacher.setPhoneNumber(request.getPhoneNumber());
        teacher.setBirthDate(localDate);
        teacher.setBirthPlace(birthPlace);

        teacherRepository.save(teacher);

        return null;

 */
