package com.unindra.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unindra.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>{
 
    boolean existsByUsername(String username);

    Optional<Teacher> findByUsername(String username);


    @Query("""
                SELECT t FROM Teacher t WHERE
                LOWER(t.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                LOWER(t.username) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                LOWER(t.email) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                LOWER(t.phoneNumber) LIKE LOWER(CONCAT('%', :keyword, '%'))
            """)
    List<Teacher> searchAllFields(@Param("keyword") String keyword);
}
