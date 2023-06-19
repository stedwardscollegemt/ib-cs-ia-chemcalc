package com.example.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.IdealGasEquation;
import com.example.service.IdealGasEquationValidation;

@Controller
public class IdealGasEquationController {

    @Autowired
    IdealGasEquationValidation validation;

    private final String TEMPLATE = "ideal-gas-equation"; // the exact name of the html file
    
    @GetMapping("/ideal-gas-equation")
    public String index(IdealGasEquation idealGasEquation) {
        return TEMPLATE;
    }

    @PostMapping("/ideal-gas-equation")
    public String update(@Valid IdealGasEquation idealGasEquation, BindingResult result) {
        String err = validation.validateIdealGasEquation(idealGasEquation);
        if (!err.isEmpty()) {
            ObjectError error = new ObjectError("globalError", err);
            result.addError(error);
        }

        if (result.hasErrors()) {
            return TEMPLATE;
        }
        
        // todo: call calc() method (easy)

        return TEMPLATE;
    }
}
