package com.unindra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unindra.entity.SPPDue;
import com.unindra.entity.Student;
import com.unindra.repository.SPPDueRepository;

@Service
public class SPPDueService {
    
    @Autowired
    private SPPDueRepository repository;

    public void saveAll(List<SPPDue> dues) {
        repository.saveAll(dues);
    }

    public long countByStudentAndPaidFalse(Student student) {
        return repository.countByStudentAndPaidFalse(student);
    }

    public void delete(SPPDue sppDue) {
        repository.delete(sppDue);
    }

    public List<SPPDue> findByStudentAndPaidFalse(Student student) {
        return repository.findByStudentAndPaidFalse(student);
    }
}
