package com.unindra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unindra.entity.Department;
import com.unindra.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DepartmentService {
    
    @Autowired
    private DepartmentRepository repository;

    public List<Department> findDepartments() {

        return repository.findAll();

    }

    public void register(Department department) {
        repository.save(department);
    }

    public void update(Department department) {
        
        repository.save(department);

    }

    public void deleteById(Integer id) {
        
        repository.deleteById(id);
        
    }

    public Department findById(Integer id) {
        
        return repository.findById(id).orElse(null);

    }

    public boolean isDepartmentExist(String name) {
        return repository.existsByName(name);
    }

    public Department findByName(String department) {
        
        return repository.findByName(department);
    }

    public List<Department> findAllByName(String department) {
        return repository.findAllByName(department);
    }

    

}
