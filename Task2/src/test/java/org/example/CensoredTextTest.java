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
        assertEquals(new CensoredText("Help").censor("Help! I need somebody Help! Not just anybody Help! You know I need someone Help!"),
                "censored! I need somebody censored! Not just anybody censored! You know I need someone censored!");
    }
}
