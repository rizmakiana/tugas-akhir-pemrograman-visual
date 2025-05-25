package com.unindra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unindra.entity.Regency;
import java.util.List;

@Repository
public interface RegencyRepository extends JpaRepository<Regency, String>{
    
    List<Regency> findByProvinceId(String id);

    Regency findByName(String name);
}
