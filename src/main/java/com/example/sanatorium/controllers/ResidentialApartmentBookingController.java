package com.example.sanatorium.controllers;

import com.example.sanatorium.models.Client;
import com.example.sanatorium.models.ResidentialApartment;
import com.example.sanatorium.models.ResidentialApartmentBooking;
import com.example.sanatorium.services.ResidentialApartmentBookingService;
import jakarta.persistence.SecondaryTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;
import java.util.UUID;

@Controller
@RequestMapping("/apartment-bookings")
@RequiredArgsConstructor
public class ResidentialApartmentBookingController {
    private final ResidentialApartmentBookingService apartmentBookingService;

    @GetMapping()
    public String apartmentBooking(Model model) {
        model.addAttribute("apartmentBookings", apartmentBookingService.listApartmentBookings());
        return "apartmentsBooking/apartment-bookings";
    }

    @PostMapping("/create")
    public String createApartmentBooking(ResidentialApartmentBooking apartmentBooking) {
        apartmentBookingService.saveApartmentBooking(apartmentBooking);
        return "redirect:/apartment-bookings";
    }

    @PostMapping("/delete/{id}")
    public String deleteApartmentBooking(@PathVariable UUID id) {
        apartmentBookingService.deleteApartmentBooking(id);
        return "redirect:/apartment-bookings";
    }

    @GetMapping("/{id}")
    public String showApartmentBooking(@PathVariable UUID id, Model model) {
        ResidentialApartment apartment = apartmentBookingService.getApartmentBookingById(id).getResidentialApartment();
        Set<ResidentialApartmentBooking> asd = apartment.getResidentialApartmentBookings();
        model.addAttribute("apartmentBooking", apartmentBookingService.getApartmentBookingById(id));
        return "apartmentsBooking/apartment-booking-info";
    }


    @PostMapping("/put")
    public String changeApartmentBooking(ResidentialApartmentBooking apartmentBooking) {
        apartmentBookingService.updateApartmentBooking(apartmentBooking);
        return "redirect:/apartment-bookings/" + apartmentBooking.getId();
    }
}
