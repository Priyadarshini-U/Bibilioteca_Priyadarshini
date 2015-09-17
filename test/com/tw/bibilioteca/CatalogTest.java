package com.tw.bibilioteca;

import org.junit.Test;

import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CatalogTest {

    @Test
    public void shouldContainEmptyStringIfListIsEmpty() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());

        assertEquals(catalog.toString(), "");
    }

    @Test
    public void shouldContainFirstBook() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails1 = new BookDetails("author1", new Date());
        String bookName1 = "name1";

        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());

        assertTrue(catalog.toString().contains("name1 " + bookDetails1.toString()));
    }

    @Test
    public void shouldContainSecondBookInNextLineOfFirstBook() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails1 = new BookDetails("author1", new Date());
        String bookName1 = "name1";
        EntityDetails bookDetails2 = new BookDetails("author2", new Date());
        String bookName2 = "name2";

        bookList.put(bookName1, bookDetails1);
        bookList.put(bookName2, bookDetails2);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());

        assertTrue(catalog.toString().contains("name2 author2 2015"));
    }

    @Test
    public void shouldContainLastBook() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails1 = new BookDetails("author1", new Date());
        String bookName1 = "name1";
        EntityDetails bookDetails2 = new BookDetails("author2", new Date());
        String bookName2 = "name2";
        EntityDetails bookDetails3 = new BookDetails("author3", new Date());
        String bookName3 = "name3";

        bookList.put(bookName1, bookDetails1);
        bookList.put(bookName2, bookDetails2);
        bookList.put(bookName3, bookDetails3);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());

        assertTrue(catalog.toString().contains(bookDetails3.toString()));
    }

    @Test
    public void shouldCheckIfBookIsInAvailableBookList() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        String bookName = "name";
        EntityDetails bookDetails = new BookDetails("author", new Date());
        bookList.put(bookName, bookDetails);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());

        assertTrue(catalog.isEntityAvailableForCheckOut(bookName));
    }

    @Test
    public void shouldCheckIfBookIsNotInAvailableBookList() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        String bookName2 = "name2";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());

        assertFalse(catalog.isEntityReturnable(bookName2));
    }

    @Test
    public void shouldCheckIfBookIsReturnable() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(new HashMap<String, EntityDetails>(), bookList);

        assertTrue(catalog.isEntityReturnable(bookName1));
    }

    @Test
    public void shouldCheckOutAndNotAllowCheckOutOfAlreadyCheckedOutBooks() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());

        catalog.checkoutEntity(bookName1);

        assertFalse(catalog.isEntityAvailableForCheckOut(bookName1));
    }

    @Test
    public void shouldReturnAndNotAllowReturnOfAlreadyReturnedBooks() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(new HashMap<String, EntityDetails>(), bookList);
        catalog.returnEntity(bookName1);

        assertFalse(catalog.isEntityReturnable(bookName1));
    }

    @Test
    public void shouldReturnAuthorAsFields() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);

        assertTrue(new Catalog(new HashMap<String, EntityDetails>(), bookList).fields().contains("author"));
    }

    @Test
    public void shouldReturnYearPublishedAsFields() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);

        assertTrue(new Catalog(new HashMap<String, EntityDetails>(), bookList).fields().contains("year published"));
    }

    @Test
    public void shouldReturnNameAsFields() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);

        assertTrue(new Catalog(new HashMap<String, EntityDetails>(), bookList).fields().contains("name"));
    }

    @Test
    public void shouldReturnEntityFieldsIfAvailableEntitesIsEmpty() {
        HashMap<String, EntityDetails> moviesList = new HashMap<String, EntityDetails>();
        String name1 = "name1";
        EntityDetails details = new BookDetails("author1", new Date());
        moviesList.put(name1, details);

        assertTrue(new Catalog(new HashMap<String, EntityDetails>(), moviesList).fields().contains("name"));
    }

    @Test
    public void shouldReturnEntityFieldsIfCheckedOutEntitesIsEmpty() {
        HashMap<String, EntityDetails> moviesList = new HashMap<String, EntityDetails>();
        String name1 = "name1";
        EntityDetails details = new BookDetails("author1", new Date());
        moviesList.put(name1, details);

        assertTrue(new Catalog(moviesList, new HashMap<String, EntityDetails>()).fields().contains("name"));
    }

    ///

    @Test
    public void shouldContainFirstMovie() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails movieDetails1 = new MovieDetails(new Date(), "director1", 10.0);
        String name1 = "name1";

        bookList.put(name1, movieDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());

        assertTrue(catalog.toString().contains("name1"));
    }

    @Test
    public void shouldContainSecondMovieInNextLineOfFirstMovie() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails movieDetails1 = new MovieDetails(new Date(), "director1", 10.0);
        String name1 = "name1";
        EntityDetails movieDetails2 = new MovieDetails(new Date(), "director2", 10.0);
        String name2 = "name2";

        bookList.put(name1, movieDetails1);
        bookList.put(name2, movieDetails2);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());

        assertTrue(catalog.toString().contains("name2"));
    }

    @Test
    public void shouldContainLastMovie() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails movieDetails1 = new MovieDetails(new Date(), "director1", 10.0);
        String name1 = "name1";
        EntityDetails movieDetails2 = new MovieDetails(new Date(), "director2", 10.0);
        String name2 = "name2";
        EntityDetails movieDetails3 = new MovieDetails(new Date(), "director3", 10.0);
        String name3 = "name3";

        bookList.put(name1, movieDetails1);
        bookList.put(name2, movieDetails2);
        bookList.put(name3, movieDetails3);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());

        assertTrue(catalog.toString().contains(movieDetails3.toString()));
    }

    @Test
    public void shouldCheckIfMovieIsInAvailableMovieList() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        String name = "name";
        EntityDetails movieDetails1 = new MovieDetails(new Date(), "director1", 10.0);
        bookList.put(name, movieDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());

        assertTrue(catalog.isEntityAvailableForCheckOut(name));
    }

    @Test
    public void shouldCheckIfMovieIsNotInAvailableMovieList() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails movieDetails1 = new MovieDetails(new Date(), "director1", 10.0);
        String name1 = "name1";
        String name2 = "name2";
        bookList.put(name1, movieDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());

        assertFalse(catalog.isEntityReturnable(name2));
    }

    @Test
    public void shouldCheckOutAndNotAllowCheckOutOfAlreadyCheckedOutMovies() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails movieDetails1 = new MovieDetails(new Date(), "director1", 10.0);
        String name1 = "name1";
        bookList.put(name1, movieDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());

        catalog.checkoutEntity(name1);

        assertFalse(catalog.isEntityAvailableForCheckOut(name1));
    }

    @Test
    public void shouldReturnDirectorAsFields() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails movieDetails1 = new MovieDetails(new Date(), "director1", 10.0);
        String name1 = "name1";
        bookList.put(name1, movieDetails1);

        assertTrue(new Catalog(new HashMap<String, EntityDetails>(), bookList).fields().contains("director"));
    }

    @Test
    public void shouldReturnYearReleasedAsFields() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails movieDetails1 = new MovieDetails(new Date(), "director1", 10.0);
        String name1 = "name1";
        bookList.put(name1, movieDetails1);

        assertTrue(new Catalog(new HashMap<String, EntityDetails>(), bookList).fields().contains("year released"));
    }

    @Test
    public void shouldReturnRatingAsFields() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails movieDetails1 = new MovieDetails(new Date(), "director1", 10.0);
        String name1 = "name1";
        bookList.put(name1, movieDetails1);

        assertTrue(new Catalog(new HashMap<String, EntityDetails>(), bookList).fields().contains("rating"));
    }

    @Test
    public void shouldReturnNameAsFieldsForMovie() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        EntityDetails movieDetails1 = new MovieDetails(new Date(), "director1", 10.0);
        String name1 = "name1";
        bookList.put(name1, movieDetails1);

        assertTrue(new Catalog(new HashMap<String, EntityDetails>(), bookList).fields().contains("name"));
    }

    @Test
    public void shouldReturnEntityFieldsIfAvailableEntitesIsEmptyForMovies() {
        HashMap<String, EntityDetails> moviesList = new HashMap<String, EntityDetails>();
        String name1 = "name1";
        EntityDetails details = new MovieDetails(new Date(), "director1", 10.0);
        moviesList.put(name1, details);

        assertTrue(new Catalog(new HashMap<String, EntityDetails>(), moviesList).fields().contains("name"));
    }

    @Test
    public void shouldReturnEntityFieldsIfCheckedOutEntitesIsEmptyForMovies() {
        HashMap<String, EntityDetails> moviesList = new HashMap<String, EntityDetails>();
        String name1 = "name1";
        EntityDetails details = new MovieDetails(new Date(), "director1", 10.0);
        moviesList.put(name1, details);

        assertTrue(new Catalog(moviesList, new HashMap<String, EntityDetails>()).fields().contains("name"));
    }
}