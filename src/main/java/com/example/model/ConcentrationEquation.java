package com.example.model;

import javax.validation.constraints.Min;

import com.example.model_observer.ModelChangeListener;

/**
 * TODO: Have a section in Criterion C for JavaBeans
 * source: https://www.geeksforgeeks.org/javabean-class-java/ 
 */
public class ConcentrationEquation extends ModelChangeListener {
    // Data
    // @Min(value = 0)
    private double concentration;
    // @Min(value = 0)
    private double moles;
    // @Min(value = 0)
    private double volume;
    // @Min(value = 0)
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

    public void calc() {
        // TODO: while loop the whole thingymbob
        this.isEmpty = false;
        if (this.moles > 0 && this.volume > 0) {
            this.concentration = (this.moles / this.volume);

        } else if (this.concentration > 0 && this.volume > 0) {
            this.moles = (this.concentration * this.volume);

        } else if (this.concentration > 0 && this.moles > 0) {
            this.volume = (this.moles / this.concentration);

        }

    }

    public void updateConcentration() {
        if (this.volume > 0) {
            this.concentration = this.moles / this.volume;
        }
    }

    public void convert() {
        // TODO: create conversion rates for the variables

    }

    @Override
    public void onModelChange(String attributeName, String newValue) {
        if(!newValue.isEmpty()) {
            // the model has been updated to unset flag
            this.isEmpty = false;
            // try to perform model updates
            if (attributeName.equals("moles")) {
                this.moles = Double.parseDouble(newValue);
                updateConcentration();
            } else if (attributeName.equals("volume")) {
                this.volume = Double.parseDouble(newValue);
                updateConcentration();
            }
        }
    }
}
