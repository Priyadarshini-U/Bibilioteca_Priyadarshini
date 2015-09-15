package com.tw.bibilioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CatalogTest {

    @Test
    public void shouldContainEmptyStringIfListIsEmpty() {
        List<Book> bookList = new ArrayList<Book>();
        Catalog catalog = new Catalog(bookList);

        assertEquals(catalog.toString(), "");
    }

    @Test
    public void shouldContainFirstBook() {
        List<Book> bookList = new ArrayList<Book>();
        Book book = new Book("name", "author", new Date());
        bookList.add(book);
        Catalog catalog = new Catalog(bookList);

        assertTrue(catalog.toString().contains(book.toString()));
    }
}