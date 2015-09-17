package com.tw.bibilioteca;

import java.util.Calendar;
import java.util.Date;

public class MovieDetails {
    private Date yearReleased;
    private String director;
    private Double rating;

    public MovieDetails(Date yearReleased, String director, Double rating) {
        this.yearReleased = yearReleased;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String toString() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(yearReleased);
        return calendar.get(Calendar.YEAR) + " " + director + " " + rating;
    }
}
