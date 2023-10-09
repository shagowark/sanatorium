package com.example.sanatorium.repos;

import com.example.sanatorium.models.ResidentialApartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentialApartmentRepo extends JpaRepository<ResidentialApartment, Long> {
}
