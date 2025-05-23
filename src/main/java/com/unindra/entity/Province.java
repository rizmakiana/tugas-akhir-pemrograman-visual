package com.unindra.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reg_provinces")
public class Province {

    @Id
    private String id;

    private String name;

    @OneToMany(mappedBy = "province")
    private List<Regency> regencies;

    // @Id
    // @Column(length = 2)
    // private String id;

    // @Column(nullable = false)
    // private String name;

    // // Relasi One-to-Many ke Regency
    // @OneToMany(mappedBy = "province", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // private List<Regency> regencies;
    
}
