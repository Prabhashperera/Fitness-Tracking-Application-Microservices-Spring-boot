package com.fitness.userservice.service;

import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.model.User;
import com.fitness.userservice.repo.UserRepo;
import com.fitness.userservice.response.UserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepo userRepo;

    public UserResponse register(@Valid RegisterRequest request) {

        if (userRepo.existsByEmail(request.getEmail())) throw new RuntimeException("Email Already Registered");

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        User savedUser = userRepo.save(user);
        UserResponse response = new UserResponse();
        response.setUserId(savedUser.getUserId());
        response.setEmail(savedUser.getEmail());
        response.setPassword(savedUser.getPassword());
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());
        response.setCreatedAt(savedUser.getCreatedAt());
        response.setUpdatedAt(savedUser.getUpdatedAt());

        return response;
    }

    public UserResponse getUserProfile(String userID) {
        User userById = userRepo.findUserByUserId(userID);
        UserResponse response = new UserResponse();
        response.setUserId(userById.getUserId());
        response.setEmail(userById.getEmail());
        response.setPassword(userById.getPassword());
        response.setFirstName(userById.getFirstName());
        response.setLastName(userById.getLastName());
        response.setCreatedAt(userById.getCreatedAt());
        response.setUpdatedAt(userById.getUpdatedAt());

        return response;
    }
}
