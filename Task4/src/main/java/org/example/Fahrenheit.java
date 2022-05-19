package org.example;

public final class Fahrenheit implements Convertable {

    public Fahrenheit() {}

    @Override
    public double fromCelsius(double temperature) {
        return getDoubleValue(1.8d * temperature + 32.0d);
    }

    @Override
    public double toCelsius(double temperature) {
        return getDoubleValue((temperature - 32) / 1.8d);
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
        return Fahrenheit.class.hashCode();
    }

    @Override
    public String toString() {
        return "F";
    }
}