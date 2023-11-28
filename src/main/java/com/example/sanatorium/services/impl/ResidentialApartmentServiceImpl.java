package com.example.sanatorium.services.impl;

import com.example.sanatorium.models.ResidentialApartment;
import com.example.sanatorium.repos.ResidentialApartmentRepo;
import com.example.sanatorium.services.ResidentialApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ResidentialApartmentServiceImpl implements ResidentialApartmentService {
    private final ResidentialApartmentRepo apartmentRepo;

    @Override
    public List<ResidentialApartment> listAll() {
        return apartmentRepo.findAll();
    }

    @Override
    public void saveOne(ResidentialApartment apartment) {
        apartmentRepo.save(apartment);
    }

    @Override
    public void deleteOneById(UUID id) {
        apartmentRepo.deleteById(id);
    }

    @Override
    public ResidentialApartment getOneById(UUID id) {
        return apartmentRepo.findById(id).orElse(null);
    }

    @Override
    public void updateOne(ResidentialApartment apartment) {
        apartmentRepo.save(apartment);
    }
}
