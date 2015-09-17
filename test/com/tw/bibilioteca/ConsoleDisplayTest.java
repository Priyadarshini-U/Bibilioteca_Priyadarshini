package com.tw.bibilioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ConsoleDisplayTest {

    @Test
    public void shouldPrintObjectsToStringOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ConsoleDisplay display = new ConsoleDisplay(System.in, new PrintStream(outContent));

        Object object = new Object();
        display.putOutput(object);

        assertEquals(object.toString()+"\n", outContent.toString());
    }

    @Test
    public void shouldGetIntegerFromInputStream() {
        String input = "1\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());

        ConsoleDisplay display = new ConsoleDisplay(inContent, System.out);
        int inputInteger = display.getInteger();

        assertEquals(inputInteger, 1);
    }

    @Test
    public void shouldGetStringFromInputStream() {
        String input = "anna kareina";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());

        ConsoleDisplay display = new ConsoleDisplay(inContent, System.out);
        String inputString = display.getString();

        assertEquals(inputString, "anna kareina");
    }
}