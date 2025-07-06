package com.unindra.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateClassroomRequest {

    private Integer id;

    @NotBlank(message = "Nama Kelas tidak boleh kosong")
    private String classroomName;
    
}
