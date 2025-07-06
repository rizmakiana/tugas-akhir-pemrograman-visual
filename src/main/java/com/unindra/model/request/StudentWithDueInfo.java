package com.unindra.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentWithDueInfo {

    private Integer id;

    private String name;

    private String department;

    private String classroom;

    private Long unpaidCount;
}