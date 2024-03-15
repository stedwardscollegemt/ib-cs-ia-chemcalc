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

    private String volumeUnit = "dm^3"; 
    private String moleUnit = "mol";
    private String concentrationUnit = "mol/dm^3";

    // Constructor
    public ConcentrationEquation() {
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

    public String getVolumeUnit() {
        return this.volumeUnit;
    }

    public void setVolumeUnit(String volumeUnit) {
        this.volumeUnit = volumeUnit;
    }

    public String getConcentrationUnit() {
        return this.concentrationUnit;
    }

    public void setConcentrationUnit(String concentrationUnit) {
        this.concentrationUnit = concentrationUnit;
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
    // centimeters^3 < decimeters^3 < meters^3
    public void convertVolumeUnit(String toUnit, String fromUnit) {
        if (fromUnit.equals ("cm^3") && toUnit.equals ("m^3")) {
            this.volume = this.volume / 1000000;
            this.volumeUnit = "m^3";
        } else if (fromUnit.equals ("m^3") && toUnit.equals ("cm^3")) {
            this.volume = this.volume * 1000000;
            this.volumeUnit = "cm^3";
        } else if (fromUnit.equals ("dm^3") && toUnit.equals ("cm^3")) {
            this.volume = this.volume * 1000;
            this.volumeUnit = "cm^3";
        } else if (fromUnit.equals ("cm^3") && toUnit.equals ("dm^3")) {
            this.volume = this.volume / 1000;
            this.volumeUnit = "dm^3";
        } else if (fromUnit.equals ("dm^3") && toUnit.equals ("m^3")) {
            this.volume = this.volume / 1000;
            this.volumeUnit = "m^3";
        } else if (fromUnit.equals ("m^3") && toUnit.equals ("dm^3")) {
            this.volume = this.volume * 1000;
            this.volumeUnit = "dm^3";
        }
    } 

   /*  public void convertMoleUnit(String toUnit, String fromUnit) {
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
    } */
    public void convertConcentrationUnit(String toUnit, String fromUnit) {
        if (fromUnit.equals ("mol/dm^3") && toUnit.equals ("mol/m^3")) {
            this.concentration = this.concentration * 1000;
            this.concentrationUnit = "mol/m^3";
        } else if (fromUnit.equals ("mol/m^3") && toUnit.equals ("mol/dm^3")) {
            this.concentration = this.concentration / 1000;
            this.concentrationUnit = "mol/dm^3";
        } else if (fromUnit.equals ("mol/cm^3") && toUnit.equals ("mol/dm^3")) {
            this.concentration = this.concentration * 1000;
            this.concentrationUnit = "mol/dm^3";
        } else if (fromUnit.equals ("mol/dm^3") && toUnit.equals ("mol/cm^3")) {
            this.concentration = this.concentration / 1000;
            this.concentrationUnit = "mol/cm^3";
        } else if (fromUnit.equals ("mol/cm^3") && toUnit.equals ("mol/m^3")) {
            this.concentration = this.concentration * 1000000;
            this.concentrationUnit = "mol/m^3";
        } else if (fromUnit.equals ("mol/m^3") && toUnit.equals ("mol/cm^3")) {
            this.concentration = this.concentration / 1000000;
            this.concentrationUnit = "mol/cm^3";
        }
    }

    // TODO: Create a method to notify the user that the Units must be changed to be equal. (When a unit is changed, check that
    // the units are equal)
    public void checkUnits() {

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
                /* if (volume > 0) {
                    updateMole();
                } else if (moles > 0) {
                    updateVolume();
                }*/
            } else if (attributeName.equals("volumeUnit")) {
                String volumeUnitTemp = this.volumeUnit;
                convertVolumeUnit(newValue, volumeUnitTemp);
                /* if (concentration > 0) {
                    updateMole();
                } else if (moles > 0) {
                    updateConcentration();
                }*/
            } else if (attributeName.equals("concentrationUnit")) {
                String concentrationUnitTemp = this.concentrationUnit;
                convertConcentrationUnit(newValue, concentrationUnitTemp);
                /* if (volume > 0) {
                    updateMole();
                } else if (moles > 0) {
                    updateVolume();
                } */
            }
        }
    }
}
