package com.tw.bibilioteca;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovieDetailsTest {

    @Test
    public void shouldReturnConcatenatedStringOfMovie() {
        Date yearRealeased = new Date();
        String director = "asd";
        Double rating = 3.0;

        assertEquals(new MovieDetails(yearRealeased, director, rating).toString(), "2015 asd 3.0");
    }

    @Test
    public void shouldReturnYearReleasedAsFields() {
        Date yearRealeased = new Date();
        String director = "asd";
        Double rating = 3.0;

        assertTrue(new MovieDetails(yearRealeased, director, rating).fields().contains("year released"));
    }

    @Test
    public void shouldReturnDirectorAsFields() {
        Date yearRealeased = new Date();
        String director = "asd";
        Double rating = 3.0;

        assertTrue(new MovieDetails(yearRealeased, director, rating).fields().contains("director"));
    }

    @Test
    public void shouldReturnRatingAsFields() {
        Date yearRealeased = new Date();
        String director = "asd";
        Double rating = 3.0;

        assertTrue(new MovieDetails(yearRealeased, director, rating).fields().contains("rating"));
    }
}