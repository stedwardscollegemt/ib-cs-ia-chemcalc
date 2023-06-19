package com.example.model;

import java.beans.JavaBean;
// todo: obey this contract so that we can know when a user changed a particular attribute in the model
import java.beans.PropertyChangeListener;

import javax.validation.constraints.Min;

// todo: https://kodejava.org/how-do-i-listen-for-beans-property-change-event/ (advanced)
@JavaBean // https://en.wikibooks.org/wiki/Java_Programming/JavaBeans
public class IdealGasEquation { 
    /**
     * Data
     */
    public static final double R = 8.314; // the ideal gas constant

    @Min(value = 0)
    private double volume; // volume

    // todo: https://www.geeksforgeeks.org/spring-boot-validation-using-hibernate-validator/ (medium)
    private double temperature; // temperature

    private double numberOfMoles; // number of moles

    private double pressure; // pressure

    private boolean isEmpty;

    /**
     * Constructors
     */
    public IdealGasEquation() {
        // todo: put in default values that make sense...
        this.isEmpty = true;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return this.volume;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getPressure() {
        return this.pressure;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public boolean getIsEmpty() {
        return this.isEmpty;
    }

    // todo: the algebra based on the property changes (advanced)
    public void calc() {
        this.temperature = (this.pressure * this.volume) / (this.numberOfMoles * R);
        this.isEmpty = false;
    }
}