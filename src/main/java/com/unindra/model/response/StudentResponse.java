package com.unindra.model.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rizmakiana
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    
    private String id;

    private String name;
    
    private String gender;
    
    private String birthplace;
    
    private String birthdate;

    private String department;

    private String classroom;
}
