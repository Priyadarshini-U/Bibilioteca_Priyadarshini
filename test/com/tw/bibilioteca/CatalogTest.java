package com.tw.bibilioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CatalogTest {

    @Test
    public void shouldContainEmptyStringIfListIsEmpty() {
        HashMap<String, BookDetails> bookList = new HashMap<String, BookDetails>();
        Catalog catalog = new Catalog(bookList);

        assertEquals(catalog.toString(), "");
    }

    @Test
    public void shouldContainFirstBook() {
        HashMap<String, BookDetails> bookList = new HashMap<String, BookDetails>();
        BookDetails bookDetails1 = new BookDetails("author1", new Date());
        String bookName1 = "name1";

        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList);

        assertTrue(catalog.toString().contains("name1 " + bookDetails1.toString()));
    }

    @Test
    public void shouldContainSecondBookInNextLineOfFirstBook() {
        HashMap<String, BookDetails> bookList = new HashMap<String, BookDetails>();
        BookDetails bookDetails1 = new BookDetails("author1", new Date());
        String bookName1 = "name1";
        BookDetails bookDetails2 = new BookDetails("author2", new Date());
        String bookName2 = "name2";

        bookList.put(bookName1, bookDetails1);
        bookList.put(bookName2, bookDetails2);
        Catalog catalog = new Catalog(bookList);

        assertTrue(catalog.toString().contains("name2 author2 2015"));
    }

    @Test
    public void shouldContainLastBook() {
        HashMap<String, BookDetails> bookList = new HashMap<String, BookDetails>();
        BookDetails bookDetails1 = new BookDetails("author1", new Date());
        String bookName1 = "name1";
        BookDetails bookDetails2 = new BookDetails("author2", new Date());
        String bookName2 = "name2";
        BookDetails bookDetails3 = new BookDetails("author3", new Date());
        String bookName3 = "name3";

        bookList.put(bookName1, bookDetails1);
        bookList.put(bookName2, bookDetails2);
        bookList.put(bookName3, bookDetails3);
        Catalog catalog = new Catalog(bookList);

        assertTrue(catalog.toString().contains(bookDetails3.toString()));
    }
}