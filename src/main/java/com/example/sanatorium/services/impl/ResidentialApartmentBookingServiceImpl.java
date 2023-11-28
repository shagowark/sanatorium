package com.example.sanatorium.services.impl;

import com.example.sanatorium.models.Client;
import com.example.sanatorium.models.ResidentialApartment;
import com.example.sanatorium.models.ResidentialApartmentBooking;
import com.example.sanatorium.repos.ResidentialApartmentBookingRepo;
import com.example.sanatorium.services.ResidentialApartmentBookingService;
import com.example.sanatorium.services.ResidentialApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ResidentialApartmentBookingServiceImpl implements ResidentialApartmentBookingService {
    private final ResidentialApartmentBookingRepo apartmentBookingRepo;

    @Override
    public List<ResidentialApartmentBooking> listAll() {
        return apartmentBookingRepo.findAll();
    }

    @Override
    public void saveOne(ResidentialApartmentBooking apartmentBooking) {
        apartmentBookingRepo.save(apartmentBooking);
    }

    @Override
    public void deleteOneById(UUID id) {
        apartmentBookingRepo.deleteById(id);
    }

    @Override
    public ResidentialApartmentBooking getOneById(UUID id) {
        return apartmentBookingRepo.findById(id).orElse(null);
    }

    @Override
    public void updateOne(ResidentialApartmentBooking apartmentBooking) {
        apartmentBookingRepo.save(apartmentBooking);
    }
}
