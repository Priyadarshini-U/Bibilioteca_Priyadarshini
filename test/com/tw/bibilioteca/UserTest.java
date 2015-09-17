package com.tw.bibilioteca;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void shouldHaveLibraryNUmber() {
        assertTrue(new User("n0", UserRole.USER, "wd", "dw").toString().contains("n0"));
    }

    @Test
    public void shouldHaveContact() {
        assertTrue(new User("n0", UserRole.GUEST, "wd", "dw1").toString().contains("wd"));
    }

    @Test
    public void shouldHavePhone() {
        assertTrue(new User("n0", UserRole.ADMIN, "wd", "dw1").toString().contains("dw1"));
    }
}