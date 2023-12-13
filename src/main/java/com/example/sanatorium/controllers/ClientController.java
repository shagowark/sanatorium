package com.example.sanatorium.controllers;

import com.example.sanatorium.models.Client;
import com.example.sanatorium.services.ClientService;
import com.sun.net.httpserver.HttpContext;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping()
    public String clients(Model model,
                          @RequestParam(required = false) UUID id,
                          @RequestParam(required = false) String lastName,
                          @RequestParam(required = false) String firstName,
                          @RequestParam(required = false) String middleName,
                          @RequestParam(required = false) Integer age,
                          @RequestParam(required = false) Long passport,
                          @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable
                          ) {
        Page<Client> pageClients = clientService.listAll(id, lastName, firstName, middleName, age, passport, pageable);
        model.addAttribute("clients", pageClients);
        model.addAttribute("totalClientsNumber", clientService.count());
        model.addAttribute("page", pageClients);
        String currentFullURL = "/clients?id="
                + (id ==  null ? "" : id.toString())
                + "&lastName=" + (lastName ==  null ? "" : lastName)
                + "&firstName=" + (firstName ==  null ? "" : firstName)
                + "&middleName=" + (middleName ==  null ? "" : middleName)
                + "&age=" + (age ==  null ? "" : age)
                + "&passport=" + (passport ==  null ? "" : passport) ;
        model.addAttribute("url", currentFullURL);
        return "clients/clients";
    }

    @PostMapping("/create")
    public String createClient(Client client) {
        clientService.saveOne(client);
        return "redirect:/clients";
    }

    @PostMapping("/delete/{id}")
    public String deleteClient(@PathVariable UUID id) {
        clientService.deleteOneById(id);
        return "redirect:/clients";
    }

    @GetMapping("/{id}")
    public String showClient(@PathVariable UUID id, Model model) {
        model.addAttribute("client", clientService.getOneById(id));
        return "clients/client-info";
    }

    @PostMapping("/put")
    public String changeClient(Client client) {
        clientService.updateOne(client);
        return "redirect:/clients/" + client.getId();
    }
}
