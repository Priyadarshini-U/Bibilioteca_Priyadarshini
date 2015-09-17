package com.tw.bibilioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CatalogTest {

    @Test
    public void shouldContainEmptyStringIfListIsEmpty() {
        HashMap<String, BookDetails> bookList = new HashMap<String, BookDetails>();
        Catalog catalog = new Catalog(bookList, new HashMap<String, BookDetails>());

        assertEquals(catalog.toString(), "");
    }

    @Test
    public void shouldContainFirstBook() {
        HashMap<String, BookDetails> bookList = new HashMap<String, BookDetails>();
        BookDetails bookDetails1 = new BookDetails("author1", new Date());
        String bookName1 = "name1";

        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, BookDetails>());

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
        Catalog catalog = new Catalog(bookList, new HashMap<String, BookDetails>());

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
        Catalog catalog = new Catalog(bookList, new HashMap<String, BookDetails>());

        assertTrue(catalog.toString().contains(bookDetails3.toString()));
    }

    @Test
    public void shouldCheckIfBookIsInAvailableBookList() {
        HashMap<String, BookDetails> bookList = new HashMap<String, BookDetails>();
        String bookName = "name";
        BookDetails bookDetails = new BookDetails("author", new Date());
        bookList.put(bookName, bookDetails);
        Catalog catalog = new Catalog(bookList, new HashMap<String, BookDetails>());

        assertTrue(catalog.isBookAvailableForCheckOut(bookName));
    }

    @Test
    public void shouldCheckIfBookIsNotInAvailableBookList() {
        HashMap<String, BookDetails> bookList = new HashMap<String, BookDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        String bookName2 = "name2";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, BookDetails>());

        assertFalse(catalog.isBookReturnable(bookName2));
    }

    @Test
    public void shouldCheckIfBookIsReturnable() {
        HashMap<String, BookDetails> bookList = new HashMap<String, BookDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(new HashMap<String, BookDetails>(), bookList);

        assertTrue(catalog.isBookReturnable(bookName1));
    }
}