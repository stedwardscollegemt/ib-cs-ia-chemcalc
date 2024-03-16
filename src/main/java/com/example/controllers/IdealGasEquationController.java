package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.IdealGasEquation;
import com.example.model_observer.ModelChangeNotifier;

@Controller
public class IdealGasEquationController {

    private final String TEMPLATE = "ideal-gas-equation"; // the exact name of the html file
    
    @GetMapping("/ideal-gas-equation")
    public String index(IdealGasEquation idealGasEquation) {
        ModelChangeNotifier.getInstance().add(idealGasEquation);
        return TEMPLATE;
    }

    @PutMapping("/ideal-gas-equation")
    public String update(@RequestParam("attribute") String attribute, @RequestParam("newValue") String newValue, Model model) {

        ModelChangeNotifier.getInstance().notify(attribute, newValue);

        IdealGasEquation idealGasEquation = ModelChangeNotifier.findListenerByClass(IdealGasEquation.class);

        model.addAttribute("idealGasEquation", idealGasEquation);

        return TEMPLATE + " :: form";
    }

    @PostMapping("/ideal-gas-equation")
    public String update(IdealGasEquation idealGasEquation) {
        idealGasEquation.calc();
        return TEMPLATE;
    }
}
