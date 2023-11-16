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

@Controller
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping()
    public String clients(Model model){
        model.addAttribute("clients", clientService.listClients());
        return "clients";
    }

    @PostMapping("/create")
    public String createClient(Client client){
        clientService.saveClient(client);
        return "redirect:/clients";
    }

    @PostMapping("/delete")
    public String deleteClient(Client client){
        clientService.deleteClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/show/{id}")
    public String showClient(@PathVariable("id") long id, Model model){
        model.addAttribute("client", clientService.getClientById(id));
        return "show";
    }
}
