package org.example.task_4;

public class TemperatureInput {

    private String fromScale;
    private String toScale;
    private int temperature;

    public TemperatureInput() {}

    public TemperatureInput(String fromScale, String toScale, int temperature) {
        this.fromScale = fromScale;
        this.toScale = toScale;
        this.temperature = temperature;
    }

    public String getFromScale() {
        return fromScale;
    }

    public void setFromScale(String fromScale) {
        this.fromScale = fromScale;
    }

    public String getToScale() {
        return toScale;
    }

    public void setToScale(String toScale) {
        this.toScale = toScale;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}