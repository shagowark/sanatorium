package com.example.sanatorium.services;

import com.example.sanatorium.models.Role;

import java.util.Optional;

public interface RoleService extends Service<Role>{
    Optional<Role> findByName(String roleName);
}
