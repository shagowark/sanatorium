package com.example.sanatorium.services;

import com.example.sanatorium.models.MedicalRoom;
import com.example.sanatorium.models.Procedure;
import com.example.sanatorium.repos.MedicalRoomRepo;
import com.example.sanatorium.repos.ProcedureRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProcedureService {
    private final ProcedureRepo procedureRepo;

    public List<Procedure> listProcedures(){
        return procedureRepo.findAll();
    }

    public void saveProcedure(Procedure procedure) {
        procedureRepo.save(procedure);
    }

    public void deleteProcedure(UUID id) {
        procedureRepo.deleteById(id);
    }

    public Procedure getProcedureById(UUID id) {
        return procedureRepo.findById(id).orElse(null);
    }

    public void updateProcedure(Procedure procedure) {
        procedureRepo.save(procedure);
    }
}
