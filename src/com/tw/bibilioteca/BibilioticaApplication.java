package com.tw.bibilioteca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BibilioticaApplication {

    public void start() {
        System.out.println("Welcome to bibiliotica");
    }

    private List<Book> loadBooks() {
        List<Book> bookList = new ArrayList<Book>();
        Book book1 = new Book("name1", "author1", new Date());
        Book book2 = new Book("name2", "author2", new Date());
        Book book3 = new Book("name3", "author3", new Date());
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        return bookList;
    }
}
