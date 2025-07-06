package com.unindra.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "teachers")
public class Teacher extends User{

    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
    private List<TeachingAssignment> teachingAssignments;
}