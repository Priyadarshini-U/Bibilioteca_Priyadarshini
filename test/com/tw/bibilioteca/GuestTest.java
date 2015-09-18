package com.tw.bibilioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GuestTest {

    @Test
    public void shouldHaveRespectiveDisplayOperationsForGuest() {
        assertTrue(new Guest().getDisplayOperations().containsAll(new ArrayList<String>() {{
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
        assertTrue(new Guest().getOperations().containsAll(new ArrayList<String>() {{
            add("List Books");
            add("quit");
            add("CheckOut Movie");
            add("List Movies");
            add("Log in");
        }}));
    }

}