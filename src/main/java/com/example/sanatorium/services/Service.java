package com.example.sanatorium.services;

import com.example.sanatorium.models.Client;
import com.example.sanatorium.repos.ClientRepo;

import java.util.List;
import java.util.UUID;

public interface Service <T>{
    List<T> listAll();
    void saveOne(T t);
    void deleteOneById(UUID id);

    T getOneById(UUID id);

    void updateOne(T t);
}
