package com.unindra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unindra.entity.Province;
import com.unindra.repository.ProvinceRepository;

@Service
public class ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    public Province findByName(String provinceName) {
        return provinceRepository.findByName(provinceName);
    }

    
}
