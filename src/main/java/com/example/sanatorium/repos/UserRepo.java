package com.example.sanatorium.repos;

import com.example.sanatorium.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {
    User findByUsername(String username);
}
