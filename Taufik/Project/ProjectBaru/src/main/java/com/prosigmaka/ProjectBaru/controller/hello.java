package com.prosigmaka.ProjectBaru.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hallo")
public class hello {

    @GetMapping("/World")
    public String halloWorld(){
        String s="Hallo World";
        return s;
    }
}
