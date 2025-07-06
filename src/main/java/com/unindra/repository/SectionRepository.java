package com.unindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unindra.entity.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, Integer> {

	@Query("SELECT DISTINCT s.name FROM Section s")
	List<String> findDistinctSectionNames();
	
	@Query("SELECT s FROM Section s WHERE s.classroom.name = :classroomName")
	List<Section> findByClassroomName(@Param("classroomName") String classroomName);


}
