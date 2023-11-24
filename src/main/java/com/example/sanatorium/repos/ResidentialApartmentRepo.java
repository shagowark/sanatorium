package com.example.sanatorium.repos;

import com.example.sanatorium.models.ResidentialApartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResidentialApartmentRepo extends JpaRepository<ResidentialApartment, UUID> {
}
