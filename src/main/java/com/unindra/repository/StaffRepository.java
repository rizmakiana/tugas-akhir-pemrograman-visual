package com.unindra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unindra.entity.Staff;
import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, String>{
    
    boolean existsByUsername(String username);

    Optional<Staff> findByUsername(String username);
}
