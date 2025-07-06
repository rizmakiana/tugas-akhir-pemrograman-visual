package com.unindra.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "spp_dues")
public class SPPDue {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private Integer month; // 1 = Jan, 7 = Jul

    private Integer year;

    private Boolean paid = false;

    @ManyToOne
    @JoinColumn(name = "spp_transaction_id")
    private SPPTransaction transaction;
}