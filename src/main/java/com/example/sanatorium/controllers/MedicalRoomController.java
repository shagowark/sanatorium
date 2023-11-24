package com.example.sanatorium.controllers;

import com.example.sanatorium.models.MedicalRoom;
import com.example.sanatorium.services.MedicalRoomService;
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
@RequestMapping("/medical-rooms")
public class MedicalRoomController {
    private final MedicalRoomService medicalRoomService;

    @GetMapping()
    public String medicalRooms(Model model){
        model.addAttribute("medicalRooms", medicalRoomService.listMedicalRooms());
        return "medicalRooms/medical-rooms";
    }

    @PostMapping("/create")
    public String createMedicalRoom(MedicalRoom medicalRoom){
        medicalRoomService.saveMedicalRoom(medicalRoom);
        return "redirect:/medical-rooms";
    }

    @PostMapping("/delete/{id}")
    public String deleteMedicalRoom(@PathVariable UUID id){
        medicalRoomService.deleteMedicalRoom(id);
        return "redirect:/medical-rooms";
    }

    @GetMapping("/{id}")
    public String showMedicalRoom(@PathVariable UUID id, Model model){
        model.addAttribute("medicalRoom", medicalRoomService.getMedicalRoomById(id));
        return "medicalRooms/medical-room-info";
    }

    @PostMapping("/put")
    public String changeMedicalRoom(MedicalRoom medicalRoom){
        medicalRoomService.updateMedicalRoom(medicalRoom);
        return "redirect:/medical-rooms/" + medicalRoom.getId();
    }
}
