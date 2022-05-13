package org.example.task_4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;

public class CalculateTemperatureByInput {

    private final static String SCALE_CHARS = "cfkCFK";

    /**
     *
     * @param in    an input with temperature and specified scale
     * @return      converted temperature and specified scale
     */
    public static String analiseInput(String in) {
        if (in == null || in.isBlank()) {
            throw new NullPointerException("Input is not valid!");
        }

        char[] inChars = in.trim().toCharArray();

        char fromScale;
        char toScale;
        int endIndexTemperature = 0;
        boolean firstDigitAppearance = true;
        StringBuilder temperature = new StringBuilder();

        for (int i = 0; i < inChars.length; i++) {
            char c = inChars[i];

            if (Character.isDigit(c)) {
                temperature.append((firstDigitAppearance) ? isNegative(in, i) : "");
                temperature.append(c);
                endIndexTemperature = i;
                firstDigitAppearance = false;
            } else if (!temperature.isEmpty()) {
                break;
            }
        }

        fromScale = getFromScaleVal(endIndexTemperature, inChars);
        toScale = getToScaleVal(inChars, fromScale);

        if (fromScale == '!' || toScale == '!') {
            throw new InputMismatchException("Input is not valid!");
        }

        System.out.println(temperature.toString() + fromScale + " => " + toScale);

        return calculate(new TemperatureInput(String.valueOf(fromScale), String.valueOf(toScale), Integer.parseInt(temperature.toString())));
    }

    private static String isNegative(String in, int firstDigitIndex) {
        return (in.substring(0, firstDigitIndex).contains("-")) ? "-" : "";
    }

    private static char getFromScaleVal(int endIndexTemperature, char[] inChars) {
        for (int i = endIndexTemperature; i < inChars.length; i++) {
            char c = inChars[i];

            if (SCALE_CHARS.indexOf(c) != -1) {
                return c;
            }
        }

        return '!';
    }

    private static char getToScaleVal(char[] inChars, char fromScale) {
        for (int i = inChars.length - 1; i > 0; i--) {
            char c = inChars[i];

            if (SCALE_CHARS.indexOf(c) != -1 || c != fromScale) {
                return c;
            }
        }

        return '!';
    }

    public static String calculate(TemperatureInput input) {
        Convert convert;

        switch (input.getFromScale().toUpperCase()) {
            case "K", "К" -> convert = new Kelvin(input.getTemperature());
            case "F" -> convert = new Fahrenheit(input.getTemperature());
            case "C", "С" -> convert = new Celsius(input.getTemperature());
            default -> throw new InputMismatchException("No such scale! Try 'C', 'K' or 'F'..");
        }

        return switch (input.getToScale().toUpperCase()) {
            case "K", "К" -> convert.convertKelvin();
            case "F" -> convert.convertFahrenheit();
            case "C", "С" -> convert.convertCelsius();
            default -> throw new InputMismatchException("No such scale! Try 'C', 'K' or 'F'..");
        };
    }

    public static Double getDoubleValue(double value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
