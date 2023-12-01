package com.example.sanatorium.controllers;

import com.example.sanatorium.exceptions.UserAlreadyExistAuthenticationException;
import com.example.sanatorium.models.Role;
import com.example.sanatorium.models.User;
import com.example.sanatorium.repos.RoleRepo;
import com.example.sanatorium.repos.UserRepo;
import com.example.sanatorium.services.UserService;
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
    private final UserService userService;

    @GetMapping
    public String registration(){
        return "auth/registration";
    }

    @PostMapping
    public String registerUser(User user){
        try {
            userService.createUser(user);
            return "auth/login";
        } catch (UserAlreadyExistAuthenticationException e){
            return "auth/registration";
        }
    }
}
