package com.unindra.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSectionRequest {

    private Integer id;

    @NotBlank(message = "Nama Section harus diisi")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Nama Section hanya boleh huruf dan spasi")
    private String name;

}
