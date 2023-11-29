package com.example.sanatorium.services.impl;

import com.example.sanatorium.models.Procedure;
import com.example.sanatorium.repos.ProcedureRepo;
import com.example.sanatorium.services.ProcedureService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProcedureServiceImpl implements ProcedureService {
    private final ProcedureRepo procedureRepo;

    @Override
    public List<Procedure> listAll() {
        return procedureRepo.findAll();
    }

    @Override
    public void saveOne(Procedure procedure) {
        procedureRepo.save(procedure);
    }

    @Override
    public void deleteOneById(UUID id) {
        procedureRepo.deleteById(id);
    }

    @Override
    public Procedure getOneById(UUID id) {
        return procedureRepo.findById(id).orElse(null);
    }

    @Override
    public void updateOne(Procedure procedure) throws EntityNotFoundException {
        if (getOneById(procedure.getId()) == null){
            throw new EntityNotFoundException("Procedure doesn't exists");
        }
        procedureRepo.save(procedure);
    }
}
