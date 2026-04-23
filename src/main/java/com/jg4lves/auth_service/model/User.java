package com.jg4lves.auth_service.model;

import lombok.Data;

@Data
public class User {
    private String email;
    private String password;
    private String role;
}
