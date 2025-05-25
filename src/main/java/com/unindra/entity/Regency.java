package com.unindra.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reg_regencies")
public class Regency {

    @Id
    private String id;

    private String name;

    @OneToMany(mappedBy = "regency")
    private List<District> districts;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;

    // @Id
    // @Column(length = 4)
    // private String id;

    // @ManyToOne
    // @JoinColumn(name = "province_id", referencedColumnName = "id", nullable = false)
    // private Province province;

    // @Column(nullable = false)
    // private String name;

    // // Relasi One-to-Many ke District
    // @OneToMany(mappedBy = "regency", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // private List<District> districts;
    
}
