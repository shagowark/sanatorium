package com.example.sanatorium.services;

import com.example.sanatorium.models.Client;

import java.util.List;

public interface ClientService extends Service<Client>{

    List<Client> listAll(String name, Integer age);

}
