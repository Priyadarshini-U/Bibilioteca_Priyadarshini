package com.tw.bibilioteca;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UsersTest {
    @Test
    public void shouldNotReturnUserInformationForInValidUserToken() {
        assertTrue(new Users().getUserInformationFromToken("11404444") == null);
    }

    @Test
    public void shouldReturnUserInformationForValidUserToken() {
        assertTrue(new Users().getUserInformationFromToken("34404444") != null);
    }

    @Test
    public void shouldReturnUserInformationForValidGuestToken() {
        assertTrue(new Users().getUserInformationFromToken(new GuestUser().authenticate()) != null);
    }
}