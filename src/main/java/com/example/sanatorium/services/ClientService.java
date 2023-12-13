package com.example.sanatorium.services;

import com.example.sanatorium.models.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ClientService extends Service<Client> {

    Page<Client> listAll(
            UUID id,
            String lastName,
            String firstName,
            String middleName,
            Integer age,
            Long passport,
            Pageable pageable);

}
