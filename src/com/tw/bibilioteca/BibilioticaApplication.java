package com.tw.bibilioteca;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;

public class BibilioticaApplication {
    private ConsoleDisplay consoleDisplay;
    private Catalog bookLibrary;

    public void start(InputStream inputStream, OutputStream outputStream) {
        initiateSession(inputStream, outputStream);
        IController controller   = new Controller(consoleDisplay, new WelcomeMessage(), bookLibrary).executeAction();
        controller.executeAction();
    }

    private HashMap<String, BookDetails> loadBooks() {
        HashMap<String, BookDetails> bookList = new HashMap<String, BookDetails>();
        BookDetails bookDetails1 = new BookDetails("author1", new Date());
        String bookName1 = "name1";
        BookDetails bookDetails2 = new BookDetails("author2", new Date());
        String bookName2 = "name2";
        BookDetails bookDetails3 = new BookDetails("author3", new Date());
        String bookName3 = "name3";

        bookList.put(bookName1, bookDetails1);
        bookList.put(bookName2, bookDetails2);
        bookList.put(bookName3, bookDetails3);
        return bookList;
    }

    private void initiateSession(InputStream inputStream, OutputStream outputStream) {
        consoleDisplay = new ConsoleDisplay(inputStream, outputStream);
        bookLibrary = new Catalog(loadBooks(), new HashMap<String, BookDetails>());
    }
}
