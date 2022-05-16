package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class CensoredTextTest
{
    @Test
    public void testCensor()
    {
        String text = "Help! I need somebody Help! Not just anybody Help! You know I need someone Help!";
        assertEquals(new CensoredText("help").censor(text), "censored! I need somebody censored! Not just anybody censored! You know I need someone censored!");
        assertEquals(new CensoredText("hElP").censor(text), "censored! I need somebody censored! Not just anybody censored! You know I need someone censored!");
        assertEquals(new CensoredText("body").censor(text), text);
    }
}
