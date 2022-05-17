package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class FractionTest
{
    @Test
    public void add() {
        // 2_147_483_647
        assertEquals(new Fraction(5, 6).add(new Fraction(7, 12)), "17/12");
        assertEquals(new Fraction(5, 6).add(new Fraction(-5, 6)), "0");
        assertThrows(IllegalArgumentException.class, () -> new Fraction(2, 0).add(new Fraction(2, 3)));
        assertThrows(IllegalArgumentException.class, () -> new Fraction(3, 4).add(new Fraction(2, 0)));
        assertThrows(ArithmeticException.class, () -> new Fraction(31, 429496731).add(new Fraction(1, 429496729)));
        assertThrows(ArithmeticException.class, () -> new Fraction(1, 2).add(new Fraction(2_147_483_646, 2_147_483_647)));
    }

    @Test
    public void multiply()
    {
        assertEquals(new Fraction(5, 6).multiply(new Fraction(7, 12)), "35/72");
        assertEquals(new Fraction(5, 6).multiply(new Fraction(0, 12)), "0");
        assertThrows(ArithmeticException.class, () -> new Fraction(1, 42949673).multiply(new Fraction(1, 77)));
        assertThrows(IllegalArgumentException.class, () -> new Fraction(3, 4).multiply(new Fraction(2, 0)));
    }

    @Test
    public void divide()
    {
        assertEquals(new Fraction(5, 6).divide(new Fraction(7, 12)), "10/7");
        assertEquals(new Fraction(5, 6).divide(new Fraction(10, 12)), "1");
        assertThrows(IllegalArgumentException.class, () -> new Fraction(3, 4).divide(new Fraction(0, 10)));
        assertThrows(ArithmeticException.class, () -> new Fraction(429496731, 2).divide(new Fraction(1, 77)));
    }

    @Test
    public void subtract() {
        assertEquals(new Fraction(5, 6).subtract(new Fraction(7, 12)), "1/4");
        assertEquals(new Fraction(5, 6).subtract(new Fraction(10, 12)), "0");
        assertThrows(ArithmeticException.class, () -> new Fraction(-2_147_483_648, 2).subtract(new Fraction(1, 2)));
        assertThrows(IllegalArgumentException.class, () -> new Fraction(3, 8).divide(new Fraction(7, 0)));
    }

    @Test
    public void equals()
    {
        assertNotEquals(new Fraction(10, 12), new Fraction(5, 6));
        assertEquals(new Fraction(10, 12).compareTo(new Fraction(5, 6)), 0);
    }
}
