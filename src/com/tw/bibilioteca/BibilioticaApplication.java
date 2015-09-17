package com.tw.bibilioteca;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;

public class BibilioticaApplication {
    private ConsoleDisplay consoleDisplay;
    private BibilioticaData library;

    public void start(InputStream inputStream, OutputStream outputStream) {
        initiateSession(inputStream, outputStream);
        IController controller   = new Controller(consoleDisplay, new WelcomeMessage(), library);
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

    private HashMap<String, EntityDetails> loadMovies() {
        HashMap<String, EntityDetails> movieList = new HashMap<String, EntityDetails>();
        EntityDetails movieDetails1 = new MovieDetails(new Date(), "director1", 10.0);
        String name1 = "name1";
        EntityDetails movieDetails2 = new MovieDetails(new Date(), "director2", 10.0);
        String name2 = "name2";
        EntityDetails movieDetails3 = new MovieDetails(new Date(), "director3", 10.0);
        String name3 = "name3";

        movieList.put(name1, movieDetails1);
        movieList.put(name2, movieDetails2);
        movieList.put(name3, movieDetails3);
        return movieList;
    }

    private void initiateSession(InputStream inputStream, OutputStream outputStream) {
        consoleDisplay = new ConsoleDisplay(inputStream, outputStream);
        Catalog books = new Catalog(loadBooks(), new HashMap<String, EntityDetails>());
        Catalog movies = new Catalog(loadMovies(), new HashMap<String, EntityDetails>());
        library = new BibilioticaData(books, movies);
    }
}
