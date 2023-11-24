package com.example.sanatorium.services;

import com.example.sanatorium.models.MedicalRoom;
import com.example.sanatorium.repos.MedicalRoomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MedicalRoomService {
    private final MedicalRoomRepo medicalRoomRepo;

    public List<MedicalRoom> listMedicalRooms(){
        return medicalRoomRepo.findAll();
    }

    public void saveMedicalRoom(MedicalRoom medicalRoom) {
        medicalRoomRepo.save(medicalRoom);
    }

    public void deleteMedicalRoom(UUID id) {
        medicalRoomRepo.deleteById(id);
    }

    public MedicalRoom getMedicalRoomById(UUID id) {
        return medicalRoomRepo.findById(id).orElse(null);
    }

    public void updateMedicalRoom(MedicalRoom medicalRoom) {
        medicalRoomRepo.save(medicalRoom);
    }
}
