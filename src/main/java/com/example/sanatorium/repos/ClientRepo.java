package com.example.sanatorium.repos;

import com.example.sanatorium.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {
}
