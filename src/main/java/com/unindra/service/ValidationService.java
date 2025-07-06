package com.unindra.service;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@Service
public class ValidationService {

    @Autowired
    private Validator validator;

    public String validate(Object request) {
        
        Set<ConstraintViolation<Object>> violations = validator.validate(request);

        if (!violations.isEmpty()) {

            for (ConstraintViolation<Object> violation : violations) {
                return violation.getMessage();
            }
        }
        return null;
    }
}
