package com.example.sanatorium.repos;

import com.example.sanatorium.models.MedicalRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MedicalRoomRepo extends JpaRepository<MedicalRoom, UUID> {
}
