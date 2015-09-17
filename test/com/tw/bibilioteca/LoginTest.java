package com.tw.bibilioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    @Test
    public void shouldNotAuthenticateNonExistingAvailableLogins() {
        String libraryNumber = "0x1-1111";
        String password = "1";
        Login login = new Login();
        login.authenticate(libraryNumber, password);

        assertEquals(login.authenticate(libraryNumber, password), null);
    }
}