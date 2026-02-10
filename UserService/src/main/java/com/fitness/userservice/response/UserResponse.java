package com.fitness.userservice.response;

import com.fitness.userservice.model.UserRole;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse {
    private String userId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private UserRole userRole = UserRole.USER;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
