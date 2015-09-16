package com.tw.bibilioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MenuTest {

    @Test
    public void shouldReturnOpionsInAString() {
        List<String> options = new ArrayList<String>();
        options.add("1. List Book");
        assertEquals(options.toString(), new Menu(options).toString());
    }
}