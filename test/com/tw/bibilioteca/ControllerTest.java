package com.tw.bibilioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

        String input = "1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(inContent, new PrintStream(outContent));
        Controller controller = new Controller(consoleDisplay, welcomeScreen,  null);

        assertEquals(controller.executeAction().getClass(), Menu.class);
    }
}