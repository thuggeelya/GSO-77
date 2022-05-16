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
    public void testAdd() throws Exception
    {
        assertEquals(new Fraction(5, 6).add(new Fraction(7, 12)), "17/12");
        assertEquals(new Fraction(5, 6).add(new Fraction(-5, 6)), "0");
    }

    @Test
    public void testMultiply() throws Exception
    {
        assertEquals(new Fraction(5, 6).multiply(new Fraction(7, 12)), "35/72");
        assertEquals(new Fraction(5, 6).multiply(new Fraction(0, 12)), "0");
    }

    @Test
    public void testDivide() throws Exception
    {
        assertEquals(new Fraction(5, 6).divide(new Fraction(7, 12)), "10/7");
        assertEquals(new Fraction(5, 6).divide(new Fraction(10, 12)), "1");
    }

    @Test
    public void testSubtract() throws Exception
    {
        assertEquals(new Fraction(5, 6).subtract(new Fraction(7, 12)), "1/4");
        assertEquals(new Fraction(5, 6).subtract(new Fraction(10, 12)), "0");
    }

    @Test
    public void testEquals() throws Exception
    {
        assertTrue(new Fraction(10, 12).equals(new Fraction(5, 6)));
        assertEquals(new Fraction(5, 6).compareTo(new Fraction(5, 6)), 0);
    }
}
