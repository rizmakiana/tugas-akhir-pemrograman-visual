package com.unindra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unindra.entity.Attendance;
import com.unindra.repository.AttendanceRepository;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository repository;

    public void save(Attendance attendance) {
        repository.save(attendance);
    }

    public List<Integer> findExistingMeetingNumbers(Long teachingAssignmentId) {
        return repository.findDistinctMeetingByAssignmentId(teachingAssignmentId);
    }

    public boolean existsByAssignmentAndMeeting(Long assignmentId, int meetingNumber) {
        return repository.existsByAssignmentIdAndMeeting(assignmentId, meetingNumber);

    }

    public List<Attendance> findAttendacesByTeachingAssignmentId(Long id) {
        return repository.findAttendancesByTeachingAssignmentId(id);
    }

    public void delete(Attendance attendance) {
        repository.delete(attendance);
    }

}
