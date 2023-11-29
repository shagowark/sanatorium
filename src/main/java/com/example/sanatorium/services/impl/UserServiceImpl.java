package com.example.sanatorium.services.impl;

import com.example.sanatorium.models.User;
import com.example.sanatorium.repos.UserRepo;
import com.example.sanatorium.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepo userRepo;
    @Override
    public List<User> listAll() {
        return userRepo.findAll();
    }

    @Override
    public void saveOne(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteOneById(UUID id) {
        userRepo.deleteById(id);
    }

    @Override
    public User getOneById(UUID id) {
       return userRepo.findById(id).orElse(null);
    }

    @Override
    public void updateOne(User user) throws EntityNotFoundException {
        if (getOneById(user.getId()) == null){
            throw new EntityNotFoundException("User doesn't exists");
        }
        userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null; //TODO + createUser
    }
}
