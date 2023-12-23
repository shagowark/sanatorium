package com.example.sanatorium.controllers.errors;

import com.example.sanatorium.exceptions.UserAlreadyExistAuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class WebExceptionHandler{

    @ExceptionHandler({HttpClientErrorException.class})
    public String handleException(Model model, HttpClientErrorException.Forbidden e){
        model.addAttribute("error", e.toString());
        return "errors/error";
    }

    @ExceptionHandler({UserAlreadyExistAuthenticationException.class})
    public String handleException(Model model, UserAlreadyExistAuthenticationException e){
        model.addAttribute("errorMessage", e.getMessage());
        model.addAttribute("status", HttpStatus.FORBIDDEN);
        return "errors/error";
    }
}
