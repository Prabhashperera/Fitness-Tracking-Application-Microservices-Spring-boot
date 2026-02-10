package com.fitness.userservice.dto;

import com.fitness.userservice.model.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegisterRequest {
    @NotBlank(message = "Email is Required!")
    @Email(message = "Invalid Email Format")
    private String email;
    @NotBlank(message = "Password is Required")
    @Size(min = 6, message = "Password At Least 6 Characters")
    private String password;
    private String firstName;
    private String lastName;
}
