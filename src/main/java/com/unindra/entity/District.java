package com.unindra.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reg_districts")
public class District {

    @Id
    private String id;

    private String name;
    
    @ManyToOne
    @JoinColumn(name = "regency_id")
    private Regency regency;

    // @Id
    // @Column(length = 6)
    // private String id;

    // @ManyToOne
    // @JoinColumn(name = "regency_id", referencedColumnName = "id", nullable = false)
    // private Regency regency;

    // @Column(nullable = false)
    // private String name;
}