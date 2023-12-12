package com.example.sanatorium.controllers;

import com.example.sanatorium.models.MedicalRoomBooking;
import com.example.sanatorium.services.MedicalRoomBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/medical-room-bookings")
@RequiredArgsConstructor
public class MedicalRoomBookingController {
    private final MedicalRoomBookingService medicalRoomBookingService;

    @GetMapping()
    public String medicalRoomBookings(Model model) {
        List<MedicalRoomBooking> medicalRoomBookings = medicalRoomBookingService.listAll();
        model.addAttribute("medicalRoomBookings", medicalRoomBookings);
        model.addAttribute("totalMedicalRoomBookingsNumber", medicalRoomBookings.size());
        return "medicalRoomBookings/medical-room-bookings";
    }

    @PostMapping("/create")
    public String createMedicalRoomBooking(MedicalRoomBooking medicalRoomBooking) {
        medicalRoomBookingService.saveOne(medicalRoomBooking);
        return "redirect:/medical-room-bookings";
    }

    @PostMapping("/delete/{id}")
    public String deleteMedicalRoomBooking(@PathVariable UUID id) {
        medicalRoomBookingService.deleteOneById(id);
        return "redirect:/medical-room-bookings";
    }

    @GetMapping("/{id}")
    public String showMedicalRoomBooking(@PathVariable UUID id, Model model) {
        model.addAttribute("medicalRoomBooking", medicalRoomBookingService.getOneById(id));
        return "medicalRoomBookings/medical-room-booking-info";
    }


    @PostMapping("/put")
    public String changeMedicalRoomBooking(MedicalRoomBooking medicalRoomBooking) {
        medicalRoomBookingService.updateOne(medicalRoomBooking);
        return "redirect:/medical-room-bookings/" + medicalRoomBooking.getId();
    }
}
