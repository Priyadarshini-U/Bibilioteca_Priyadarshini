package com.tw.bibilioteca;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BookDetails implements EntityDetails{
    protected String author;
    protected Date yearPublished;

    public BookDetails(String author, Date yearPublished) {
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public BookDetails(BookDetails bookDetails) {
        this.author = bookDetails.author;
        this.yearPublished = bookDetails.yearPublished;
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
