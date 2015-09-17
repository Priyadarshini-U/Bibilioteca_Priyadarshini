package com.tw.bibilioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public boolean isBookReturnable(String bookName) {
        return checked_out_books.containsKey(bookName);
    }

    public void checkoutEntity(String bookName) {
        BookDetails bookDetails = available_books.get(bookName);
        checked_out_books.put(bookName, bookDetails);
        available_books.remove(bookName);
    }

    public void returnEntity(String bookName) {
        BookDetails bookDetails = checked_out_books.get(bookName);
        available_books.put(bookName, bookDetails);
        checked_out_books.remove(bookName);
    }

    public List<String> fields() {
        BookDetails entityDetails = null;
        if (available_books.keySet().iterator().hasNext())
            entityDetails = available_books.get(available_books.keySet().iterator().next());
        else
            entityDetails = checked_out_books.get(checked_out_books.keySet().iterator().next());
        List<String> fields = new ArrayList<String>();
        fields.add("name");
        fields.addAll(entityDetails.fields());
        return fields;
    }

    public HashMap<String, BookDetails> getAvailableBooks(){
        return available_books;
    }

    public HashMap<String, BookDetails> getCheckedOutBooks(){
        return checked_out_books;
    }

}
