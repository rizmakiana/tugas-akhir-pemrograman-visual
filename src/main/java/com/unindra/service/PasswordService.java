package com.unindra.service;

import org.springframework.stereotype.Service;

import com.unindra.security.BCrypt;

@Service
public class PasswordService {
    
    public boolean isPasswordEquals(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    public String generateHashPw(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean isPasswordValid(String password, String hashPassword) {
        return BCrypt.checkpw(password, hashPassword);
    }

}
