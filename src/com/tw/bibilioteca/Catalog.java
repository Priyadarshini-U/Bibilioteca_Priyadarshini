package com.tw.bibilioteca;

import java.util.HashMap;

public class Catalog {
    private HashMap<String, BookDetails> books;

    public Catalog(HashMap<String, BookDetails> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        String outputString = "";
        for (String name : books.keySet()) {
            outputString += name + " ";
            outputString += books.get(name).toString() + "\n";
        }
        return outputString;
    }
}
