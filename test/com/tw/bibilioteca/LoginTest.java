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

        assertEquals(login.authenticate(libraryNumber, password), new GuestUser().authenticate());
    }

    @Test
    public void shouldAuthenticateExistingAvailableLogins() {
        String libraryNumber = "011-1111";
        String password = "1";
        Login login = new Login();
        login.authenticate(libraryNumber, password);
        String result = "";
        for (int i = 0; i < libraryNumber.length(); i++) {
            int ascii = (int) libraryNumber.charAt(i);
            ascii += (3 % 26);
            result += (char) ascii;
        }

        assertEquals(login.authenticate(libraryNumber, password), result);
    }

    @Test
    public void shouldNotAuthenticateExistingAvailableLoginsWithIncorrectPassword() {
        String libraryNumber = "011-1111";
        String password = "-1";
        Login login = new Login();
        login.authenticate(libraryNumber, password);

        assertEquals(login.authenticate(libraryNumber, password), new GuestUser().authenticate());
    }

    @Test
    public void shouldReturnMessageDigestOfLibraryNumber() {
        String libraryNumber = "011-1111";
        String password = "1";
        Login login = new Login();
        login.authenticate(libraryNumber, password);
        String result = "";
        for (int i = 0; i < libraryNumber.length(); i++) {
            int ascii = (int) libraryNumber.charAt(i);
            ascii += (3 % 26);
            result += (char) ascii;
        }

        assertEquals(login.authenticate(libraryNumber, password), result);
    }
}