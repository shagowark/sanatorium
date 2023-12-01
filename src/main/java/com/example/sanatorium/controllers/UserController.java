package com.example.sanatorium.controllers;

import com.example.sanatorium.models.User;
import com.example.sanatorium.services.ClientService;
import com.example.sanatorium.services.RoleService;
import com.example.sanatorium.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping()
    public String showPanel(Model model){
        model.addAttribute("users", userService.listAll());
        return "users/users";
    }

    @GetMapping("/{id}")
    public String showUser(Model model, @PathVariable UUID id){
        model.addAttribute("usr", userService.getOneById(id));
        model.addAttribute("roles", roleService.listAll());
        return "users/user-info";
    }
}
