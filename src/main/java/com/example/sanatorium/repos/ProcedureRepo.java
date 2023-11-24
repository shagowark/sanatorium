package com.example.sanatorium.repos;

import com.example.sanatorium.models.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProcedureRepo extends JpaRepository<Procedure, UUID> {
}
