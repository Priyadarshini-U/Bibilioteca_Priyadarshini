package com.tw.bibilioteca;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;

public class BookTest {

    @Test
    public void shouldHaveNameInItsStringOutput() {
        Book book = new Book("name", "author", new Date());

        assertTrue(book.toString().contains("name"));
    }

    @Test
    public void shouldHaveAuthorInItsStringOutput() {
        Book book = new Book("name", "author", new Date());

        assertTrue(book.toString().contains("author"));
    }

    @Test
    public void shouldHaveYearOfPublishedInItsStringOutput() {
        Book book = new Book("name", "author", new Date());

        assertTrue(book.toString().contains("2015"));
    }

    @Test
    public void shouldHaveFieldsSeparatedBySpacesInItsStringOutput() {
        Book book = new Book("name", "author", new Date());

        assertTrue(book.toString().contains("name author 2015"));
    }
}