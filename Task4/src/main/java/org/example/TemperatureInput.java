package org.example;

import java.util.InputMismatchException;
import java.util.Objects;

import static org.example.CalculateTemperatureByInput.getDoubleValue;

public final class TemperatureInput {

    public final static String NO_SUCH_SCALE_MESSAGE = "No such scale! Try 'C', 'K' or 'F'..";

    private final String fromScale;
    private final String toScale;
    private final int temperature;

    private final double celsiusInput;

    private final double result;

    public TemperatureInput(String fromScale, String toScale, int temperature) {
        this.fromScale = fromScale;
        this.temperature = temperature;
        this.celsiusInput = convertCelsius();
        this.toScale = toScale;
        this.result = calculateTemperature();
    }

    public String getFromScale() {
        return fromScale;
    }

    public String getToScale() {
        return toScale;
    }

    public int getTemperature() {
        return temperature;
    }

    public double getCelsiusInput() {
        return celsiusInput;
    }

    public double getResult() {
        return result;
    }

    private double convertCelsius() {
        return switch (fromScale) {
            case "K", "К" -> getDoubleValue(temperature - 273.15d);
            case "F" -> getDoubleValue((temperature - 32) / 1.8d);
            case "C", "С" -> temperature;
            default -> throw new InputMismatchException(NO_SUCH_SCALE_MESSAGE);
        };
    }

    private double calculateTemperature() {
        return switch (toScale) {
            case "K", "К" -> getDoubleValue(celsiusInput + 273.15d);
            case "F" -> getDoubleValue(1.8d * celsiusInput + 32.0d);
            case "C", "С" -> celsiusInput;
            default -> throw new InputMismatchException(NO_SUCH_SCALE_MESSAGE);
        };
    }

    @Override
    public String toString() {
        return result + toScale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TemperatureInput that = (TemperatureInput) o;
        return (temperature == that.temperature)
                && (Double.compare(that.celsiusInput, celsiusInput) == 0)
                && (fromScale.equals(that.fromScale))
                && (toScale.equals(that.toScale))
                && (Double.compare(that.result, result) == 0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromScale, toScale, temperature);
    }
}