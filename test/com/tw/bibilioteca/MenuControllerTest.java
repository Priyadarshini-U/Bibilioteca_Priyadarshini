package com.tw.bibilioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuControllerTest {

    @Test
    public void shouldReturnNewMenuController(){
        Catalog catalog = mock(Catalog.class);
        ConsoleDisplay display = mock(ConsoleDisplay.class);
        Menu menu = mock(Menu.class);

        assertEquals(new MenuController(display, menu, catalog).executeAction().getClass(), MenuController.class);
    }

    @Test
    public void shouldPrintMenu(){
        Catalog catalog = mock(Catalog.class);
        ConsoleDisplay display = mock(ConsoleDisplay.class);
        Menu menu = mock(Menu.class);
        new MenuController(display, menu, catalog).executeAction();

        verify(display).putOutput(menu);
    }

    @Test
    public void shouldGetIntegerInput(){
        Catalog catalog = mock(Catalog.class);
        ConsoleDisplay display = mock(ConsoleDisplay.class);
        Menu menu = mock(Menu.class);
        new MenuController(display, menu, catalog).executeAction();

        verify(display).getInteger();
    }

    @Test
    public void shouldCallMenuChooseWithIntegerInput(){
        Catalog catalog = mock(Catalog.class);
        ConsoleDisplay display = mock(ConsoleDisplay.class);
        Menu menu = mock(Menu.class);
        new MenuController(display, menu, catalog).executeAction();

        verify(menu).choose(anyInt(), eq(catalog), eq(display));
    }
}