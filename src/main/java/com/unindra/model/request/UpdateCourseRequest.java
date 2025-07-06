package com.unindra.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCourseRequest {

    private Integer id;
    
    @NotBlank(message = "Nama mata pelajaran tidak boleh kosong")
    private String name;

    private String department;

    private String classroom;
}
