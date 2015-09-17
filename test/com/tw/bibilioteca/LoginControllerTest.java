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
        String input = "peri\nperi\nperi\n";
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

        verify(consoleDisplay, times(2)).getString();
    }

    @Test
    public void shouldPrintEnterPassword() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        String input = "peri\nperi\nperi\n";
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

        assertTrue(outContent.toString().contains("Enter Password"));
    }

    @Test
    public void shouldInputPassword() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        BibilioticaData data = new BibilioticaData(catalog, null);
        IController controller = new LoginController(consoleDisplay, new Login(), data);
        controller.executeAction();

        verify(consoleDisplay, times(2)).getString();
    }

    @Test
    public void shouldInvokeLoginAuthenticateWithInputLibraryNumberAndInputPassword() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        when(consoleDisplay.getString()).thenReturn("011-1111").thenReturn("1");
        BibilioticaData data = new BibilioticaData(catalog, null);
        Login login = mock(Login.class);
        when(login.authenticate(anyString(), anyString())).thenReturn(new GuestUser().authenticate());
        IController controller = new LoginController(consoleDisplay, login, data);
        controller.executeAction();

        verify(login).authenticate("011-1111", "1");
    }

    @Test
    public void shouldPrintUnSuccessfulMessageForGuest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        String input = "011-1111\n3\n";
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

        assertTrue(outContent.toString().contains("Login Failed"));
    }

    @Test
    public void shouldPrintSuccessfulMessageForValidLogin() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        String input = "011-1111\n1\n";
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

        assertTrue(outContent.toString().contains("Login Succesful"));
    }

    @Test
    public void shouldLoginControllerReturnNewMenuController() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        String input = "011-1111\n3\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(inContent, new PrintStream(outContent));
        BibilioticaData data = new BibilioticaData(catalog, null);
        IController controller = new LoginController(consoleDisplay, new Login(), data);
        IController result = controller.executeAction();

        assertEquals(result.getClass(), MenuController.class);
    }

    @Test
    public void shouldReturnNewMenuControllerWithChangedMenuOptions() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        String input = "011-1111\n1\n1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(inContent, new PrintStream(outContent));
        BibilioticaData data = new BibilioticaData(catalog, null);
        IController controller = new LoginController(consoleDisplay, new Login(), data);
        IController result = controller.executeAction();
        result.executeAction();

        assertTrue(outContent.toString().contains(new Menu(UserRole.ADMIN.getDisplayOperations()).toString()));
    }
}