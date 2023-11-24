package com.example.sanatorium.controllers;

import com.example.sanatorium.models.Client;
import com.example.sanatorium.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;
//TODO бронь медицины
@Controller
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping()
    public String clients(Model model){
        model.addAttribute("clients", clientService.listClients());
        return "clients/clients";
    }

    @PostMapping("/create")
    public String createClient(Client client){
        clientService.saveClient(client);
        return "redirect:/clients";
    }

    @PostMapping("/delete/{id}")
    public String deleteClient(@PathVariable UUID id){
        clientService.deleteClient(id);
        return "redirect:/clients";
    }

    @GetMapping("/{id}")
    public String showClient(@PathVariable UUID id, Model model){
        model.addAttribute("client", clientService.getClientById(id));
        return "clients/client-info";
    }

    @PostMapping("/put")
    public String changeClient(Client client){
        clientService.updateClient(client);
        return "redirect:/clients/" + client.getId();
    }
}
