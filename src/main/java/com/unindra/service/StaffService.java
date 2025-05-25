package com.unindra.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unindra.entity.Staff;
import com.unindra.model.RegisterRequest;
import com.unindra.repository.StaffRepository;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

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

        Staff staff = new Staff();
        staff.setName(request.getFullName());
        staff.setUsername(request.getUsername());
        staff.setPassword(hashedPassword);
        staff.setEmail(request.getEmail());
        staff.setPhoneNumber(request.getPhoneNumber());
        staff.setBirthDate(localDate);
        staff.setBirthPlace(birthPlace);

        staffRepository.save(staff);

        return null;
    }

    public boolean isUsernameExist(String username) {
        return staffRepository.existsByUsername(username);
    }
}
