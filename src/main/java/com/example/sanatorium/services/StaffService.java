package com.example.sanatorium.services;

import com.example.sanatorium.models.Staff;
import com.example.sanatorium.repos.StaffRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StaffService {
    private final StaffRepo staffRepo;

    public List<Staff> listStaff(){
        return staffRepo.findAll();
    }
    public void saveStaff(Staff staff){
        staffRepo.save(staff);
    }
    public void deleteStaff(UUID id){
        staffRepo.deleteById(id);
    }

    public Staff getStaffById(UUID id){
        return staffRepo.findById(id).orElse(null);
    }

    public void updateStaff(Staff staff){
        staffRepo.save(staff);
    }
}

