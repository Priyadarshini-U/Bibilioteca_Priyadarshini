package com.tw.bibilioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuControllerTest {
    private List<String> optionsMenu = new ArrayList<String>() {{
        add("1. List Books");
        add("2. quit");
        add("3. Checkout Book");
        add("4. Return Book");
    }};

    @Test
    public void shouldReturnNewMenuController(){
        Catalog catalog = mock(Catalog.class);
        ConsoleDisplay display = mock(ConsoleDisplay.class);
        when(display.getString()).thenReturn("1\n");
        Menu menu = mock(Menu.class);

        assertEquals(new MenuController(display, menu, catalog).executeAction().getClass(), MenuController.class);
    }

    @Test
    public void shouldPrintMenu(){
        Catalog catalog = mock(Catalog.class);
        ConsoleDisplay display = mock(ConsoleDisplay.class);
        when(display.getString()).thenReturn("1\n");
        Menu menu = mock(Menu.class);
        new MenuController(display, menu, catalog).executeAction();

        verify(display).putOutput(menu);
    }

    @Test
    public void shouldGetIntegerInput(){
        Catalog catalog = mock(Catalog.class);
        ConsoleDisplay display = mock(ConsoleDisplay.class);
        when(display.getString()).thenReturn("1\n");
        Menu menu = mock(Menu.class);
        new MenuController(display, menu, catalog).executeAction();

        verify(display).getString();
    }

    @Test
    public void shouldGetChoiceAndReturnControllerIfChoiceIsOne() {
        Menu menu = new Menu(optionsMenu);

        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        String input = "1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(inContent, System.out);
        MenuController controller = new MenuController(consoleDisplay, menu, catalog);
        IController result = controller.executeAction();

        assertEquals(result.getClass(), Controller.class);
    }

    @Test
    public void shouldGetChoiceAndReturnControllerWithLibraryDataIfChoiceIsOne() {
        Menu menu = new Menu(optionsMenu);

        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        String input = "1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(inContent, new PrintStream(outContent));
        MenuController controller = new MenuController(consoleDisplay, menu, catalog);
        IController result = controller.executeAction();
        result.executeAction();
        System.setIn(System.in);

        assertTrue(outContent.toString().contains(new EntityView(catalog).toString()));
    }

    @Test
    public void shouldCheckOutBookIfChoiceIsThree() {
        Menu menu = new Menu(optionsMenu);

        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        when(consoleDisplay.getString()).thenReturn("3").thenReturn("name1");
        MenuController controller = new MenuController(consoleDisplay, menu, catalog);
        IController result = controller.executeAction();
        result.executeAction();

        assertFalse(catalog.isEntityAvailableForCheckOut(bookName1));
    }

    @Test
    public void shouldReturnBookIfChoiceIsFour() {
        Menu menu = new Menu(optionsMenu);

        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        when(consoleDisplay.getString()).thenReturn("3").thenReturn("name1");
        MenuController controller = new MenuController(consoleDisplay, menu, catalog);
        IController result = controller.executeAction();
        result.executeAction();

        assertFalse(catalog.isEntityAvailableForCheckOut(bookName1));
    }
}