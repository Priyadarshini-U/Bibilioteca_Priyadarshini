package com.tw.bibilioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class WelcomeMessageTest {

    @Test
    public void shouldReturnWelcomeMessage() {
        WelcomeMessage screen = new WelcomeMessage();
        assertEquals(screen.message(), "welcome to Bibilioteca");
    }

    @Test
    public void shouldReturnWelcomeMessageOnToString() {
        WelcomeMessage screen = new WelcomeMessage();
        assertEquals(screen.toString(), "welcome to Bibilioteca");
    }
}