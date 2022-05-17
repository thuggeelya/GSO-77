package org.example;

import org.junit.Test;

import java.util.InputMismatchException;

import static org.example.CalculateTemperatureByInput.analiseInput;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Unit test for simple App.
 */
public class CalculateTemperatureByInputTest
{
    @Test
    public void calculateTemperature()
    {
        assertThrows(InputMismatchException.class, () -> analiseInput("25 L=>C"));
        assertThrows(InputMismatchException.class, () -> analiseInput("25 => C"));
        assertThrows(InputMismatchException.class, () -> analiseInput("25 C"));
        assertThrows(InputMismatchException.class, () -> analiseInput("25 CCCF"));
        assertThrows(NullPointerException.class, () -> analiseInput("  "));

        assertEquals(analiseInput("40C=>F"), "104.0F");
        assertEquals(analiseInput(" 290K =>C "), "16.85C");
        assertEquals(analiseInput("11 F => C"), "-11.67C");
        assertEquals(analiseInput("29C => K"), "302.15K");
        assertEquals(analiseInput("-123F => K"), "187.04K");

    }
}
