package org.example;

public class TemperatureInput {

    private final String fromScale;
    private final String toScale;
    private final int temperature;

    public TemperatureInput(String fromScale, String toScale, int temperature) {
        this.fromScale = fromScale;
        this.toScale = toScale;
        this.temperature = temperature;
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
}