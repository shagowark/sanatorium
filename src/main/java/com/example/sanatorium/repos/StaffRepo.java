package com.example.sanatorium.repos;

import com.example.sanatorium.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepo extends JpaRepository<Staff, Long> {
}
