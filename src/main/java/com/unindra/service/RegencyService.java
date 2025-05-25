package com.unindra.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unindra.entity.Regency;
import com.unindra.repository.RegencyRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class RegencyService {

    private final RegencyRepository regencyRepository;

    public List<Regency> findByProvinceId(String id) {
        return regencyRepository.findByProvinceId(id);
    }

    public Regency findByName(String name) {
        return regencyRepository.findByName(name);
    }
    
}
