package org.example;

import org.junit.Test;

import static org.example.CalculateTemperatureByInput.analiseInput;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class CalculateTemperatureByInputTest
{
    @Test
    public void testAnaliseInput()
    {
        assertEquals(analiseInput("40C=>F"), "104.0F");
        assertEquals(analiseInput("290K =>C"), "16.85C");
        assertEquals(analiseInput("11 F => C"), "-11.67C");
        assertEquals(analiseInput("29C => K"), "302.15K");
        assertEquals(analiseInput("-123F => K"), "187.04K");
    }
}
