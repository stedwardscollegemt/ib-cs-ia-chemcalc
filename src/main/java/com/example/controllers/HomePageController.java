package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.ConcentrationEquation;
import com.example.model.HomePage;
import com.example.model_observer.ModelChangeNotifier;

@Controller // tells the program that my class is-a (inheritence) controller
public class HomePageController {

    // the exact name of the concentration html file in templates folder
    private final String TEMPLATE = "home-page";

    // tells the program that this methods maps to a GET Http Request invoked by the
    // browser
    @GetMapping("/home-page")
    public String index(HomePage homePage) {
        ModelChangeNotifier.getInstance().add(homePage);
        return TEMPLATE;
    }
}

