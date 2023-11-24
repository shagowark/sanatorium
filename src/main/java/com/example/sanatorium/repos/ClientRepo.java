package com.example.sanatorium.repos;

import com.example.sanatorium.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepo extends JpaRepository<Client, UUID> {
}
