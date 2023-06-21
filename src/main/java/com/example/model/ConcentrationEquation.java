package com.example.model;

public class ConcentrationEquation {
    // Data
    private double concentration;
    private double mass;
    private double volume;
    private boolean isEmpty;

    // Constructor
    public ConcentrationEquation() {
        // todo: put in default values that make sense...
        this.isEmpty = true;
    }

    public void setConcentration(double concentration) {
        this.concentration = concentration;
    }

    public double getConcentration() {
        return this.concentration;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getMass() {
        return this.mass;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getVOlume() {
        return this.volume;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public boolean getIsEmpty() {
        return this.isEmpty;
    }

    public void calc() {
        this.concentration = (this.mass / this.volume);
        this.isEmpty = false;
        // todo: do the rest later
    }

}
