package com.example.sanatorium.controllers;

import com.example.sanatorium.models.Role;
import com.example.sanatorium.models.User;
import com.example.sanatorium.repos.RoleRepo;
import com.example.sanatorium.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @GetMapping
    public String registration(){
        return "auth/registration";
    }

    @PostMapping
    public String registerUser(User user){
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null){
            return "auth/registration";
        }

        user.setActive(true);
        HashSet<Role> roles = new HashSet<>();
        roles.add(roleRepo.findByName("user"));
        user.setRoles(roles);
        userRepo.save(user);
        return "redirect:/login";
    }
}
