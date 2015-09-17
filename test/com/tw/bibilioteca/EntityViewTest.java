package com.tw.bibilioteca;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EntityViewTest {

    @Test
    public void shouldContainColumnHeaderNameForEmptyLibrary() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        EntityView entityView = new EntityView(catalog);

        assertTrue(entityView.toString().contains("name"));
    }

    @Test
    public void shouldContainColumnHeaderAuthorForEmptyLibrary() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        EntityView entityView = new EntityView(catalog);

        assertTrue(entityView.toString().contains("author"));
    }

    @Test
    public void shouldContainColumnHeaderYearForEmptyLibrary() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        EntityView entityView = new EntityView(catalog);

        assertTrue(entityView.toString().contains("year published"));
    }

    @Test
    public void shouldContainBookNameOfFirstBook() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        EntityView entityView = new EntityView(catalog);

        assertTrue(entityView.toString().contains("name1"));
    }

    @Test
    public void shouldContainAuthorOfFirstBook() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        EntityView entityView = new EntityView(catalog);

        assertTrue(entityView.toString().contains("author"));
    }

    @Test
    public void shouldContainYearPublishedOfFirstBook() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        EntityView entityView = new EntityView(catalog);

        assertTrue(entityView.toString().contains("2015"));
    }

    @Test
    public void shouldContainBookNameOfLastBook() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails1 = new BookDetails("author", new Date());
        EntityDetails bookDetails2 = new BookDetails("author2", new Date());
        String bookName1 = "name1";
        String bookName2 = "name2";
        bookList.put(bookName1, bookDetails1);
        bookList.put(bookName2, bookDetails2);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        EntityView entityView = new EntityView(catalog);

        assertTrue(entityView.toString().contains("name2"));
    }

    @Test
    public void shouldContainAuthorOfLastBook() throws ParseException {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails1 = new BookDetails("author", new Date());
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date date = formatter.parse("01/29/02");
        EntityDetails bookDetails2 = new BookDetails("author2", date);
        String bookName1 = "name1";
        String bookName2 = "name2";
        bookList.put(bookName1, bookDetails1);
        bookList.put(bookName2, bookDetails2);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        EntityView entityView = new EntityView(catalog);

        assertTrue(entityView.toString().contains("author2"));
    }

    @Test
    public void shouldContainYearPublishedOfLastBook() throws ParseException {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails1 = new BookDetails("author", new Date());
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date date = formatter.parse("01/29/02");
        EntityDetails bookDetails2 = new BookDetails("author2", date);
        String bookName1 = "name1";
        String bookName2 = "name2";
        bookList.put(bookName1, bookDetails1);
        bookList.put(bookName2, bookDetails2);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        EntityView entityView = new EntityView(catalog);

        assertTrue(entityView.toString().contains("2002"));
    }

    @Test
    public void shouldContainBookNameOfAnyBookInLibrary() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails = new BookDetails("author", new Date());
        for (int i = 0; i < 10; i++) {
            String bookName = "name" + i;
            bookList.put(bookName, bookDetails);
        }
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        EntityView entityView = new EntityView(catalog);
        int randomBookNumber = Math.abs(new Random().nextInt() % 10);


        assertTrue(entityView.toString().contains("name" + (randomBookNumber + 1)));
    }

    @Test
    public void shouldHaveSpacingBasedLineLengthForFirstLine() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails = new BookDetails("author", new Date());
        for (int i = 0; i < 10; i++) {
            String bookName = "name" + i;
            bookList.put(bookName, bookDetails);
        }
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        EntityView entityView = new EntityView(catalog);
        String outputString = entityView.toString();
        String lastLine = outputString.substring(0, outputString.indexOf("\n"));


        assertEquals(lastLine.length(), catalog.fields().size() * 20);
    }

    @Test
    public void shouldHaveSpacingBasedLineLengthForLastLine() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails = new BookDetails("author", new Date());
        for (int i = 0; i < 10; i++) {
            String bookName = "name" + i;
            bookList.put(bookName, bookDetails);
        }
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        EntityView entityView = new EntityView(catalog);
        String outputString = entityView.toString();
        outputString = outputString.substring(0, outputString.length() -1);
        String lastLine = outputString.substring(outputString.lastIndexOf("\n")+1);


        assertEquals(lastLine.length(), catalog.fields().size() * 20);
    }

    @Test
    public void shouldHaveOnlySeparatorAsLastLine() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails = new BookDetails("author", new Date());
        for (int i = 0; i < 10; i++) {
            String bookName = "name" + i;
            bookList.put(bookName, bookDetails);
        }
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        EntityView entityView = new EntityView(catalog);
        String outputString = entityView.toString();
        outputString = outputString.substring(0, outputString.length() -1);
        String lastLine = outputString.substring(outputString.lastIndexOf("\n")+1);
        lastLine = lastLine.replace("-","");

        assertEquals(lastLine.length(), 0);
    }

    @Test
    public void shouldHaveOnlySeparatorAsLineAfterColumnHeaders() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails = new BookDetails("author", new Date());
        for (int i = 0; i < 10; i++) {
            String bookName = "name" + i;
            bookList.put(bookName, bookDetails);
        }
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        EntityView entityView = new EntityView(catalog);
        String outputString = entityView.toString();
        Scanner scanner = new Scanner(outputString);
        scanner.nextLine();
        String secondLine = scanner.nextLine();
        secondLine = secondLine.replace("-","");

        assertEquals(secondLine.length(), 0);
    }
}