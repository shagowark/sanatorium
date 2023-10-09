package com.example.sanatorium.repos;

import com.example.sanatorium.models.MedicalRoomBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRoomBookingRepo extends JpaRepository<MedicalRoomBooking, Long> {
}
