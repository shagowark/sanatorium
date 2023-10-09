package com.example.sanatorium.controllers;

import com.example.sanatorium.models.*;
import com.example.sanatorium.repos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class Generatr {

    private final MedicalRoomBookingRepo medicalRoomBookingRepo;
    private final ClientRepo clientRepo;
    private final MedicalRoomRepo medicalRoomRepo;
    private final StaffRepo staffRepo;
    private final ProcedureRepo procedureRepo;

    public void generate(){
        Client client = clientRepo.findById((long) 2).orElse(null);
        MedicalRoom room = medicalRoomRepo.findById((long) 1).orElse(null);
        Staff staff = staffRepo.findById((long) 2).orElse(null);
        Procedure procedure = procedureRepo.findById((long) 0).orElse(null);
        MedicalRoomBooking medicalRoomBooking = new MedicalRoomBooking(1, room, procedure,
                staff, client, LocalDateTime.now(), LocalDateTime.now());
        medicalRoomBookingRepo.save(medicalRoomBooking);
    }
}
