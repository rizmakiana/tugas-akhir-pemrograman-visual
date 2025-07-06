package com.unindra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unindra.entity.Staff;
import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer>{
    
    boolean existsByUsername(String username);

    Optional<Staff> findByUsername(String username);

    // @Query("SELECT s.id FROM Staff s WHERE s.id LIKE :prefix ORDER BY s.id DESC LIMIT 1")
    // String findLastGeneratedId(@Param("prefix") String prefix);

}
