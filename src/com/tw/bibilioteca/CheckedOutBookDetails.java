package com.tw.bibilioteca;

import java.util.Date;
import java.util.List;

public class CheckedOutBookDetails extends BookDetails {
    private String libraryNumber;

    public CheckedOutBookDetails(String author, Date yearPublished, String libraryNumber) {
        super(author, yearPublished);
        this.libraryNumber = libraryNumber;
    }

    @Override
    public String toString(){
        return super.toString() + " " + libraryNumber;
    }

    @Override
    public List<String> fields() {
        List<String> bookFields = super.fields();
        bookFields.add("user");
        return bookFields;
    }
}
