package com.example.sanatorium.repos;

import com.example.sanatorium.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepo extends JpaRepository<Role, UUID> {
    Role findByName(String name);
}
