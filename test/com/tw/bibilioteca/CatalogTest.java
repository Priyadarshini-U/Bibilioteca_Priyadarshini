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

    @Test
    public void shouldContainSecondBookInNextLineOfFirstBook() {
        List<Book> bookList = new ArrayList<Book>();
        Book book1 = new Book("name1", "author1", new Date());
        Book book2 = new Book("name2", "author2", new Date());
        bookList.add(book1);
        bookList.add(book2);
        Catalog catalog = new Catalog(bookList);

        assertTrue(catalog.toString().contains(book1.toString() + "\n" + book2.toString()));
    }
}