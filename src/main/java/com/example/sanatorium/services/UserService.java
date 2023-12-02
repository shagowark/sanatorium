package com.example.sanatorium.services;

import com.example.sanatorium.exceptions.UserAlreadyExistAuthenticationException;
import com.example.sanatorium.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Map;

public interface UserService extends Service<User>, UserDetailsService {
     void createUser(User user) throws UserAlreadyExistAuthenticationException;
     void updateWithRolesFromForm(User user, Map<String, String> form);
}
