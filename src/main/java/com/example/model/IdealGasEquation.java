// TODO: This has a newer version
package com.example.model;

import javax.validation.constraints.Min;

import com.example.model_observer.ModelChangeListener;


public class IdealGasEquation extends ModelChangeListener { // PV = nRT

    private double pressure; // pressure Pa, kPa, atm

    private double volume; // volume militres, litres, dm^3, m^3

    private double numberOfMoles; // number of moles

    private double temperature; // temperature Kelvin

    public static final double R = 8.314; // R = molar gas constant

    private boolean isEmpty;
    
    private String pressureUnit = "kPa";
    public String volumeUnit = "L";
    private String numberOfMolesUnit = "mol";
    public String RUnit = "J/K/mol";
    private String temperatureUnit = "K";

    public IdealGasEquation() {
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

    public void setNumberOfMoles(double numberOfMoles) {
        this.numberOfMoles = numberOfMoles;
    }

    public double getNumberOfMoles() {
        return this.numberOfMoles;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public boolean getIsEmpty() {
        return this.isEmpty;
    }

    public void setRUnit(String RUnit) {
        this.RUnit = RUnit;
    }

    public String getRUnit() {
        return this.RUnit;
    }

    public void setVolumeUnit(String volumeUnit) {
        this.volumeUnit = volumeUnit;
    }

    public String getVolumeUnit() {
        return this.volumeUnit;
    }

    public void setTemperatureUnit(String temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    public String getTemperatureUnit() {
        return this.temperatureUnit;
    }

    public void setNumberOfMolesUnit(String numberOfMolesUnit) {
        this.numberOfMolesUnit = numberOfMolesUnit;
    }

    public String getNumberOfMolesUnit() {
        return this.numberOfMolesUnit;
    }

    public void setPressureUnit(String pressureUnit) {
        this.pressureUnit = pressureUnit;
    }

    public String getPressureUnit() {
        return this.pressureUnit;
    }

    // PV = nRT, P = n x R x T / V, V = n x R x T / P, n = P x V / R x T, T = P x V / n x R
    public void calc() { 
        this.isEmpty = false;
        if (this.numberOfMoles > 0 && this.temperature > 0 && this.volume > 0) {
            this.pressure = (this.numberOfMoles * R * this.temperature) / this.volume;
        } else if (this.numberOfMoles > 0 && this.temperature > 0 && this.pressure > 0) {
            this.volume = (this.numberOfMoles * R * this.temperature) / this.pressure;
        } else if (this.pressure > 0 && this.volume > 0 && this.temperature > 0) {
            this.numberOfMoles = (this.pressure * this.volume) / (R * this.temperature);
        } else if (this.pressure > 0 && this.volume > 0 && this.numberOfMoles > 0) {
            this.temperature = (this.pressure * this.volume) / (this.numberOfMoles * R);
        }
    }
    
    public void updatePressure() {
        this.pressure = (this.numberOfMoles * R * this.temperature) / this.volume;
    }

    public void updateVolume() {
        this.volume = (this.numberOfMoles * R * this.temperature) / this.pressure;
    }

    public void updateNumberOfMoles() {
        this.numberOfMoles = (this.pressure * this.volume) / (R * this.temperature);
    }

    public void updateTemperature() {
        this.temperature = (this.pressure * this.volume) / (this.numberOfMoles * R);
    }

    public void convertPressureUnit(String toUnit, String fromUnit) { // atm, Pa, kPa
        if (fromUnit.equals("atm") && toUnit.equals("kPa")) {
            this.pressure = this.pressure * 101.3;
            this.pressureUnit = "kPa";
        } else if (fromUnit.equals("atm") && toUnit.equals("Pa")) {
            this.pressure = this.pressure * 101300;
            this.pressureUnit = "Pa";
        } else if (fromUnit.equals("Pa") && toUnit.equals("kPa")) {
            this.pressure = this.pressure / 1000;
            this.pressureUnit = "kPa";
        } else if (fromUnit.equals("Pa") && toUnit.equals("atm")) {
            this.pressure = this.pressure / 101300;
            this.pressureUnit = "atm";
        } else if (fromUnit.equals("kPa") && toUnit.equals("atm")) {
            this.pressure = this.pressure / 101.3;
            this.pressureUnit = "atm";
        } else if (fromUnit.equals("kPa") && toUnit.equals ("Pa")) {
            this.pressure = this.pressure * 1000;
            this.pressureUnit = "Pa";
        }
    }

    public void convertVolumeUnit(String toUnit, String fromUnit) { // militres, litres, dm^3, m^3
        if (fromUnit.equals("L") && toUnit.equals("mL")) {
            this.volume = this.volume * 1000;
            this.volumeUnit = "mL";
        } else if (fromUnit.equals("L") && toUnit.equals("dm^3")) {
            this.volume = this.volume * 1;
            this.volumeUnit = "dm^3";
        } else if (fromUnit.equals("L") && toUnit.equals("m^3")) {
            this.volume = this.volume / 1000;
            this.volumeUnit = "m^3";
        } else if (fromUnit.equals("mL") && toUnit.equals("L")) {
            this.volume = this.volume / 1000;
            this.volumeUnit = "L";
        } else if (fromUnit.equals("mL") && toUnit.equals("m^3")) {
            this.volume = this.volume / 1000000;
            this.volumeUnit = "m^3";
        } else if (fromUnit.equals("mL") && toUnit.equals("dm^3")) {
            this.volume = this.volume / 1000;
            this.volumeUnit = "dm^3";
        } else if (fromUnit.equals("dm^3") && toUnit.equals("L")) {
            this.volume = this.volume * 1;
            this.volumeUnit = "L";
        } else if (fromUnit.equals ("dm^3") && toUnit.equals ("m^3")) {
            this.volume = this.volume / 1000;
            this.volumeUnit = "m^3";
        } else if (fromUnit.equals("dm^3") && toUnit.equals("mL")) {
            this.volume = this.volume * 1000;
            this.volumeUnit = "mL";
        } else if (fromUnit.equals ("m^3") && toUnit.equals ("dm^3")) {
            this.volume = this.volume * 1000;
            this.volumeUnit = "dm^3";
        } else if (fromUnit.equals("m^3") && toUnit.equals("L")) {
            this.volume = this.volume * 1000;
            this.volumeUnit = "L";
        } else if (fromUnit.equals("m^3") && toUnit.equals("mL")) {
            this.volume = this.volume * 1000000;
            this.volumeUnit = "mL";
        }
    }

    public void convertTemperatureUnit(String toUnit, String fromUnit) { // Kelvin, Celcius
        if (fromUnit.equals("K") && toUnit.equals("C")) {
            this.temperature = this.temperature  - 273;
            this.temperatureUnit = "C";
        } else if (fromUnit.equals("C") && toUnit.equals("K")) {
            this.temperature = this.temperature  + 273;
            this.temperatureUnit = "K";
        }
    }

    @Override
    public void onModelChange(String attributeName, String newValue) {
        if(!newValue.isEmpty()) { // PV = nRT
            this.isEmpty = false;

            if (attributeName.equals("pressure")) {
                this.pressure = Double.parseDouble(newValue);
                if (volume > 0 && numberOfMoles > 0) {
                    updateTemperature();
                } else if (volume > 0 && temperature > 0) {
                    updateNumberOfMoles();
                } else if (temperature > 0 && numberOfMoles > 0) {
                    updateVolume();
                }
            } else if (attributeName.equals("volume")) {
                this.volume = Double.parseDouble(newValue);
                if (pressure > 0 && numberOfMoles > 0) {
                    updateTemperature();
                } else if (pressure > 0 && temperature > 0) {
                    updateNumberOfMoles();
                } else if (numberOfMoles > 0 && temperature > 0) {
                    updatePressure();
                }
            } else if (attributeName.equals("numberOfMoles")) {
                this.numberOfMoles = Double.parseDouble(newValue);
                if (pressure > 0 && volume > 0) {
                    updateTemperature();
                } else if (pressure > 0 && temperature > 0) {
                    updateVolume();
                } else if (temperature > 0 && volume > 0) {
                    updatePressure();
                }
            } else if (attributeName.equals("temperature")) {
                this.temperature = Double.parseDouble(newValue);
                if (pressure > 0 && volume > 0) {
                    updateNumberOfMoles();
                } else if (pressure > 0 && numberOfMoles > 0) {
                    updateVolume();
                } else if (numberOfMoles > 0 && volume > 0) {
                    updatePressure();
                }
            } else if (attributeName.equals("pressureUnit")) {
                String pressureUnitTemp = this.pressureUnit;
                convertPressureUnit(newValue, pressureUnitTemp);
            } else if (attributeName.equals("volumeUnit")) {
                String volumeUnitTemp = this.volumeUnit;
                convertVolumeUnit(newValue, volumeUnitTemp);
            } else if (attributeName.equals("temperatureUnit")) {
                String temperatureUnitTemp = this.temperatureUnit;
                convertTemperatureUnit(newValue, temperatureUnitTemp);
            }
        }
    }

}