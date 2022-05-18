package org.example;

import java.util.Objects;

import static org.example.CalculateTemperatureByInput.getDoubleValue;

public final class Kelvin implements Convertable {

    private final double temperature;

    public Kelvin(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public double fromCelsius() {
        return getDoubleValue(temperature + 273.15d);
    }

    @Override
    public double toCelsius() {
        return getDoubleValue(temperature - 273.15d);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Kelvin kelvin = (Kelvin) o;

        return (Double.compare(kelvin.temperature, temperature) == 0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temperature);
    }

    @Override
    public String toString() {
        return temperature + "K";
    }
}
