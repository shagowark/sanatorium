package com.example.sanatorium.controllers;

import com.example.sanatorium.models.ResidentialApartment;
import com.example.sanatorium.services.ResidentialApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/apartments")
public class ResidentialApartmentController {
    private final ResidentialApartmentService apartmentService;

    @GetMapping
    public String apartments(Model model){
        model.addAttribute("apartments", apartmentService.listApartments());
        return "apartments/apartments";
    }

    @PostMapping("/create")
    public String createApartment(ResidentialApartment apartment){
        apartmentService.saveApartment(apartment);
        return "redirect:/apartments";
    }

    @PostMapping("/delete/{id}")
    public String deleteApartment(@PathVariable UUID id){
        apartmentService.deleteApartment(id);
        return "redirect:/apartments";
    }

    @GetMapping("/{id}")
    public String showApartment(@PathVariable UUID id, Model model){
        model.addAttribute("apartment", apartmentService.getApartmentById(id));
        return "apartments/apartment-info";
    }

    @PostMapping("/put")
    public String changeApartment(ResidentialApartment apartment){
        apartmentService.updateApartment(apartment);
        return "redirect:/apartments/" + apartment.getId();
    }
}
