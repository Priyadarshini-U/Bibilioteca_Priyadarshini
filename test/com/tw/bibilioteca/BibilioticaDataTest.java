package com.tw.bibilioteca;

import org.junit.Test;

import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class BibilioticaDataTest {

    @Test
    public void sholdReturnSessionBookLibrary() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        HashMap<String, EntityDetails> movieList = new HashMap<String, EntityDetails>();
        Date yearRealeased = new Date();
        String director = "asd";
        Double rating = 3.0;
        MovieDetails movieDetails = new MovieDetails(yearRealeased, director, rating);
        movieList.put(bookName1, movieDetails);
        Catalog movieCatalog = new Catalog(movieList, new HashMap<String, EntityDetails>());
        BibilioticaData session = new BibilioticaData(catalog, movieCatalog);

        assertEquals(session.getBookLibrary(), catalog);
    }

    @Test
    public void sholdReturnSessionMovieLibrary() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        Catalog catalog = new Catalog(bookList, new HashMap<String, EntityDetails>());
        HashMap<String, EntityDetails> movieList = new HashMap<String, EntityDetails>();
        Date yearRealeased = new Date();
        String director = "asd";
        Double rating = 3.0;
        MovieDetails movieDetails = new MovieDetails(yearRealeased, director, rating);
        movieList.put(bookName1, movieDetails);
        Catalog movieCatalog = new Catalog(movieList, new HashMap<String, EntityDetails>());
        BibilioticaData session = new BibilioticaData(catalog, movieCatalog);

        assertEquals(session.getMoviesLibrary(), movieCatalog);
    }
}