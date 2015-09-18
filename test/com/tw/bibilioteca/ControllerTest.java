package com.tw.bibilioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ControllerTest {

    @Test
    public void shouldPrintCurrentObject() {
        WelcomeMessage welcomeScreen = new WelcomeMessage();
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);

        IController controller = new Controller(consoleDisplay, welcomeScreen, new BibilioticaData(null, null, new GuestUser().authenticate()));
        controller.executeAction();

        verify(consoleDisplay).putOutput(welcomeScreen);
    }

    @Test
    public void shouldReturnNewControllerWithMenu() {
        WelcomeMessage welcomeScreen = new WelcomeMessage();

        String input = "1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(inContent, new PrintStream(outContent));
        IController controller = new Controller(consoleDisplay, welcomeScreen, new BibilioticaData(null, null, new GuestUser().authenticate()));

        assertEquals(controller.executeAction().getClass(), MenuController.class);
    }

    @Test
    public void shouldReturnNewControllerWithMenuWithOptionsOfAdminUsersForAdmins() {
        WelcomeMessage welcomeScreen = new WelcomeMessage();

        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        String input = "1\n2\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(inContent, new PrintStream(outContent));
        Controller controller = new Controller(consoleDisplay, welcomeScreen, new BibilioticaData(catalog, null, "34404444"));
        IController result = controller.executeAction();
        result.executeAction();

        assertTrue(outContent.toString().contains(new Menu(new Admin().getDisplayOperations()).toString()));
    }

    @Test
    public void shouldReturnNewControllerWithMenuWithOptionsOfUsersForNonAdmins() {
        WelcomeMessage welcomeScreen = new WelcomeMessage();

        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        String input = "1\n2\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(inContent, new PrintStream(outContent));
        Controller controller = new Controller(consoleDisplay, welcomeScreen, new BibilioticaData(catalog, null, "35505555"));
        IController result = controller.executeAction();
        result.executeAction();

        assertTrue(outContent.toString().contains(new Menu(new NonAdminUser().getDisplayOperations()).toString()));
    }

    @Test
    public void shouldReturnNewControllerWithMenuWithOptionsOfGuestsForGuestUsers() {
        WelcomeMessage welcomeScreen = new WelcomeMessage();

        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        String input = "1\n2\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(inContent, new PrintStream(outContent));
        Controller controller = new Controller(consoleDisplay, welcomeScreen, new BibilioticaData(catalog, null, new GuestUser().authenticate()));
        IController result = controller.executeAction();
        result.executeAction();

        assertTrue(outContent.toString().contains(new Menu(new Guest().getDisplayOperations()).toString()));
    }
}