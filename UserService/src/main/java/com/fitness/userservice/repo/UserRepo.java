package com.fitness.userservice.repo;

import com.fitness.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    boolean existsByEmail(String email);

    User findUserByUserId(String userId);
}
