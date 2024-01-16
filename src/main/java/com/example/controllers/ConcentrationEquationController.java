package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.ConcentrationEquation;
import com.example.model.OperationModel;

@Controller // tells the program that my class is / acts like a controller
public class ConcentrationEquationController {

    private final String TEMPLATE = "concentration-equation"; // the exact name of the concentration html file

    @GetMapping("/concentration-equation")
    public String index(ConcentrationEquation concentrationEquation) {
        return TEMPLATE;
    }

    @RequestMapping(value = "/concentration-equation", method = RequestMethod.POST)
    public String submit(@ModelAttribute ConcentrationEquation concentrationEquation) {
        concentrationEquation.calc();
        return TEMPLATE;
    }
}
