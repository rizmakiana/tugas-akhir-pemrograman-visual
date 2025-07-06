package com.unindra.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTeachingAssignmentRequest {

    private Integer teacherId;

    private String departmentName;

    private String classroomName;

    private String sectionName;

    private String courseName;
    
}
