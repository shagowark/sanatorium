package com.example.sanatorium.repos;

import com.example.sanatorium.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ClientRepo extends JpaRepository<Client, UUID>, JpaSpecificationExecutor<Client> {
}
