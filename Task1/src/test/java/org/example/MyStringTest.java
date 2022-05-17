package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class MyStringTest
{
    @Test
    public void capitalize()
    {
        assertEquals(MyStringClass.capitalize("somebody "), "Somebody ");
        assertEquals(MyStringClass.capitalize("4morning"), "4Morning");
        assertEquals(MyStringClass.capitalize(".. ."), ".. .");
        assertEquals(MyStringClass.capitalize(" hello*"), " Hello*");
        assertEquals(MyStringClass.capitalize("   12    11---hello"), "   12    11---Hello");
    }

    @Test
    public void isPalindrome()
    {
        assertTrue(MyStringClass.isPalindrome("someemos"));
        assertTrue(MyStringClass.isPalindrome("somemos"));
        assertTrue(MyStringClass.isPalindrome("moom"));
        assertTrue(MyStringClass.isPalindrome("e"));
        assertTrue(MyStringClass.isPalindrome("Lol"));
        assertTrue(MyStringClass.isPalindrome("LoL"));

        assertFalse(MyStringClass.isPalindrome("rh"));
        assertFalse(MyStringClass.isPalindrome("Loo"));
        assertFalse(MyStringClass.isPalindrome("morning"));
    }

    @Test
    public void alphabetize()
    {
        assertEquals(MyStringClass.alphabetize("Ilya Fedorov 22"), "FIadeloorvy");
        assertEquals(MyStringClass.alphabetize("Papa Roach"), "PRaaachop");
        assertEquals(MyStringClass.alphabetize("dbaec"), "abcde");
    }
}
