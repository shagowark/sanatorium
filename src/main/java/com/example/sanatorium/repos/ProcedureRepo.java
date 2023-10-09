package com.example.sanatorium.repos;

import com.example.sanatorium.models.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureRepo extends JpaRepository<Procedure, Long> {
}
