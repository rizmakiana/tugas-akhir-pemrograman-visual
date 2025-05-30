package com.unindra.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserRequest {

    private String id;
    
    @NotBlank(message = "Nama harus diisi")
    private String fullName;
    
    @NotBlank(message = "Username harus diisi")
    private String username;
    
    @NotBlank(message = "Tanggal lahir harus diisi")
    private String dateBirth;

    private Integer monthBirth;
    
    @NotBlank(message = "Tahun lahir harus diisi")
    private String yearBirth;
    
    @NotBlank(message = "email harus diisi")
    @Email(message = "E-mail tidak valid")
    private String email;
    
    @NotBlank(message = "Nomor telpon harus diisi")
    @Pattern(regexp = "^08\\d{6,11}$", message = "Nomor telpon harus dimulai 08")
    private String phoneNumber;
    
    @NotBlank(message = "Provinsi harus diisi")
    private String provience;
    
    @NotBlank(message = "Kota harus diisi")
    private String city;
    
    @NotBlank(message = "Kecamatan harus diisi")
    private String district;
}
