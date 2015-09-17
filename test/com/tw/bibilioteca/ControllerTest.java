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
        IController controller = new Controller(consoleDisplay, welcomeScreen,  new BibilioticaData(null, null, new GuestUser().authenticate()));

        assertEquals(controller.executeAction().getClass(), MenuController.class);
    }
}