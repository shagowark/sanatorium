package com.example.sanatorium.services;

import com.example.sanatorium.models.Client;
import com.example.sanatorium.repos.ClientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepo clientRepo;

    public List<Client>listClients(){
        return clientRepo.findAll();
    }
    public void saveClient(Client client){
        clientRepo.save(client);
    }
    public void deleteClient(UUID id){
        clientRepo.deleteById(id);
    }

    public Client getClientById(UUID id){
        return clientRepo.findById(id).orElse(null);
    }

    public void updateClient(Client client){
        clientRepo.save(client);
    }
}
