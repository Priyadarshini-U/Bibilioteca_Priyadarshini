package com.tw.bibilioteca;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void shouldHaveLibraryNUmber() {
        assertTrue(new User("n0","wd","dw", UserRole.USER).toString().contains("n0"));
    }

    @Test
    public void shouldHaveRole() {
        assertTrue(new User("n0","wd","dw", UserRole.ADMIN).toString().contains("ADMIN"));
    }

    @Test
    public void shouldHaveContact() {
        assertTrue(new User("n0","wd","dw1", UserRole.USER).toString().contains("n0"));
    }

    @Test
    public void shouldHavePhone() {
        assertTrue(new User("n0","wd","dw1", UserRole.GUEST).toString().contains("n0"));
    }
}