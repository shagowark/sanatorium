package com.example.sanatorium.services.impl;

import com.example.sanatorium.exceptions.UserAlreadyExistAuthenticationException;
import com.example.sanatorium.models.Role;
import com.example.sanatorium.models.User;
import com.example.sanatorium.repos.UserRepo;
import com.example.sanatorium.services.RoleService;
import com.example.sanatorium.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepo userRepo;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
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
    public void updateWithRolesFromForm(User user, Map<String, String> form) {
        List<String> roleNames = roleService.listAll().stream().map(Role::getName).toList();
        user.getRoles().clear();

        form.keySet().forEach(r -> {
            if (roleNames.contains(r)){
                user.getRoles().add(
                        roleService.findByName(r).orElse(null)
                );
            }
        });
        updateOne(user);
    }

    public Optional<User> findByUsername(String username){
        return userRepo.findByUsername(username);
    }

    public void createUser(User user) throws UserAlreadyExistAuthenticationException{
        User userFromDb = userRepo.findByUsername(user.getUsername()).orElse(null);

        if (userFromDb != null){
            throw new UserAlreadyExistAuthenticationException(
                    String.format("User '%s' already exists", user.getUsername()));
        }

        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(roleService.findByName("user").get()));
        userRepo.save(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("Пользователь '%s' не найден", username)
        ));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream().map(role ->
                        new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet())
        );
    }
}
