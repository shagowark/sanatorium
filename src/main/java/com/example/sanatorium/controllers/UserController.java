package com.example.sanatorium.controllers;

import com.example.sanatorium.models.Role;
import com.example.sanatorium.models.User;
import com.example.sanatorium.services.RoleService;
import com.example.sanatorium.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public String showUser(Model model, @PathVariable("id") User user){
        model.addAttribute("usr", user);
        model.addAttribute("roles", roleService.listAll(););
        return "users/user-info";
    }

    @PostMapping() //TODO включить security обратно
    public String putUser(@RequestParam("id") User user,
                          @RequestParam Map<String, String> form){
        userService.updateWithRolesFromForm(user, form);
        return "redirect:/users/" + user.getId();
    }
}
