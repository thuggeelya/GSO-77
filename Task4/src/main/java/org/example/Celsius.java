package org.example;

public final class Celsius implements Convertable {

    public Celsius() {}

    @Override
    public double fromCelsius(double temperature) {
        return temperature;
    }

    @Override
    public double toCelsius(double temperature) {
        return temperature;
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
        return Celsius.class.hashCode();
    }

    @Override
    public String toString() {
        return "C";
    }
}