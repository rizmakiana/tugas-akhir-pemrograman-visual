package com.unindra.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unindra.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    boolean existsByUsername(String username);

    Optional<Student> findByUsername(String username);

    @Query("""
                SELECT s FROM Student s WHERE
                LOWER(s.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                LOWER(s.username) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                LOWER(s.email) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                LOWER(s.phoneNumber) LIKE LOWER(CONCAT('%', :keyword, '%'))
            """)
    List<Student> searchAllFields(@Param("keyword") String keyword);

}
