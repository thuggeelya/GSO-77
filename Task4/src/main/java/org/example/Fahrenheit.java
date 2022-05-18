package org.example;

import java.util.Objects;

import static org.example.CalculateTemperatureByInput.getDoubleValue;

public final class Fahrenheit implements Convertable {

    private final double temperature;

    public Fahrenheit(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public double fromCelsius() {
        return getDoubleValue(1.8d * temperature + 32.0d);
    }

    @Override
    public double toCelsius() {
        return getDoubleValue((temperature - 32) / 1.8d);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Fahrenheit fahrenheit = (Fahrenheit) o;

        return (Double.compare(fahrenheit.temperature, temperature) == 0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temperature);
    }

    @Override
    public String toString() {
        return temperature + "F";
    }
}