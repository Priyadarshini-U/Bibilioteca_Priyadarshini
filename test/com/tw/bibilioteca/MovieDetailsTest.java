package com.tw.bibilioteca;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class MovieDetailsTest {

    @Test
    public void shouldReturnConcatenatedStringOfMovie() {
        Date yearRealeased = new Date();
        String director = "asd";
        Double rating = 3.0;

        assertEquals(new MovieDetails(yearRealeased, director, rating).toString(), "2015 asd 3.0");
    }
}