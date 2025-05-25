/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unindra.repository;

import com.unindra.entity.District;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rizmakiana
 */
@Repository
public interface DistrictRepository extends JpaRepository<District, String>{
    
    District findByName(String name);

    List<District> findByRegencyId(String regencyId);


    
}
