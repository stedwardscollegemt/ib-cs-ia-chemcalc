package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.ConcentrationEquation;

@Controller // tells the program that my class is / acts like a controller
public class ConcentrationEquationController {

    private final String TEMPLATE = "concentration-equation"; // the exact name of the concentration html file

    @GetMapping("/concentration-equation")
    public String index(ConcentrationEquation concentrationEquation) {
        return TEMPLATE;
    }

    @PostMapping("/concentration-equation")
    public String submit(ConcentrationEquation concentrationEquation) {
        concentrationEquation.calc();
        return TEMPLATE;
    }
}
