package org.example;

public final class Kelvin implements Convertable {

    public Kelvin() {}

    @Override
    public double fromCelsius(double temperature) {
        return getDoubleValue(temperature + 273.15d);
    }

    @Override
    public double toCelsius(double temperature) {
        return getDoubleValue(temperature - 273.15d);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        return (o != null) && (getClass() == o.getClass());
    }

    @Override
    public int hashCode() {
        return Kelvin.class.hashCode();
    }

    @Override
    public String toString() {
        return "K";
    }
}
