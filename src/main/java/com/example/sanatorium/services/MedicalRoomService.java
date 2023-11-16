package com.example.sanatorium.services;

import com.example.sanatorium.models.MedicalRoom;
import com.example.sanatorium.repos.MedicalRoomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalRoomService {
    private final MedicalRoomRepo medicalRoomRepo;

    public List<MedicalRoom> listMedicalRooms(){
        return medicalRoomRepo.findAll();
    }
}
