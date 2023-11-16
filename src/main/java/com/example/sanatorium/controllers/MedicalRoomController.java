package com.example.sanatorium.controllers;

import com.example.sanatorium.services.MedicalRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/medical_rooms")
public class MedicalRoomController {
    private final MedicalRoomService medicalRoomService;

    @GetMapping()
    public String medicalRooms(Model model){
        model.addAttribute("medicalRooms", medicalRoomService.listMedicalRooms());
        return "medical_rooms";
    }
}
