package com.unindra.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "spp_transactions")
public class SPPTransaction {
    
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student; 

    private Integer monthsPaid; // misal 3 bulan

    private LocalDate paymentDate; 

    private Double totalPaid; // dihitung dari 100_000 * monthsPaid 

    @OneToMany(mappedBy = "transaction")
    private List<SPPDue> paidDues; // bulan apa saja yang dibayar 

}
