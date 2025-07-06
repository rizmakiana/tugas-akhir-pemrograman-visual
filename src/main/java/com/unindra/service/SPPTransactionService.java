package com.unindra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unindra.entity.SPPTransaction;
import com.unindra.repository.SPPTransactionRepository;

@Service
public class SPPTransactionService {
    
    @Autowired
    private SPPTransactionRepository repository;

    public void save(SPPTransaction transaction) {
        repository.save(transaction);
    }

    @Transactional
    public List<SPPTransaction> findAll() {
        return repository.findAll();
    }

    public SPPTransaction findById(Integer id) {
        return repository.findById(id).get();
    }

    public SPPTransaction findTransactionWithPaidDuesById(Long id) {
        return repository.findByIdWithPaidDues(id);
    }

    
}

