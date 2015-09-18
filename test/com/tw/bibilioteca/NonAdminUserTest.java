package com.tw.bibilioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class NonAdminUserTest {

    @Test
    public void shouldHaveRespectiveOperationsForUser() {
        assertTrue(new NonAdminUser().getOperations().containsAll(new ArrayList<String>() {{
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
        assertTrue(new NonAdminUser().getDisplayOperations().containsAll(UserRole.USER.getOperations()));
    }
}