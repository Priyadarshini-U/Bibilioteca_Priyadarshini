package com.tw.bibilioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;


public class UserRoleTest {

    @Test
    public void shouldHaveRespectiveOperationsForAdmin() {
        assertTrue(UserRole.ADMIN.getOperations().containsAll(new ArrayList<String>() {{
            add("List Books");
            add("quit");
            add("CheckOut Book");
            add("return Book");
            add("List Movies");
            add("CheckOut Movie");
            add("User Information");
            add("Book Status");
            add("Log out");
        }}));
    }

    @Test
    public void shouldHaveRespectiveDisplayOperationsIsSameAsPermissibleOPerationsForAdmin() {
        assertTrue(UserRole.ADMIN.getDisplayOperations().containsAll(UserRole.ADMIN.getOperations()));
    }

    @Test
    public void shouldHaveRespectiveOperationsForUser() {
        assertTrue(UserRole.USER.getOperations().containsAll(new ArrayList<String>() {{
            add("List Books");
            add("quit");
            add("CheckOut Book");
            add("return Book");
            add("List Movies");
            add("CheckOut Movie");
            add("User Information");
            add("Log out");
        }}));
    }

    @Test
    public void shouldHaveRespectiveDisplayOperationsIsSameAsPermissibleOPerationsForUser() {
        assertTrue(UserRole.USER.getDisplayOperations().containsAll(UserRole.USER.getOperations()));
    }


    @Test
    public void shouldHaveRespectiveDisplayOperationsForGuest() {
        assertTrue(UserRole.GUEST.getDisplayOperations().containsAll(new ArrayList<String>() {{
            add("List Books");
            add("quit");
            add("CheckOut Book");
            add("List Movies");
            add("CheckOut Movie");
            add("return Book");
            add("Log in");
        }}));
    }

    @Test
    public void shouldHaveRespectiveOperationsForGuest() {
        assertTrue(UserRole.GUEST.getOperations().containsAll(new ArrayList<String>() {{
            add("List Books");
            add("quit");
            add("CheckOut Movie");
            add("List Movies");
            add("Log in");
        }}));
    }
}