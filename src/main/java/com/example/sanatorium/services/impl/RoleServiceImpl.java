package com.example.sanatorium.services.impl;

import com.example.sanatorium.models.Role;
import com.example.sanatorium.repos.RoleRepo;
import com.example.sanatorium.services.RoleService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;

    @Override
    public List<Role> listAll() {
        return roleRepo.findAll();
    }

    @Override
    public void saveOne(Role role) {
        roleRepo.save(role);
    }

    @Override
    public void deleteOneById(UUID id) {
        roleRepo.deleteById(id);
    }

    @Override
    public Role getOneById(UUID id) {
        return roleRepo.findById(id).orElse(null);
    }

    @Override
    public void updateOne(Role role) throws EntityNotFoundException {
        if (getOneById(role.getId()) == null){
            throw new EntityNotFoundException("Role doesn't exists");
        }
        roleRepo.save(role);
    }

    @Override
    public Optional<Role> findByName(String roleName) {
        return roleRepo.findByName(roleName);
    }
}
