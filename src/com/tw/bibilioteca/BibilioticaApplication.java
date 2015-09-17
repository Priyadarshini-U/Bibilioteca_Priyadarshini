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
        IController controller   = new Controller(consoleDisplay, new WelcomeMessage(), bookLibrary);
        do {
            controller = controller.executeAction();
        }while(! controller.getClass().equals(ExitController.class));
    }

    private HashMap<String, EntityDetails> loadBooks() {
        HashMap<String, EntityDetails> bookList = new HashMap<String, EntityDetails>();
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
        bookLibrary = new Catalog(loadBooks(), new HashMap<String, EntityDetails>());
    }
}
