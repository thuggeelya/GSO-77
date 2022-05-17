package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;

public class CalculateTemperatureByInput {

    private final static String SCALE_CHARS = "cfkCFK";
    private final static String INPUT_IS_NOT_VALID_MESSAGE = "Input is not valid!";

    /**
     *
     * @param in    an input with temperature and specified scale
     * @return      converted temperature and specified scale
     */
    public static String analiseInput(String in) {
        if (in == null || in.isBlank()) {
            throw new NullPointerException(INPUT_IS_NOT_VALID_MESSAGE);
        }

        return defineInputParams(in).toString();
    }

    private static TemperatureInput defineInputParams(String in) {
        char[] inChars = in.trim().toCharArray();
        char fromScale;
        char toScale;
        int endIndexTemperature = 0;
        boolean firstDigitWasFound = false;
        StringBuilder temperature = new StringBuilder();

        for (int i = 0; i < inChars.length; i++) {
            char c = inChars[i];

            if (Character.isDigit(c)) {
                temperature.append((!firstDigitWasFound) ? printMinusIfNegative(in, i) : "");
                temperature.append(c);
                endIndexTemperature = i;
                firstDigitWasFound = true;
            } else if (!temperature.isEmpty()) {
                break;
            }
        }

        fromScale = getFromScaleVal(endIndexTemperature, inChars);
        toScale = getToScaleVal(inChars, fromScale);

        return new TemperatureInput(String.valueOf(fromScale), String.valueOf(toScale), Integer.parseInt(temperature.toString()));
    }

    private static String printMinusIfNegative(String in, int firstDigitIndex) {
        return (in.substring(0, firstDigitIndex).contains("-")) ? "-" : "";
    }

    private static char getFromScaleVal(int endIndexTemperature, char[] inChars) {
        char c;

        for (int i = endIndexTemperature; i < inChars.length; i++) {

            c = inChars[i];

            if (Character.isAlphabetic(c)) {
                if (SCALE_CHARS.indexOf(c) != -1) {
                    return c;
                } else {
                    break;
                }
            }
        }

        throw new InputMismatchException(INPUT_IS_NOT_VALID_MESSAGE);
    }

    private static char getToScaleVal(char[] inChars, char fromScale) {
        char c;
        char toScale = '!';
        int countLettersBetweenScales = -1;

        for (int i = inChars.length - 1; i > new String(inChars).indexOf(fromScale); i--) {

            c = inChars[i];

            if (Character.isAlphabetic(c)) {
                if (SCALE_CHARS.indexOf(c) != -1 || c != fromScale) {
                    toScale = c;
                    countLettersBetweenScales++;
                }
            }
        }

        if ((toScale == '!') || (countLettersBetweenScales != 0)) {
            throw new InputMismatchException(INPUT_IS_NOT_VALID_MESSAGE);
        } else {
            return toScale;
        }
    }

    public static Double getDoubleValue(double value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}