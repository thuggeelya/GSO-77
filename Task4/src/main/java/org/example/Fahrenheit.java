package org.example;

import static org.example.CalculateTemperatureByInput.getDoubleValue;

public class Fahrenheit extends Convert {

    private int value;

    public Fahrenheit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String convertCelsius() {
        return getDoubleValue((this.value - 32) / 1.8d) + "C";
    }

    @Override
    public String convertKelvin() {
        return getDoubleValue((this.value - 32.0d) / 1.8d + 273.15d) + "K";
    }

    @Override
    public String convertFahrenheit() {
        return this.value + "F";
    }
}
