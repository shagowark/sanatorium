package com.example.sanatorium.controllers;

import com.example.sanatorium.models.MedicalRoom;
import com.example.sanatorium.models.Procedure;
import com.example.sanatorium.services.MedicalRoomService;
import com.example.sanatorium.services.ProcedureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/procedures")
public class ProcedureController {
    private final ProcedureService procedureService;

    @GetMapping()
    public String procedures(Model model){
        model.addAttribute("procedures", procedureService.listProcedures());
        return "procedures/procedures";
    }

    @PostMapping("/create")
    public String createProcedure(Procedure procedure){
        procedureService.saveProcedure(procedure);
        return "redirect:/procedures";
    }

    @PostMapping("/delete/{id}")
    public String deleteProcedure(@PathVariable UUID id){
        procedureService.deleteProcedure(id);
        return "redirect:/procedures";
    }

    @GetMapping("/{id}")
    public String showProcedure(@PathVariable UUID id, Model model){
        model.addAttribute("procedure", procedureService.getProcedureById(id));
        return "procedures/procedure-info";
    }

    @PostMapping("/put")
    public String changeProcedure(Procedure procedure){
        procedureService.updateProcedure(procedure);
        return "redirect:/procedures/" + procedure.getId();
    }
}
