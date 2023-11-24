package com.example.sanatorium.controllers;

import com.example.sanatorium.models.MedicalRoomBooking;
import com.example.sanatorium.models.ResidentialApartment;
import com.example.sanatorium.models.ResidentialApartmentBooking;
import com.example.sanatorium.services.MedicalRoomBookingService;
import com.example.sanatorium.services.ResidentialApartmentBookingService;
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
@RequestMapping("/medical-room-bookings")
@RequiredArgsConstructor
public class MedicalRoomBookingController {
    private final MedicalRoomBookingService medicalRoomBookingService;

    @GetMapping()
    public String medicalRoomBookings(Model model) {
        model.addAttribute("medicalRoomBookings", medicalRoomBookingService.listMedicalRoomBookings());
        return "medicalRoomBookings/medical-room-bookings";
    }

    @PostMapping("/create")
    public String createMedicalRoomBooking(MedicalRoomBooking medicalRoomBooking) {
        medicalRoomBookingService.saveMedicalRoomBookings(medicalRoomBooking);
        return "redirect:/medical-room-bookings";
    }

    @PostMapping("/delete/{id}")
    public String deleteMedicalRoomBooking(@PathVariable UUID id) {
        medicalRoomBookingService.deleteMedicalRoomBookings(id);
        return "redirect:/medical-room-bookings";
    }

    @GetMapping("/{id}")
    public String showMedicalRoomBooking(@PathVariable UUID id, Model model) {
        model.addAttribute("medicalRoomBooking", medicalRoomBookingService.getMedicalRoomBookingsById(id));
        return "medicalRoomBookings/medical-room-booking-info";
    }


    @PostMapping("/put")
    public String changeMedicalRoomBooking(MedicalRoomBooking medicalRoomBooking) {
        medicalRoomBookingService.updateMedicalRoomBookings(medicalRoomBooking);
        return "redirect:/medical-room-bookings/" + medicalRoomBooking.getId();
    }
}