package com.example.sanatorium.controllers;

import com.example.sanatorium.models.ResidentialApartmentBooking;
import com.example.sanatorium.services.ResidentialApartmentBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/apartment-bookings")
@RequiredArgsConstructor
public class ResidentialApartmentBookingController {
    private final ResidentialApartmentBookingService apartmentBookingService;

    @GetMapping()
    public String apartmentBookings(Model model) {
        model.addAttribute("apartmentBookings", apartmentBookingService.listAll());
        return "apartmentsBooking/apartment-bookings";
    }

    @PostMapping("/create")
    public String createApartmentBooking(ResidentialApartmentBooking apartmentBooking) {
        apartmentBookingService.saveOne(apartmentBooking);
        return "redirect:/apartment-bookings";
    }

    @PostMapping("/delete/{id}")
    public String deleteApartmentBooking(@PathVariable UUID id) {
        apartmentBookingService.deleteOneById(id);
        return "redirect:/apartment-bookings";
    }

    @GetMapping("/{id}")
    public String showApartmentBooking(@PathVariable UUID id, Model model) {
        model.addAttribute("apartmentBooking", apartmentBookingService.getOneById(id));
        return "apartmentsBooking/apartment-booking-info";
    }


    @PostMapping("/put")
    public String changeApartmentBooking(ResidentialApartmentBooking apartmentBooking) {
        apartmentBookingService.updateOne(apartmentBooking);
        return "redirect:/apartment-bookings/" + apartmentBooking.getId();
    }
}
