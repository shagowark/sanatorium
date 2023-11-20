package com.example.sanatorium.services;

import com.example.sanatorium.models.Client;
import com.example.sanatorium.models.ResidentialApartment;
import com.example.sanatorium.repos.ResidentialApartmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResidentialApartmentService {
    private final ResidentialApartmentRepo apartmentRepo;

    public List<ResidentialApartment> listApartments(){
        return apartmentRepo.findAll();
    }
    public ResidentialApartment getResidentialApartmentById(long id){
        return apartmentRepo.findById(id).orElse(null);
    }

    public void saveApartment(ResidentialApartment apartment){
        apartmentRepo.save(apartment);
    }

}
