package com.example.sanatorium.services;

import com.example.sanatorium.models.Client;

import java.util.List;
import java.util.UUID;

public interface ClientService extends Service<Client>{

    List<Client> listAll(UUID id,
                         String lastName,
                         String firstName,
                         String middleName,
                         Integer age,
                         Long passport);

}
