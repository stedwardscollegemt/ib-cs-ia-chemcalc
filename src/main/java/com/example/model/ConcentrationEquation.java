package com.example.model;

import javax.validation.constraints.Min;

public class ConcentrationEquation {
    // Data
    @Min(value = 0)
    private double concentration;
    @Min(value = 0)
    private double moles;
    @Min(value = 0)
    private double volume;
    @Min(value = 0)
    private boolean isEmpty;

    // private conversion dcm;

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

    public void setMoles(double moles) {
        this.moles = moles;
    }

    public double getMoles() {
        return this.moles;
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

    public double calc() {
        // TODO: while loop the whole thingymbob
        this.isEmpty = false;
        if (this.moles > 0 && this.volume > 0) {
            this.concentration = (this.moles / this.volume);
            return this.concentration;

        } else if (this.concentration > 0 && this.volume > 0) {
            this.moles = (this.concentration * this.volume);
            return this.moles;

        } else if (this.concentration > 0 && this.moles > 0) {
            this.volume = (this.moles / this.concentration);
            return this.volume;

        }
        return 0;
    }

    public void convert() {
        // TODO: create conversion rates for the variables

    }
}
