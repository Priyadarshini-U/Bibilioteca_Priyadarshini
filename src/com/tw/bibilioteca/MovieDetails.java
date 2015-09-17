package com.tw.bibilioteca;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    public List<String> fields() {
        List<String> fields = new ArrayList<String>();
        fields.add("year released");
        fields.add("director");
        fields.add("rating");
        return fields;
    }
}
