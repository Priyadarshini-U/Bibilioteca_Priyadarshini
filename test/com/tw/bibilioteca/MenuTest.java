package com.tw.bibilioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MenuTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldReturnOpionsInAString() {
        List<String> options = new ArrayList<String>();
        options.add("1. List BookDetails");
        assertEquals(options.toString(), new Menu(options).toString());
    }
}