package com.tw.bibilioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class LoginControllerTest {

    @Test
    public void shouldPrintEnterLibraryNumber() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        String input ="peri\nperi\nperi\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(inContent, new PrintStream(outContent));
        BibilioticaData data = new BibilioticaData(catalog, null);
        IController controller = new LoginController(consoleDisplay, new Login(), data);
        controller.executeAction();

        assertTrue(outContent.toString().contains("Enter library Number"));
    }

    @Test
    public void shouldInputLibraryNumber() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        BibilioticaData data = new BibilioticaData(catalog, null);
        IController controller = new LoginController(consoleDisplay, new Login(), data);
        controller.executeAction();

        verify(consoleDisplay).getString();
    }
}