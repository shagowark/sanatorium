package com.example.sanatorium.controllers;

import com.example.sanatorium.models.Client;
import com.example.sanatorium.services.ClientService;
import com.example.sanatorium.services.impl.ClientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping()
    public String clients(Model model){
        model.addAttribute("clients", clientService.listAll());
        return "clients/clients";
    }

    @PostMapping("/create")
    public String createClient(Client client){
        clientService.saveOne(client);
        return "redirect:/clients";
    }

    @PostMapping("/delete/{id}")
    public String deleteClient(@PathVariable UUID id){
        clientService.deleteOneById(id);
        return "redirect:/clients";
    }

    @GetMapping("/{id}")
    public String showClient(@PathVariable UUID id, Model model){
        model.addAttribute("client", clientService.getOneById(id));
        return "clients/client-info";
    }

    @PostMapping("/put")
    public String changeClient(Client client){
        clientService.updateOne(client);
        return "redirect:/clients/" + client.getId();
    }
}
