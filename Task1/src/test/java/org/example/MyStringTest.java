package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class MyStringTest
{
    @Test
    public void testCapitalize()
    {
        assertEquals(MyStringClass.capitalize("somebody"), "Somebody");
        assertEquals(MyStringClass.capitalize("4morning"), "4Morning");
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
}
