package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class FractionTest
{
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
        assertTrue(new Fraction(10, 12).equals(new Fraction(5, 6)));
        assertEquals(new Fraction(5, 6).compareTo(new Fraction(5, 6)), 0);
    }
}
