package com.example.sanatorium.services.impl;

import com.example.sanatorium.models.Staff;
import com.example.sanatorium.repos.StaffRepo;
import com.example.sanatorium.services.StaffService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final StaffRepo staffRepo;

    @Override
    public List<Staff> listAll() {
        return staffRepo.findAll();
    }

    @Override
    public void saveOne(Staff staff) {
        staffRepo.save(staff);
    }

    @Override
    public void deleteOneById(UUID id) {
        staffRepo.deleteById(id);
    }

    @Override
    public Staff getOneById(UUID id) {
        return staffRepo.findById(id).orElse(null);
    }

    @Override
    public void updateOne(Staff staff) throws EntityNotFoundException {
        if (getOneById(staff.getId()) == null){
            throw new EntityNotFoundException("Staff doesn't exists");
        }
        staffRepo.save(staff);
    }

    @Override
    public long count() {
        return staffRepo.count();
    }
}

