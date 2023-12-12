package com.example.sanatorium.services.impl;

import com.example.sanatorium.models.Client;
import com.example.sanatorium.repos.ClientRepo;
import com.example.sanatorium.services.ClientService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepo clientRepo;

    @Override
    public List<Client> listAll() {
        return clientRepo.findAll();
    }

    @Override
    public List<Client> listAll(String firstName, Integer age) {
        Specification<Client> clientFirstNameSpecification = getSpecialization("firstName", firstName);
        Specification<Client> clientAgeSpecification = getSpecialization("age", age);
        return clientRepo.findAll(Specification.where(clientFirstNameSpecification).and(clientAgeSpecification));
    }

    @Override
    public void saveOne(Client client) {
        clientRepo.save(client);
    }

    @Override
    public void deleteOneById(UUID id) {
        clientRepo.deleteById(id);
    }

    @Override
    public Client getOneById(UUID id) {
        return clientRepo.findById(id).orElse(null);
    }

    @Override
    public void updateOne(Client client) throws EntityNotFoundException {
        if (getOneById(client.getId()) == null) {
            throw new EntityNotFoundException("Client doesn't exists");
        }
        clientRepo.save(client);
    }

    public long count(){
        return clientRepo.count();
    }

    private Specification<Client> getSpecialization(String rootFieldName, Object value) {
        if (value == null){
            return null;
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(rootFieldName), value);
    }
}
