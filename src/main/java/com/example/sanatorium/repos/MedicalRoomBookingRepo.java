package com.example.sanatorium.repos;

import com.example.sanatorium.models.MedicalRoomBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MedicalRoomBookingRepo extends JpaRepository<MedicalRoomBooking, UUID> {
}
