package com.unindra.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unindra.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String>{
 
    boolean existsByUsername(String username);

    Optional<Teacher> findByUsername(String username);


    @Query("""
                SELECT s FROM Teacher s WHERE
                LOWER(s.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                LOWER(s.username) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                LOWER(s.email) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                LOWER(s.phoneNumber) LIKE LOWER(CONCAT('%', :keyword, '%'))
            """)
    List<Teacher> searchAllFields(@Param("keyword") String keyword);
}
