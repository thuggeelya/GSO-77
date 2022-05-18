package org.example;

import java.util.Objects;

public final class TemperatureInput {

    private final String fromScale;
    private final String toScale;
    private final int temperature;

    public TemperatureInput(String fromScale, String toScale, int temperature) {
        this.fromScale = fromScale;
        this.temperature = temperature;
        this.toScale = toScale;
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
                && (fromScale.equals(that.fromScale))
                && (toScale.equals(that.toScale));
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromScale, toScale, temperature);
    }
}