package com.unindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unindra.entity.TeachingAssignment;

@Repository
public interface TeachingAssignmentRepository extends JpaRepository<TeachingAssignment, Long> {

    // @EntityGraph(attributePaths = "grades")
    @EntityGraph(attributePaths = { "grades", "grades.student" })
    @Query("""
                SELECT ta FROM TeachingAssignment ta
                WHERE ta.teacher.id = :teacherId
                  AND ta.course.name = :courseName
                  AND ta.section.name = :sectionName
                  AND ta.section.classroom.name = :classroomName
                  AND ta.section.classroom.department.name = :departmentName
            """)
    TeachingAssignment findByTeacherAndCourseAndSection(
            @Param("teacherId") Integer teacherId,
            @Param("departmentName") String departmentName,
            @Param("classroomName") String classroomName,
            @Param("sectionName") String sectionName,
            @Param("courseName") String courseName);

    @EntityGraph(attributePaths = { "section.students" })
    @Query("""
                SELECT ta FROM TeachingAssignment ta
                WHERE ta.teacher.id = :teacherId
                  AND ta.course.name = :courseName
                  AND ta.section.name = :sectionName
                  AND ta.section.classroom.name = :classroomName
                  AND ta.section.classroom.department.name = :departmentName
            """)
    TeachingAssignment findAssignmentWithStudents(
            @Param("teacherId") Integer teacherId,
            @Param("departmentName") String departmentName,
            @Param("classroomName") String classroomName,
            @Param("sectionName") String sectionName,
            @Param("courseName") String courseName);

	List<TeachingAssignment> findBySectionId(Integer sectionId);
            

}
