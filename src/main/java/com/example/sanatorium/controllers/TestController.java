package com.example.sanatorium.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TestController {
    private final Generatr generatr;

    @GetMapping
    public String test(){
        generatr.generate();
        return "test";
    }
}
