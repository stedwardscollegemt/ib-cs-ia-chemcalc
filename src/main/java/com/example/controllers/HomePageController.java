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

/**
 * TODO: Have a section in Criterion C for RESTful Controllers
 * source: https://codeburst.io/rest-controller-building-rest-api-638d3ff4fa71
 */
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

    // tells the program that this method maps to a PUT Http Request invoked by the
    // browser
    @PutMapping("/home-page")
    public String update(@RequestParam("attribute") String attribute, @RequestParam("newValue") String newValue,
            Model model) {
        // use the notifier to broadcast that a particular model should change
        ModelChangeNotifier.getInstance().notify(attribute, newValue);
        // get the model we need for our template
        HomePage homePage = ModelChangeNotifier
                .findListenerByClass(HomePage.class);
        // let us prepare our ModelAndView for rendering
        model.addAttribute("homePage", homePage);
        // we want to return the updated HTML in the form section of our template
        return TEMPLATE + " :: form";
    }

    // tells the program that this method maps to a POST Http Request invoked by the
    // browser
    @PostMapping("/home-page")
    public String submit(ConcentrationEquation concentrationEquation) {
        concentrationEquation.calc();
        return TEMPLATE;
    }
}
