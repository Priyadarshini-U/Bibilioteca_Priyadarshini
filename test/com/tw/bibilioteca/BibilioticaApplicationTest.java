package com.tw.bibilioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BibilioticaApplicationTest {

    @Test
    public void shouldPrintWelcomeMessageOnStart() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String input ="1\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setOut(new PrintStream(outputStream));
        new BibilioticaApplication().start(inputStream, outputStream);

        assertTrue(outputStream.toString().contains("welcome to Bibilioteca"));
    }

    @Test
    public void shouldPrintMenuWithListBooksOption() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String input ="1\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setOut(new PrintStream(outputStream));
        new BibilioticaApplication().start(inputStream, outputStream);

        assertTrue(outputStream.toString().contains("1. List Books"));
    }

    @Test
    public void shouldPrintTheCatalog() {
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
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String input ="1\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setOut(new PrintStream(outputStream));
        new BibilioticaApplication().start(inputStream, outputStream);

        assertTrue(outputStream.toString().contains(new Catalog(bookList, new HashMap<String, BookDetails>()).toString()));
    }
}