package com.unindra.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unindra.entity.Section;
import com.unindra.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

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

    int countBySection(Section section);

    List<Student> findByDepartment_Name(String departmentName);

    List<Student> findByClassroom_Name(String classroomName);

    List<Student> findBySection_Name(String sectionName);

    List<Student> findByDepartment_NameAndClassroom_Name(String departmentName, String classroomName);

    List<Student> findByDepartment_NameAndClassroom_NameAndSection_Name(String departmentName, String classroomName,
            String sectionName);

    List<Student> findByClassroom_NameAndSection_Name(String classroomName, String sectionName);
}
