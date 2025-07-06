package com.unindra.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddDepartmentRequest {

    @NotBlank(message = "Nama jurusan tidak boleh kosong")
    private String name;

    @NotBlank(message = "Kode jurusan tidak boleh kosong")
    private String code;
    
}
