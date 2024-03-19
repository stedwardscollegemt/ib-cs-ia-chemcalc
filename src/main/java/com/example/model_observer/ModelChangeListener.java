package com.example.model_observer;

public class ModelChangeListener {
    
    public void onModelChange(String attributeName, String newValue) {
        System.out.println("Attribute '" + attributeName + "' changed to: " + newValue);
    }
}
