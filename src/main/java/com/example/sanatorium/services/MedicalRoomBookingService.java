package com.example.sanatorium.services;

import com.example.sanatorium.models.MedicalRoomBooking;
import com.example.sanatorium.repos.MedicalRoomBookingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MedicalRoomBookingService {
    private final MedicalRoomBookingRepo medicalRoomBookingRepo;

    public List<MedicalRoomBooking> listMedicalRoomBookings() {
        return medicalRoomBookingRepo.findAll();
    }

    public void saveMedicalRoomBookings(MedicalRoomBooking medicalRoomBooking) {
        medicalRoomBookingRepo.save(medicalRoomBooking);
    }

    public void deleteMedicalRoomBookings(UUID id) {
        medicalRoomBookingRepo.deleteById(id);
    }

    public MedicalRoomBooking getMedicalRoomBookingsById(UUID id) {
        return medicalRoomBookingRepo.findById(id).orElse(null);
    }


    public void updateMedicalRoomBookings(MedicalRoomBooking medicalRoomBooking) {
        medicalRoomBookingRepo.save(medicalRoomBooking);
    }
}
