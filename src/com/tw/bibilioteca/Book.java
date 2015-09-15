package com.tw.bibilioteca;

import java.util.Calendar;
import java.util.Date;

public class Book {
    private String name;
    private String author;
    private Date yearPublished;

    public Book(String name, String author, Date yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(yearPublished);
        return name + author + calendar.get(Calendar.YEAR);
    }
}
