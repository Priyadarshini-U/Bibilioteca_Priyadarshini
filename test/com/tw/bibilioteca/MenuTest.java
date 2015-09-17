package com.tw.bibilioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MenuTest {

    @Test
    public void shouldReturnListAsString() {
        List<String> listOptions = new ArrayList<String>() {{
            add("List Books");
            add("quit");
            add("CheckOut Book");
            add("return Book");
            add("List Movies");
            add("CheckOut Movie");
        }};
        Menu menu = new Menu(listOptions);

        assertEquals(menu.toString(), "1. List Books 2. quit 3. CheckOut Book 4. return Book 5. List Movies 6. CheckOut Movie \n");
    }


    @Test
    public void shouldContainEmptyStringForEmptyListOfOptions() {
        List<String> listOptions = new ArrayList<String>() {{
            add("List Books");
        }};
        Menu menu = new Menu(listOptions);

        assertTrue(menu.toString().contains(""));
    }

    @Test
    public void shouldContainFirstOptionInString() {
        List<String> listOptions = new ArrayList<String>() {{
            add("List Books");
        }};
        Menu menu = new Menu(listOptions);

        assertTrue(menu.toString().contains("List Books"));
    }

    @Test
    public void shouldContainLastOptionInString() {
        List<String> listOptions = new ArrayList<String>() {{
            add("List Books");
            add("quit");
            add("CheckOut Book");
        }};
        Menu menu = new Menu(listOptions);

        assertTrue(menu.toString().contains("CheckOut Book"));
    }

    @Test
    public void shouldPrependOptionNumberForSingleOptionInList() {
        List<String> listOptions = new ArrayList<String>() {{
            add("List Books");
        }};
        Menu menu = new Menu(listOptions);

        assertTrue(menu.toString().contains("1. List Books"));
    }

    @Test
    public void shouldPrependOptionNumberForLastOptionInList() {
        List<String> listOptions = new ArrayList<String>() {{
            add("List Books");
            add("quit");
            add("CheckOut Book");
        }};
        Menu menu = new Menu(listOptions);

        assertTrue(menu.toString().contains("3. CheckOut Book"));
    }

    @Test
    public void shouldReturnFirstOperationWhenInListOnChoosingOne() {
        List<String> listOptions = new ArrayList<String>() {{
            add("List Books");
            add("quit");
            add("CheckOut Book");
        }};
        Menu menu = new Menu(listOptions);

        assertEquals(menu.choose(1), "List Books");
    }

    @Test
    public void shouldReturnSecondOperationWhenInListOnChoosingTwo() {
        List<String> listOptions = new ArrayList<String>() {{
            add("List Books");
            add("quit");
            add("CheckOut Book");
        }};
        Menu menu = new Menu(listOptions);

        assertEquals(menu.choose(2), "quit");
    }

    @Test
    public void shouldReturnLastOperationWhenInListOnChoosingLastOption() {
        List<String> listOptions = new ArrayList<String>() {{
            add("List Books");
            add("quit");
            add("CheckOut Book");
            add("CheckOut Movies");
        }};
        Menu menu = new Menu(listOptions);

        assertEquals(menu.choose(4), "CheckOut Movies");
    }
}