package com.example.sanatorium.services.impl;

import com.example.sanatorium.models.MedicalRoomBooking;
import com.example.sanatorium.repos.MedicalRoomBookingRepo;
import com.example.sanatorium.services.MedicalRoomBookingService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MedicalRoomBookingServiceImpl implements MedicalRoomBookingService {
    private final MedicalRoomBookingRepo medicalRoomBookingRepo;

    @Override
    public List<MedicalRoomBooking> listAll() {
        return medicalRoomBookingRepo.findAll();
    }

    @Override
    public void saveOne(MedicalRoomBooking medicalRoomBooking) {
        medicalRoomBookingRepo.save(medicalRoomBooking);
    }

    @Override
    public void deleteOneById(UUID id) {
        medicalRoomBookingRepo.deleteById(id);
    }

    @Override
    public MedicalRoomBooking getOneById(UUID id) {
        return medicalRoomBookingRepo.findById(id).orElse(null);
    }


    @Override
    public void updateOne(MedicalRoomBooking medicalRoomBooking) throws EntityNotFoundException {
        if (getOneById(medicalRoomBooking.getId()) == null){
            throw new EntityNotFoundException("Medical room booking doesn't exists");
        }
        medicalRoomBookingRepo.save(medicalRoomBooking);
    }

    @Override
    public long count() {
        return medicalRoomBookingRepo.count();
    }
}
