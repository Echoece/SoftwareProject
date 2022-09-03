package com.example.softwareproject.entity.DTO;

import lombok.Data;

@Data
public class UsernameAndPasswordAuthenticationRequest {
    private String userName;
    private String password;
}
