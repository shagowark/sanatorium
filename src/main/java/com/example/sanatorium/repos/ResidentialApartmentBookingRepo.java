package com.example.sanatorium.repos;

import com.example.sanatorium.models.ResidentialApartmentBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentialApartmentBookingRepo extends JpaRepository<ResidentialApartmentBooking, Long> {
}
