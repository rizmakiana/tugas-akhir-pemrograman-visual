package com.unindra.service;

import com.unindra.entity.District;
import com.unindra.entity.Province;
import com.unindra.entity.Regency;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class RegionService {
    

    @Autowired
    private final ProvinceService provinceService;

    @Autowired
    private final RegencyService regencyService;

    @Autowired
    private final DistrictService districtService;
    
    public String[] getAllProvinces(){
        
        return provinceService.getAll();
        
    }
    
    public String[] getRegenciesByName(String provinceName){
        
        Province province = provinceService.findByName(provinceName);

        List<Regency> regencies = regencyService.findByProvinceId(province.getId());

        return regencies.stream()
                  .map(Regency::getName)
                  .toArray(String[]::new);
    }

    public String[] getDistrictsByName(String regencyName){
        
        Regency regency = regencyService.findByName(regencyName);
        log.info("SERVICE : {}, {}",regency.getId(), regency.getName());

        List<District> districts = districtService.findByRegencyId(regency.getId());
        log.info("SERVICE : {}", districts.size());


        return districts.stream()
                  .map(District::getName)
                  .toArray(String[]::new);
                    
    }
}
