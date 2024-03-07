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

    private String volumeUnit = "litres";
    private String moleUnit = "grams";
    private String concentrationUnit = "g/l";

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

    public void updateVolume() {
        if (this.moles > 0) {
            this.volume = this.moles / this.concentration;
        }
    }
    
    public void updateMole() {
        if (this.volume > 0) {
            this.moles = this.volume * this.concentration;
        }
    }

    public void convertVolumeUnit(String toUnit, String fromUnit) {
        if (fromUnit.equals ("litres") && toUnit.equals ("kilolitre")) {
            this.volume = this.volume / 1000;
            this.volumeUnit = "kilolitre";
        } else if (fromUnit.equals ("kilolitres") && toUnit.equals ("litres")) {
            this.volume = this.volume * 1000;
            this.volumeUnit = "litres";
        } else if (fromUnit.equals ("mililitres") && toUnit.equals ("litres")) {
            this.volume = this.volume / 1000;
            this.volumeUnit = "litres";
        } else if (fromUnit.equals ("litres") && toUnit.equals ("mililitres")) {
            this.volume = this.volume * 1000;
            this.volumeUnit = "mililitres";
        } else if (fromUnit.equals ("mililitres") && toUnit.equals ("kilolitres")) {
            this.volume = this.volume / 1000000;
            this.volumeUnit = "kilolitres";
        } else if (fromUnit.equals ("kilolitres") && toUnit.equals ("mililitres")) {
            this.volume = this.volume * 1000000;
            this.volumeUnit = "mililitres";
        }
    } 
    // TODO: convert moleUnit
    public void convertMoleUnit(String toUnit, String fromUnit) {
        if (fromUnit.equals ("grams") && toUnit.equals ("kilograms")) {
            this.moles = this.moles / 1000;
            this.moleUnit = "kilograms";
        } else if (fromUnit.equals ("kilograms") && toUnit.equals ("grams")) {
            this.moles = this.moles * 1000;
            this.moleUnit = "grams";
        } else if (fromUnit.equals ("miligrams") && toUnit.equals ("grams")) {
            this.moles = this.moles / 1000;
            this.moleUnit = "grams";
        } else if (fromUnit.equals ("grams") && toUnit.equals ("miligrams")) {
            this.moles = this.moles * 1000;
            this.moleUnit = "miligrams";
        } else if (fromUnit.equals ("miligrams") && toUnit.equals ("kilograms")) {
            this.moles = this.moles / 1000000;
            this.moleUnit = "kilograms";
        } else if (fromUnit.equals ("kilograms") && toUnit.equals ("miligrams")) {
            this.moles = this.moles * 1000000;
            this.moleUnit = "miligrams";
        }
    }
    // TODO: convert concentrationUnit
    public void convertConcentrationUnit(String toUnit, String fromUnit) {
        if (fromUnit.equals ("g/l") && toUnit.equals ("kg/kl")) {
            
        } else if (fromUnit.equals ("kg/kl") && toUnit.equals ("g/l")) {

        } else if (fromUnit.equals ("mg/ml") && toUnit.equals ("g/l")) {

        } else if (fromUnit.equals ("g/l") && toUnit.equals ("mg/ml")) {

        } else if (fromUnit.equals ("mg/ml") && toUnit.equals ("kg/kl")) {

        } else if (fromUnit.equals ("kg/kl") && toUnit.equals ("mg/ml")) {

        }
    }

    @Override
    public void onModelChange(String attributeName, String newValue) {
        if(!newValue.isEmpty()) {
            // the model has been updated to unset flag
            this.isEmpty = false;
            // try to perform model updates
            if (attributeName.equals("moles")) {
                this.moles = Double.parseDouble(newValue);
                if (volume > 0) {
                    updateConcentration();
                } else if (concentration > 0) {
                    updateVolume();
                }
            } else if (attributeName.equals("volume")) {
                this.volume = Double.parseDouble(newValue);
                if (concentration > 0) {
                    updateMole();
                } else if (moles > 0) {
                    updateConcentration();
                }
            } else if (attributeName.equals("concentration")) {
                this.concentration = Double.parseDouble(newValue);
                if (volume > 0) {
                    updateMole();
                } else if (moles > 0) {
                    updateVolume();
                }
            } else if (attributeName.equals("volumeUnit")) {
                String volumeUnitTemp = this.volumeUnit;
                convertVolumeUnit(newValue, volumeUnitTemp);
                if (concentration > 0) {
                    updateMole();
                } else if (moles > 0) {
                    updateConcentration();
                }
            } else if (attributeName.equals("moleUnit")) {
                String moleUnitTemp = this.moleUnit;
                convertMoleUnit(newValue, moleUnitTemp);
                if (volume > 0) {
                    updateConcentration();
                } else if (concentration > 0) {
                    updateVolume();
                }
            } else if (attributeName.equals("concentrationUnit")) {
                String concentrationUnitTemp = this.concentrationUnit;
                convertConcentrationUnit(newValue, concentrationUnitTemp);
                if (volume > 0) {
                    updateMole();
                } else if (moles > 0) {
                    updateVolume();
                }
            } // TODO: Check that the SI units are the same before updating
        }
    }
}
