package com.example.sanatorium.controllers;

import com.example.sanatorium.services.ResidentialApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/apartments")
public class ResidentialApartmentController {
    private final ResidentialApartmentService apartmentService;

    @GetMapping
    public String apartments(Model model){
        model.addAttribute("apartments", apartmentService.listApartments());
        return "apartments";
    }
}
