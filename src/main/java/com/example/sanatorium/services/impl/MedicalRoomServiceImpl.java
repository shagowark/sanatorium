package com.example.sanatorium.services.impl;

import com.example.sanatorium.models.MedicalRoom;
import com.example.sanatorium.repos.MedicalRoomRepo;
import com.example.sanatorium.services.MedicalRoomService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MedicalRoomServiceImpl implements MedicalRoomService {
    private final MedicalRoomRepo medicalRoomRepo;

    @Override
    public List<MedicalRoom> listAll() {
        return medicalRoomRepo.findAll();
    }

    @Override
    public void saveOne(MedicalRoom medicalRoom) {
        medicalRoomRepo.save(medicalRoom);
    }

    @Override
    public void deleteOneById(UUID id) {
        medicalRoomRepo.deleteById(id);
    }

    @Override
    public MedicalRoom getOneById(UUID id) {
        return medicalRoomRepo.findById(id).orElse(null);
    }

    @Override
    public void updateOne(MedicalRoom medicalRoom) throws EntityNotFoundException {
        if (getOneById(medicalRoom.getId()) == null){
            throw new EntityNotFoundException("Medical room doesn't exists");
        }
        medicalRoomRepo.save(medicalRoom);
    }

    @Override
    public long count() {
        return medicalRoomRepo.count();
    }
}
