package com.unindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unindra.entity.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    @Query("SELECT DISTINCT a.meetingNumber FROM Attendance a WHERE a.teachingAssignment.id = :assignmentId")
    List<Integer> findDistinctMeetingByAssignmentId(@Param("assignmentId") Long assignmentId);

    @Query("SELECT COUNT(a) > 0 FROM Attendance a WHERE a.teachingAssignment.id = :assignmentId AND a.meetingNumber = :meeting")
    boolean existsByAssignmentIdAndMeeting(@Param("assignmentId") Long assignmentId,
            @Param("meeting") int meetingNumber);

    List<Attendance> findAttendancesByTeachingAssignmentId(Long teachingAssignmentId);
}
