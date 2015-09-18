package com.tw.bibilioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AdminTest {

    @Test
    public void shouldHaveRespectiveOperationsForAdmin() {
        assertTrue(new Admin().getOperations().containsAll(new ArrayList<String>() {{
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
        assertTrue(new Admin().getDisplayOperations().containsAll(new Admin().getOperations()));
    }
}