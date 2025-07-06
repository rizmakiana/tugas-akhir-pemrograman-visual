package com.unindra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unindra.entity.SPPTransaction;

@Repository
public interface SPPTransactionRepository extends JpaRepository<SPPTransaction, Integer>{
    
    @Query("SELECT t FROM SPPTransaction t LEFT JOIN FETCH t.paidDues WHERE t.id = :id")
    SPPTransaction findByIdWithPaidDues(@Param("id") Long id);
}

    
