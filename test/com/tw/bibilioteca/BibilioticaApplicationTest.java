package com.tw.bibilioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BibilioticaApplicationTest {

    @Test
    public void shouldPrintWelcomeMessageOnStart() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String input ="1\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setOut(new PrintStream(outputStream));
        new BibilioticaApplication(inputStream, outputStream).start();

        assertTrue(outputStream.toString().contains("welcome to Bibilioteca"));
    }

    @Test
    public void shouldPrintMenuWithListBooksOption() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String input ="1\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setOut(new PrintStream(outputStream));
        new BibilioticaApplication(inputStream, outputStream).start();

        assertTrue(outputStream.toString().contains("1. List Books"));
    }

    @Test
    public void shouldPrintTheCatalog() {
        List<Book> bookList = new ArrayList<Book>();
        Book book1 = new Book("name1", "author1", new Date());
        Book book2 = new Book("name2", "author2", new Date());
        Book book3 = new Book("name3", "author3", new Date());
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String input ="1\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setOut(new PrintStream(outputStream));
        new BibilioticaApplication(inputStream, outputStream).start();

        assertTrue(outputStream.toString().contains(new Catalog(bookList).toString()));
    }
}