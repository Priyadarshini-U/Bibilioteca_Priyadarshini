package com.tw.bibilioteca;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UsersTest {
    @Test
    public void shouldNotReturnUserInformationForInValidUserToken() {
        assertTrue(new Users().getUserInformationFromToken("11404444") == null);
    }
}