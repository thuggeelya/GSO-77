package org.example.task_4;

import static org.example.task_4.CalculateTemperatureByInput.getDoubleValue;

public class Kelvin extends Convert {

    private int value;

    public Kelvin(int value) {
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
        return getDoubleValue(this.value - 273.15d) + "C";
    }

    @Override
    public String convertKelvin() {
        return this.value + "K";
    }

    @Override
    public String convertFahrenheit() {
        return getDoubleValue(1.8d * (this.value - 273.15d) + 32.0d) + "F";
    }
}
