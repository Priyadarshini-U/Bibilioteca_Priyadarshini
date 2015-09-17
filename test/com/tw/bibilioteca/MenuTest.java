package com.tw.bibilioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldReturnOpionsInAString() {
        List<String> options = new ArrayList<String>();
        options.add("1. List BookDetails");
        assertEquals(options.toString(), new Menu(options).toString());
    }

    @Test
    public void shouldPrintCatalogIfoptionIsOne() {
        List<String> options = new ArrayList<String>();
        options.add("1. List BookDetails");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        HashMap<String, BookDetails> bookList = new HashMap<String, BookDetails>();
        BookDetails bookDetails1 = new BookDetails("author1", new Date());
        String bookName1 = "name1";
        BookDetails bookDetails2 = new BookDetails("author2", new Date());
        String bookName2 = "name2";
        BookDetails bookDetails3 = new BookDetails("author3", new Date());
        String bookName3 = "name3";

        bookList.put(bookName1, bookDetails1);
        bookList.put(bookName2, bookDetails2);
        bookList.put(bookName3, bookDetails3);

        Catalog bookCatalog = new Catalog(bookList, new HashMap<String, BookDetails>());
        new Menu(options).choose(1, bookCatalog, new ConsoleDisplay(System.in, outputStream));

        assertTrue(outputStream.toString().contains(bookCatalog.toString()));
    }

    @Test
    public void shouldPrintInvalidOptionForOtherOptions() {
        List<String> options = new ArrayList<String>();
        options.add("1. List BookDetails");
        HashMap<String, BookDetails> bookList = new HashMap<String, BookDetails>();
        BookDetails bookDetails1 = new BookDetails("author1", new Date());
        String bookName1 = "name1";
        BookDetails bookDetails2 = new BookDetails("author2", new Date());
        String bookName2 = "name2";
        BookDetails bookDetails3 = new BookDetails("author3", new Date());
        String bookName3 = "name3";

        bookList.put(bookName1, bookDetails1);
        bookList.put(bookName2, bookDetails2);
        bookList.put(bookName3, bookDetails3);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Catalog bookCatalog = new Catalog(bookList, new HashMap<String, BookDetails>());
        new Menu(options).choose(-3, bookCatalog, new ConsoleDisplay(System.in, outputStream));

        assertTrue(outputStream.toString().contains("Invalid Option"));
    }

    @Test
    public void shouldExitOnOptionTwo() {
        exit.expectSystemExit();
        List<String> options = new ArrayList<String>();
        options.add("1. List BookDetails");
        HashMap<String, BookDetails> bookList = new HashMap<String, BookDetails>();
        BookDetails bookDetails1 = new BookDetails("author1", new Date());
        String bookName1 = "name1";
        BookDetails bookDetails2 = new BookDetails("author2", new Date());
        String bookName2 = "name2";
        BookDetails bookDetails3 = new BookDetails("author3", new Date());
        String bookName3 = "name3";

        bookList.put(bookName1, bookDetails1);
        bookList.put(bookName2, bookDetails2);
        bookList.put(bookName3, bookDetails3);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Catalog bookCatalog = new Catalog(bookList, new HashMap<String, BookDetails>());
        new Menu(options).choose(2, bookCatalog, new ConsoleDisplay(System.in, outputStream));
    }

    @Test
    public void shouldCheckoutOnOptionThree() {
        ConsoleDisplay display = mock(ConsoleDisplay.class);
        when(display.getInteger()).thenReturn(3);
        when(display.getString()).thenReturn("name1");
        Catalog bookCatalog = mock(Catalog.class);
        when(bookCatalog.isBookAvailableForCheckOut(anyString())).thenReturn(true);
        List<String> options = new ArrayList<String>();
        options.add("1. List BookDetails");
        new Menu(options).choose(3, bookCatalog, display);

        verify(bookCatalog).checkoutEntity("name1");
    }

    @Test
    public void shouldPrintSuccessfulCheckoutMessageOnCheckout() {
        ConsoleDisplay display = mock(ConsoleDisplay.class);
        when(display.getInteger()).thenReturn(3);
        when(display.getString()).thenReturn("name1");
        Catalog bookCatalog = mock(Catalog.class);
        when(bookCatalog.isBookAvailableForCheckOut(anyString())).thenReturn(true);
        List<String> options = new ArrayList<String>();
        options.add("1. List BookDetails");
        new Menu(options).choose(3, bookCatalog, display);

        verify(display).putOutput("checkout successful");
    }

    @Test
    public void shouldPrintFailureCheckoutMessageOnUnsuccesssfulCheckout() {
        ConsoleDisplay display = mock(ConsoleDisplay.class);
        when(display.getInteger()).thenReturn(3);
        when(display.getString()).thenReturn("name1");
        Catalog bookCatalog = mock(Catalog.class);
        when(bookCatalog.isBookAvailableForCheckOut(anyString())).thenReturn(false);
        List<String> options = new ArrayList<String>();
        options.add("1. List BookDetails");
        new Menu(options).choose(3, bookCatalog, display);

        verify(display).putOutput("checkout NOT successful");
    }

    @Test
    public void shouldReturnOnOptionFour() {
        ConsoleDisplay display = mock(ConsoleDisplay.class);
        when(display.getInteger()).thenReturn(3);
        when(display.getString()).thenReturn("name1");
        Catalog bookCatalog = mock(Catalog.class);
        List<String> options = new ArrayList<String>();
        options.add("1. List BookDetails");
        new Menu(options).choose(4, bookCatalog, display);

        verify(bookCatalog).returnEntity("name1");
    }
}