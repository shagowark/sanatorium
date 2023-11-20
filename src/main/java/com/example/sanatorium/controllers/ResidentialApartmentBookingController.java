package com.example.sanatorium.controllers;

import com.example.sanatorium.models.ResidentialApartmentBooking;
import com.example.sanatorium.repos.ClientRepo;
import com.example.sanatorium.services.ResidentialApartmentBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

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
//        @RequestParam long apartmentBookingId,
//        @RequestParam long apartmentId,
//        @RequestParam long clientId,
//        @RequestParam LocalDateTime arrivalDateTime,
//        @RequestParam LocalDateTime departureDateTime
        //apartmentBookingService.saveApartmentBooking(apartmentBookingId, apartmentId, clientId, arrivalDateTime, departureDateTime);
        apartmentBookingService.saveApartmentBooking(apartmentBooking);
        return "redirect:/apartment-bookings";
    }

    @PostMapping("/delete/{id}")
    public String deleteApartmentBooking(@PathVariable long id) {
        apartmentBookingService.deleteApartmentBooking(id);
        return "redirect:/apartment-bookings";
    }

    @GetMapping("/{id}")
    public String showApartmentBooking(@PathVariable long id, Model model) {
        model.addAttribute("apartmentBooking", apartmentBookingService.getApartmentBookingById(id));
        return "apartmentsBooking/apartment-booking-info";
    }

//    @PostMapping("/put")
//    public String changeApartmentBooking(@RequestParam long apartmentBookingId,
//                                         @RequestParam long apartmentId,
//                                         @RequestParam long clientId,
//                                         @RequestParam LocalDateTime arrivalDateTime,
//                                         @RequestParam LocalDateTime departureDateTime) {
//        apartmentBookingService.updateApartmentBooking(apartmentBookingId, apartmentId, clientId, arrivalDateTime, departureDateTime);
//        return "redirect:/apartment-bookings/" + apartmentBookingId;
//    }

    @PostMapping("/put")
    public String changeApartmentBooking(ResidentialApartmentBooking apartmentBooking) {
        apartmentBookingService.updateApartmentBooking(apartmentBooking);
        return "redirect:/apartment-bookings/" + apartmentBooking.getId();
    }
}
