package com.example.sanatorium.repos;

import com.example.sanatorium.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StaffRepo extends JpaRepository<Staff, UUID> {
}
