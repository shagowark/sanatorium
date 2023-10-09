package com.example.sanatorium.repos;

import com.example.sanatorium.models.MedicalRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRoomRepo extends JpaRepository<MedicalRoom, Long> {
}
