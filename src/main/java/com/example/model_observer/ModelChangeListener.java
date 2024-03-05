package com.example.model_observer;

/**
 * TODO: Have a section in Criterion C for the Observer Design Pattern
 * [From ChatGPT 3.5]
 * "To listen for changes in the model attributes we create a listener 
 * or an aspect that observes changes to specific model attributes 
 * and takes appropriate action when changes occur."
 * https://refactoring.guru/design-patterns/observer
 */
public class ModelChangeListener {
    
    public void onModelChange(String attributeName, String newValue) {
        // Do something with the changed attribute
        System.out.println("Attribute '" + attributeName + "' changed to: " + newValue);
    }
}
