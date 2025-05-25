//package com.unindra.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.unindra.entity.Province;
//import com.unindra.repository.ProvinceRepository;
//import lombok.AllArgsConstructor;
//
//@Service
//@AllArgsConstructor
//public class ProvinceService {
//
//    @Autowired
//    private final ProvinceRepository provinceRepository;
//
//    public String[] getAll() {
//        List<Province> all  = provinceRepository.findAll();
//
//        return all.toArray(new String[0]);
//    }
//    
//}

package com.unindra.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unindra.entity.Province;
import com.unindra.repository.ProvinceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProvinceService {

    private final ProvinceRepository provinceRepository;

    public String[] getAll() {
        List<Province> all = provinceRepository.findAll();
        // Mapping dari List<Province> ke String[] nama provinsi
        return all.stream()
                  .map(Province::getName)  // asumsi Province ada method getName()
                  .toArray(String[]::new);
    }

    public Province findByName(String provinceName) {
        return provinceRepository.findByName(provinceName);
    }

    
}
