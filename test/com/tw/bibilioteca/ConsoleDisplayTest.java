package com.tw.bibilioteca;

import org.junit.Test;

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
}