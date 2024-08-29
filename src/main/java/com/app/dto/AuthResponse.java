package com.app.dto;

import com.app.model.Role;
import lombok.Data;

@Data
public class AuthResponse {

    private String token;
    private String message;
    private Role role;
}