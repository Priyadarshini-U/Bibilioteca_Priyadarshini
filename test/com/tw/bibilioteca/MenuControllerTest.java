package com.tw.bibilioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class MenuControllerTest {

    @Test
    public void shouldReturnNewMenuController(){
        Catalog catalog = mock(Catalog.class);
        ConsoleDisplay display = mock(ConsoleDisplay.class);
        Menu menu = mock(Menu.class);

        assertEquals(new MenuController(display, menu, catalog).executeAction().getClass(), MenuController.class);
    }
}