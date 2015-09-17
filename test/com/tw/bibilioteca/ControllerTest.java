package com.tw.bibilioteca;

import org.junit.Test;

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
}