package com.example.sanatorium.repos;

import com.example.sanatorium.models.ResidentialApartmentBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResidentialApartmentBookingRepo extends JpaRepository<ResidentialApartmentBooking, UUID> {
}
