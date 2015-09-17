package com.tw.bibilioteca;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;

public class BookDetailsTest {

    @Test
    public void shouldHaveAuthorInItsStringOutput() {
        BookDetails bookDetails = new BookDetails("author", new Date());

        assertTrue(bookDetails.toString().contains("author"));
    }

    @Test
    public void shouldHaveYearOfPublishedInItsStringOutput() {
        BookDetails bookDetails = new BookDetails("author", new Date());

        assertTrue(bookDetails.toString().contains("2015"));
    }

    @Test
    public void shouldHaveFieldsSeparatedBySpacesInItsStringOutput() {
        BookDetails bookDetails = new BookDetails("author", new Date());

        assertTrue(bookDetails.toString().contains("author 2015"));
    }

    @Test
    public void shouldReturnAuthorAsFields() {
        String author = "def";
        Date yearPublished = new Date();
        assertTrue(new BookDetails(author, yearPublished).fields().contains("author"));
    }

    @Test
    public void shouldReturnYearPublishedAsFields() {
        String author = "def";
        Date yearPublished = new Date();
        assertTrue(new BookDetails(author, yearPublished).fields().contains("year published"));
    }
}