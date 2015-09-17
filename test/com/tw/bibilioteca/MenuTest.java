package com.tw.bibilioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MenuTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldReturnOpionsInAString() {
        List<String> options = new ArrayList<String>();
        options.add("1. List Book");
        assertEquals(options.toString(), new Menu(options).toString());
    }

    @Test
    public void shouldPrintCatalogIfoptionIsOne() {
        List<String> options = new ArrayList<String>();
        options.add("1. List Book");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Catalog bookCatalog = new Catalog(new ArrayList<Book>() {{
            add(new Book("name", "author", new Date()));
        }});
        new Menu(options).choose(1, bookCatalog);

        assertTrue(outputStream.toString().contains(bookCatalog.toString()));
    }

    @Test
    public void shouldPrintInvalidOptionForOtherOptions() {
        List<String> options = new ArrayList<String>();
        options.add("1. List Book");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Catalog bookCatalog = new Catalog(new ArrayList<Book>() {{
            add(new Book("name", "author", new Date()));
        }});
        new Menu(options).choose(3, bookCatalog);

        assertTrue(outputStream.toString().contains("Invalid Option"));
    }

    @Test
    public void shouldExitOnOptionTwo() {
        exit.expectSystemExit();
        List<String> options = new ArrayList<String>();
        options.add("1. List Book");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Catalog bookCatalog = new Catalog(new ArrayList<Book>() {{
            add(new Book("name", "author", new Date()));
        }});
        new Menu(options).choose(2, bookCatalog);
    }


}