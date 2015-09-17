package com.tw.bibilioteca;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BookDetails {
    private String author;
    private Date yearPublished;

    public BookDetails(String author, Date yearPublished) {
        this.author = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(yearPublished);
        return author + " " + calendar.get(Calendar.YEAR);
    }

    public List<String> fields() {
        List<String> fields = new ArrayList<String>();
        fields.add("author");
        fields.add("year published");
        return fields;
    }
}
