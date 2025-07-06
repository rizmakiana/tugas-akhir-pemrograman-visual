/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unindra.service;

import com.unindra.entity.District;
import com.unindra.repository.DistrictRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rizmakiana
 */
@Service
public class DistrictService {
    
    @Autowired
    private DistrictRepository districtRepository;

    public List<District> findByRegencyId(String regencyId) {
        return districtRepository.findByRegencyId(regencyId);
    }

    public District findByName(String name) {
        return districtRepository.findByName(name);
    }
     
}
