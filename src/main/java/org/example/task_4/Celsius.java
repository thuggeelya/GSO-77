package org.example.task_4;

import static org.example.task_4.CalculateTemperatureByInput.getDoubleValue;

public class Celsius extends Convert {

    private int value;

    public Celsius(int value) {
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
        return this.value + "C";
    }

    @Override
    public String convertKelvin() {
        return getDoubleValue(this.value + 273.15d) + "K";
    }

    @Override
    public String convertFahrenheit() {
        return getDoubleValue(1.8d * this.value + 32.0d) + "F";
    }
}