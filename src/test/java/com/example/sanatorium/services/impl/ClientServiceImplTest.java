package com.example.sanatorium.services.impl;

import com.example.sanatorium.models.Client;
import com.example.sanatorium.repos.ClientRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {
    @Mock
    private ClientRepo clientRepo;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    void listAll() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        Client client1 = new Client(id1, "LastName", "FirstName", "MiddleName", 20, 1231233L, null, null);
        Client client2 = new Client(id2, "LastName2", "FirstName2", "MiddleName2", 10, 1299999L, null, null);
        List<Client> expected = List.of(client1, client2);
        Mockito.when(clientRepo.findAll()).thenReturn(List.of(client1, client2));

        List<Client> res = clientService.listAll();
        Assertions.assertIterableEquals(expected, res);
    }

    @Test
    void deleteOneById() {
        //todo
    }

}