package com.tw.bibilioteca;

import org.junit.Test;
import org.mockito.InOrder;

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
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuControllerTest {
    private List<String> optionsMenu = new ArrayList<String>() {{
        add("List Books");
        add("List Movies");
        add("quit");
        add("CheckOut Book");
        add("CheckOut Movie");
        add("return Book");
        add("Log in");
        add("Log out");
    }};

    @Test
    public void shouldPrintMenu(){
        BibilioticaData catalog = mock(BibilioticaData.class);
        when(catalog.getSessionToken()).thenReturn("34404444");
        ConsoleDisplay display = mock(ConsoleDisplay.class);
        when(display.getString()).thenReturn("1\n");
        Menu menu = mock(Menu.class);
        when(menu.choose(anyInt())).thenReturn("inalid");
        new MenuController(display, menu, catalog).executeAction();

        verify(display).putOutput(menu);
    }

    @Test
    public void shouldGetInput(){
        BibilioticaData catalog = mock(BibilioticaData.class);
        when(catalog.getSessionToken()).thenReturn("34404444");
        ConsoleDisplay display = mock(ConsoleDisplay.class);
        when(display.getString()).thenReturn("1\n");
        Menu menu = mock(Menu.class);
        when(menu.choose(anyInt())).thenReturn("inalid");
        new MenuController(display, menu, catalog).executeAction();

        verify(display).getInteger();
    }

    @Test
    public void shouldGetChoiceAndReturnControllerIfChoiceIsOne() {
        Menu menu = new Menu(optionsMenu);

        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        String input = "1\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(inContent, System.out);
        MenuController controller = new MenuController(consoleDisplay, menu, new BibilioticaData(catalog, null, new GuestUser().authenticate()));
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
        String input = "1\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(inContent, new PrintStream(outContent));
        MenuController controller = new MenuController(consoleDisplay, menu, new BibilioticaData(catalog, null, new GuestUser().authenticate()));
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
        when(consoleDisplay.getInteger()).thenReturn(4);
        when(consoleDisplay.getString()).thenReturn("name1");
        MenuController controller = new MenuController(consoleDisplay, menu, new BibilioticaData(catalog, null, "34404444"));
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
        when(consoleDisplay.getString()).thenReturn("name1");
        when(consoleDisplay.getInteger()).thenReturn(6);
        MenuController controller = new MenuController(consoleDisplay, menu, new BibilioticaData(catalog, null, "34404444"));
        IController result = controller.executeAction();
        result.executeAction();

        assertTrue(catalog.isEntityAvailableForCheckOut(bookName1));
    }

    @Test
    public void shouldGetChoiceAndReturnControllerWithLibraryDataOfMoviesIfChoiceIsFive() {
        Menu menu = new Menu(optionsMenu);

        HashMap<String, EntityDetails> moviesList = new HashMap<String, EntityDetails>();
        String name1 = "name1";
        EntityDetails details = new MovieDetails(new Date(), "author1", 3.0);
        moviesList.put(name1, details);
        Catalog catalog = new Catalog(moviesList, new HashMap<String, EntityDetails>());
        String input = "2\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(inContent, new PrintStream(outContent));
        MenuController controller = new MenuController(consoleDisplay, menu, new BibilioticaData(null, catalog, "34404444"));
        IController result = controller.executeAction();
        result.executeAction();

        assertTrue(outContent.toString().contains(new EntityView(catalog).toString()));
    }

    @Test
    public void shouldCheckOutMovieIfChoiceIsSix() {
        Menu menu = new Menu(optionsMenu);

        HashMap<String, EntityDetails> moviesList = new HashMap<String, EntityDetails>();
        String name1 = "name1";
        EntityDetails details = new MovieDetails(new Date(), "author1", 3.0);
        moviesList.put(name1, details);
        Catalog catalog = new Catalog(moviesList, new HashMap<String, EntityDetails>());
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        when(consoleDisplay.getString()).thenReturn("name1");
        when(consoleDisplay.getInteger()).thenReturn(5);

        MenuController controller = new MenuController(consoleDisplay, menu, new BibilioticaData(null, catalog, "34404444"));
        IController result = controller.executeAction();
        result.executeAction();

        assertFalse(catalog.isEntityAvailableForCheckOut(name1));
    }

    @Test
    public void shouldReturnLoginControllerForLoginOption() {
        Menu menu = new Menu(optionsMenu);

        HashMap<String, EntityDetails> moviesList = new HashMap<String, EntityDetails>();
        String name1 = "name1";
        EntityDetails details = new MovieDetails(new Date(), "author1", 3.0);
        moviesList.put(name1, details);
        Catalog catalog = new Catalog(moviesList, new HashMap<String, EntityDetails>());
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        when(consoleDisplay.getString()).thenReturn("name1");
        when(consoleDisplay.getInteger()).thenReturn(7);

        MenuController controller = new MenuController(consoleDisplay, menu, new BibilioticaData(null, catalog, new GuestUser().authenticate()));
        IController result = controller.executeAction();

        assertEquals(result.getClass(), LoginController.class);
    }

    @Test
    public void shouldReturnGuestSessionAfterLogout() {
        Menu menu = new Menu(optionsMenu);

        HashMap<String, EntityDetails> moviesList = new HashMap<String, EntityDetails>();
        String name1 = "name1";
        EntityDetails details = new MovieDetails(new Date(), "author1", 3.0);
        moviesList.put(name1, details);
        Catalog catalog = new Catalog(moviesList, new HashMap<String, EntityDetails>());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String input ="8\n2\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(inputStream, outputStream);

        MenuController controller = new MenuController(consoleDisplay, menu, new BibilioticaData(null, catalog, "34404444"));
        IController result = controller.executeAction();
        result.executeAction();

        assertTrue(outputStream.toString().contains(new Menu(UserRole.GUEST.getDisplayOperations()).toString()));
    }

    @Test
    public void shouldReturnLoginControllerIfOperationIsNotValidForCurrentUser() {
        Menu menu = new Menu(optionsMenu);

        HashMap<String, EntityDetails> moviesList = new HashMap<String, EntityDetails>();
        String name1 = "name1";
        EntityDetails details = new MovieDetails(new Date(), "author1", 3.0);
        moviesList.put(name1, details);
        Catalog catalog = new Catalog(moviesList, new HashMap<String, EntityDetails>());
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        when(consoleDisplay.getString()).thenReturn("name1");
        when(consoleDisplay.getInteger()).thenReturn(4);

        MenuController controller = new MenuController(consoleDisplay, menu, new BibilioticaData(null, catalog, new GuestUser().authenticate()));
        IController result = controller.executeAction();

        assertEquals(result.getClass(), LoginController.class);
    }
}