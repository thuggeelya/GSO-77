package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface Convertable {

    double fromCelsius(double temperature);

    double toCelsius(double temperature);

    default Double getDoubleValue(double value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}