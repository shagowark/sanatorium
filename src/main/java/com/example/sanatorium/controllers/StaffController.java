package com.example.sanatorium.controllers;

import com.example.sanatorium.models.Staff;
import com.example.sanatorium.services.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;
@Controller
@RequestMapping("/staff")
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;

    @GetMapping()
    public String staff(Model model){
        model.addAttribute("staff", staffService.listStaff());
        return "staff/staff";
    }

    @PostMapping("/create")
    public String createStaff(Staff staff){
        staffService.saveStaff(staff);
        return "redirect:/staff";
    }

    @PostMapping("/delete/{id}")
    public String deleteStaff(@PathVariable UUID id){
        staffService.deleteStaff(id);
        return "redirect:/staff";
    }

    @GetMapping("/{id}")
    public String showStaff(@PathVariable UUID id, Model model){
        model.addAttribute("staff", staffService.getStaffById(id));
        return "staff/staff-info";
    }

    @PostMapping("/put")
    public String changeStaff(Staff staff){
        staffService.updateStaff(staff);
        return "redirect:/staff/" + staff.getId();
    }
}
