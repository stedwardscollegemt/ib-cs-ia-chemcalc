package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.IdealGasEquation;

@Service
public class IdealGasEquationValidation {
    // src: https://www.baeldung.com/spring-thymeleaf-error-messages (advanced)
    public String validateIdealGasEquation(IdealGasEquation idealGasEquation) {
        String feedback = "";
        // todo: you need to check that *three attributes* have values (easy)
        return feedback;
    }
}
