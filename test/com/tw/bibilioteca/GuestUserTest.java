package com.tw.bibilioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestUserTest {

    @Test
    public void shouldReturnDefaultUserAsUser() {
        assertEquals(new GuestUser().authenticate(), "DEFAULT_USER");
    }
}