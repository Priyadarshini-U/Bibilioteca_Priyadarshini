package com.tw.bibilioteca;

import java.util.List;

public class Catalog {
    private List<Book> bookList;

    public Catalog(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        String outputString = "";
        for(Book book : bookList)
            outputString += book.toString()+"\n";
        return outputString;
    }
}
