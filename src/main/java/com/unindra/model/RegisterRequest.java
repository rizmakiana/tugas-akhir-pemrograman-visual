/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unindra.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author rizmakiana
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    
    @NotBlank
    private String fullName;
    
    @NotBlank
    private String username;
    
    @NotBlank
    private String password;
    
    private String confirmPassword;
    
    private Integer dateBirth;
    
    private String monthBirth;
    
    private String yearBirth;
    
    private String email;
    
    private String phoneNumber;
    
    private String provience;
    
    private String city;
    
    private String district;
    
    private String role;
    
}
