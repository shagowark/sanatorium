package com.example.sanatorium.services;

import com.example.sanatorium.exceptions.UserAlreadyExistAuthenticationException;
import com.example.sanatorium.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends Service<User>, UserDetailsService {
     void createUser(User user) throws UserAlreadyExistAuthenticationException;
}
