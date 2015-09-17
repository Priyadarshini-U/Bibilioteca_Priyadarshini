package com.tw.bibilioteca;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;

public class CheckedOutBookDetailsTest {

    @Test
    public void shouldContainBookDetailsAsConcatenatedString() {
        String author = "def";
        Date yearPublished = new Date();
        assertTrue(new CheckedOutBookDetails(new BookDetails(author, yearPublished), "011-1111").toString().contains(new BookDetails(author, yearPublished).toString()));
    }

    @Test
    public void shouldContainBookDetailsAndUserInfoAsConcatenatedString() {
        String author = "def";
        Date yearPublished = new Date();
        assertTrue(new CheckedOutBookDetails(new BookDetails(author, yearPublished), "011-1111").toString().contains(new BookDetails(author, yearPublished).toString()+" 011-1111"));
    }

    @Test
    public void shouldReturnAuthorAsFields() {
        String author = "def";
        Date yearPublished = new Date();
        assertTrue(new CheckedOutBookDetails(new BookDetails(author, yearPublished), "011-1111").fields().contains("author"));
    }

    @Test
    public void shouldReturnYearPublishedAsFields() {
        String author = "def";
        Date yearPublished = new Date();
        assertTrue(new CheckedOutBookDetails(new BookDetails(author, yearPublished), "011-1111").fields().contains("year published"));
    }

    @Test
    public void shouldReturnUserAsFields() {
        String author = "def";
        Date yearPublished = new Date();
        assertTrue(new CheckedOutBookDetails(new BookDetails(author, yearPublished), "011-1111").fields().contains("user"));
    }
}