package com.tw.bibilioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BibilioticaApplicationTest {

    @Test
    public void shouldPrintWelcomeMessageOnStart() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        new BibilioticaApplication(System.in, System.out).start();

        assertTrue(outputStream.toString().contains("Welcome to bibiliotica"));
    }

    @Test
    public void shouldPrintMenuWithListBooksOption() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        new BibilioticaApplication(System.in, System.out).start();

        assertTrue(outputStream.toString().contains("1. List Books"));
    }
}