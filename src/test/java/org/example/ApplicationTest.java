package org.example;

import org.example.task_1.MyStringClass;
import org.example.task_2.CensoredText;
import org.example.task_3.Fraction;
import org.junit.Test;

import static org.example.task_4.CalculateTemperatureByInput.analiseInput;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class ApplicationTest
{
    /**
     * Task 1-4 Tests.
     */
    @Test
    public void testCapitalize()
    {
        assertEquals(MyStringClass.capitalize("somebody"), "Somebody");
        assertEquals(MyStringClass.capitalize("morning"), "Morning");
    }

    @Test
    public void testIsPalindrome()
    {
        assertTrue(MyStringClass.isPalindrome("someemos"));
        assertFalse(MyStringClass.isPalindrome("morning"));
    }

    @Test
    public void testAlphabetize()
    {
        assertEquals(MyStringClass.alphabetize("Ilya Fedorov 22"), "FIadeloorvy");
        assertEquals(MyStringClass.alphabetize("Papa Roach"), "PRaaachop");
    }

    @Test
    public void testCensor()
    {
        assertEquals(new CensoredText("Help").censor("Help! I need somebody Help! Not just anybody Help! You know I need someone Help!"),
                                                              "censored! I need somebody censored! Not just anybody censored! You know I need someone censored!");
    }

    @Test
    public void testAdd()
    {
        assertEquals(new Fraction(5, 6).add(new Fraction(7, 12)), "17/12");
    }

    @Test
    public void testMultiply()
    {
        assertEquals(new Fraction(5, 6).multiply(new Fraction(7, 12)), "35/72");
    }

    @Test
    public void testDivide()
    {
        assertEquals(new Fraction(5, 6).divide(new Fraction(7, 12)), "10/7");
    }

    @Test
    public void testSubtract()
    {
        assertEquals(new Fraction(5, 6).subtract(new Fraction(7, 12)), "1/4");
    }

    @Test
    public void testEquals()
    {
        assertTrue(new Fraction(5, 6).equals(new Fraction(5, 6)));
        assertEquals(new Fraction(5, 6).compareTo(new Fraction(5, 6)), 0);
    }

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
