package com.unindra.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherResponse {

    private String id;

    private String name;

    private String birthplace;

    private String birthdate;

    private String subject;
    
}
