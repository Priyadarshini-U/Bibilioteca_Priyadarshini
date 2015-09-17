package com.tw.bibilioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ControllerTest {

    @Test
    public void shouldPrintCurrentObject() {
        WelcomeMessage welcomeScreen = new WelcomeMessage();
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);

        Controller controller = new Controller(consoleDisplay, welcomeScreen, null);
        controller.executeAction();

        verify(consoleDisplay).putOutput(welcomeScreen);
    }
    
    @Test
    public void shouldReturnNewControllerWithMenu() {
        WelcomeMessage welcomeScreen = new WelcomeMessage();

        List<Book> bookList = new ArrayList<Book>();
        Book book1 = new Book("name1", "author1", new Date());
        Book book2 = new Book("name2", "author2", new Date());
        Book book3 = new Book("name3", "author3", new Date());
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        String input = "1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(inContent, new PrintStream(outContent));
        Controller controller = new Controller(consoleDisplay, welcomeScreen,  null);

        assertEquals(controller.executeAction().getClass(), Menu.class);
    }
}