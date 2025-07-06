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
public class AddCourseRequest {
    
    @NotBlank(message = "Department tidak boleh kosong")
    private String department;

    @NotBlank(message = "Kelas tidak boleh kosong")
    private String classroom;

    @NotBlank(message = "Nama Mapel tidak boleh kosong")
    private String name;
}
