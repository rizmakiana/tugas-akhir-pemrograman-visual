package com.unindra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unindra.entity.Staff;
import com.unindra.repository.StaffRepository;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public void add(Staff staff) {

        staffRepository.save(staff);

    }

    public boolean isUsernameExist(String username) {
        return staffRepository.existsByUsername(username);
    }

    // public String generateId() {
        // String baseId = "STX4890";

        // Ambil ID terakhir yang dimulai dengan baseId
        // String lastId = staffRepository.findLastGeneratedId(baseId + "%");

        // int nextNumber = 1;
        // if (lastId != null) {
        //     String lastNumberStr = lastId.substring(baseId.length());
        //     nextNumber = Integer.parseInt(lastNumberStr) + 1;
        // }

    //     String generatedId = String.format("%04d", nextNumber);
    //     return baseId + generatedId;
    // }

}
