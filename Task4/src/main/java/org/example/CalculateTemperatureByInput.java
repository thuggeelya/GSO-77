package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;

public class CalculateTemperatureByInput {

    private final static String SCALE_CHARS = "cfkCFK";
    private final static String NO_SUCH_SCALE_MESSAGE = "No such scale! Try 'C', 'K' or 'F'..";
    private final static String INPUT_IS_NOT_VALID_MESSAGE = "Input is not valid!";
    private final static char INPUT_IS_NOT_VALID_SIGN = '!';

    /**
     *
     * @param in    an input with temperature and specified scale
     * @return      converted temperature and specified scale
     */
    public static String analiseInput(String in) {
        if (in == null || in.isBlank()) {
            throw new NullPointerException(INPUT_IS_NOT_VALID_MESSAGE);
        }

        char[] inChars = in.trim().toCharArray();

        char fromScale;
        char toScale;
        int endIndexTemperature = 0;
        boolean firstDigitAppeared = true;
        StringBuilder temperature = new StringBuilder();

        for (int i = 0; i < inChars.length; i++) {
            char c = inChars[i];

            if (Character.isDigit(c)) {
                temperature.append((firstDigitAppeared) ? printMinusIfNegative(in, i) : "");
                temperature.append(c);
                endIndexTemperature = i;
                firstDigitAppeared = false;
            } else if (!temperature.isEmpty()) {
                break;
            }
        }

        fromScale = getFromScaleVal(endIndexTemperature, inChars);
        toScale = getToScaleVal(inChars, fromScale);

        if ((fromScale == INPUT_IS_NOT_VALID_SIGN) || (toScale == INPUT_IS_NOT_VALID_SIGN)) {
            throw new InputMismatchException(INPUT_IS_NOT_VALID_MESSAGE);
        }

        return calculate(new TemperatureInput(String.valueOf(fromScale), String.valueOf(toScale), Integer.parseInt(temperature.toString())));
    }

    private static String printMinusIfNegative(String in, int firstDigitIndex) {
        return (in.substring(0, firstDigitIndex).contains("-")) ? "-" : "";
    }

    private static char getFromScaleVal(int endIndexTemperature, char[] inChars) {
        for (int i = endIndexTemperature; i < inChars.length; i++) {
            if (SCALE_CHARS.indexOf(inChars[i]) != -1) {
                return inChars[i];
            }
        }

        return INPUT_IS_NOT_VALID_SIGN;
    }

    private static char getToScaleVal(char[] inChars, char fromScale) {
        for (int i = inChars.length - 1; i > 0; i--) {
            if (SCALE_CHARS.indexOf(inChars[i]) != -1 || inChars[i] != fromScale) {
                return inChars[i];
            }
        }

        return INPUT_IS_NOT_VALID_SIGN;
    }

    private static String calculate(TemperatureInput input) {
        Convert convert;

        switch (input.getFromScale().toUpperCase()) {
            case "K", "К" -> convert = new Kelvin(input.getTemperature());
            case "F" -> convert = new Fahrenheit(input.getTemperature());
            case "C", "С" -> convert = new Celsius(input.getTemperature());
            default -> throw new InputMismatchException(NO_SUCH_SCALE_MESSAGE);
        }

        return switch (input.getToScale().toUpperCase()) {
            case "K", "К" -> convert.convertKelvin();
            case "F" -> convert.convertFahrenheit();
            case "C", "С" -> convert.convertCelsius();
            default -> throw new InputMismatchException(NO_SUCH_SCALE_MESSAGE);
        };
    }

    public static Double getDoubleValue(double value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
