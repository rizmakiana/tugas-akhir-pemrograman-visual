package com.unindra.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {

    private String idsubject;

    private String namesubject;

    private String classroom;

    private String department;
    
}
