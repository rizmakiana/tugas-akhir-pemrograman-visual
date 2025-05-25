/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unindra.service;

import com.unindra.entity.District;
import com.unindra.repository.DistrictRepository;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 *
 * @author rizmakiana
 */
@Service
@AllArgsConstructor
public class DistrictService {
    
    private final DistrictRepository districtRepository;

    public List<District> findByRegencyId(String regencyId) {
        return districtRepository.findByRegencyId(regencyId);
    }

    public District findByName(String name) {
        return districtRepository.findByName(name);
    }
     
}
