package com.example.sanatorium.services;

import com.example.sanatorium.models.Client;
import com.example.sanatorium.models.ResidentialApartment;
import com.example.sanatorium.models.ResidentialApartmentBooking;
import com.example.sanatorium.repos.ResidentialApartmentBookingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResidentialApartmentBookingService {
    private final ClientService clientService;
    private final ResidentialApartmentService apartmentService;
    private final ResidentialApartmentBookingRepo apartmentBookingRepo;

    public List<ResidentialApartmentBooking> listApartmentBookings() {
        return apartmentBookingRepo.findAll();
    }

    public void saveApartmentBooking(ResidentialApartmentBooking apartmentBooking) {

        apartmentBookingRepo.save(apartmentBooking);
    }

    public void deleteApartmentBooking(long id) {
        apartmentBookingRepo.deleteById(id);
    }

    public ResidentialApartmentBooking getApartmentBookingById(long id) {
        return apartmentBookingRepo.findById(id).orElse(null);
    }


    public void updateApartmentBooking(ResidentialApartmentBooking apartmentBooking) {
        apartmentBookingRepo.save(apartmentBooking);
    }
}
