package com.tw.bibilioteca;

import java.util.HashMap;

public class Catalog {
    private HashMap<String, BookDetails> available_books;
    private HashMap<String, BookDetails> checked_out_books;

    public Catalog(HashMap<String, BookDetails> available_books, HashMap<String, BookDetails> checked_out_books) {
        this.available_books = available_books;
        this.checked_out_books = checked_out_books;
    }

    public boolean isBookAvailableForCheckOut(String bookName) {
        return available_books.containsKey(bookName);
    }

    @Override
    public String toString() {
        String outputString = "";
        for (String name : available_books.keySet()) {
            outputString += name + " ";
            outputString += available_books.get(name).toString() + "\n";
        }
        return outputString;
    }
}
