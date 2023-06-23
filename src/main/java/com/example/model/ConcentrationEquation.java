package com.example.model;

import javax.validation.constraints.Min;

public class ConcentrationEquation {
    // Data

    @Min(value = 0)
    private double concentration;
    @Min(value = 0)
    private double numberOfMoles;
    @Min(value = 0)
    private double volume;
    @Min(value = 0)
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

    public void setNumberOfMoles(double numberOfMoles) {
        this.numberOfMoles = numberOfMoles;
    }

    public double getNumberOfMoles() {
        return this.numberOfMoles;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return this.volume;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public boolean getIsEmpty() {
        return this.isEmpty;
    }

    public void calc() {
        this.concentration = (this.numberOfMoles / this.volume);
        this.isEmpty = false;
        // todo: do the rest later
    }

}
