package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class CensoredTextTest
{
    @Test
    public void censor()
    {
        String text = "Help! I need somebody Help! Not just anybody Help! You know I need someone Help!";
        assertEquals(" censored! I need somebody censored! Not just anybody censored! You know I need someone censored! ", new CensoredText("HELP").censor(' ' + text + ' '));
        assertEquals(" censored! I need somebody censored! Not just anybody censored! You know I need someone censored! ", new CensoredText("hElP").censor(' ' + text + ' '));
        assertEquals("censored! I need somebody censored! Not just anybody censored! You know I need someone censored!", new CensoredText("help").censor(text));
        assertEquals("censored! I need somebody censored! Not just anybody censored! You know I need someone censored!", new CensoredText("hElP").censor(text));
        assertEquals(text, new CensoredText("body").censor(text));
    }
}
